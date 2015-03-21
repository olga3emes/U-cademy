package controllers.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

import services.AcademyService;
import services.OwnerService;
import controllers.AbstractController;
import domain.Academy;

@Controller
@RequestMapping("payment/owner")
public class PaymentOwnerController extends AbstractController {
	//Services
	@Autowired
	private AcademyService academyService;
	
	@Autowired
	private OwnerService ownerService;
	
//	@Autowired
//	private PaymentService;
	
	// Constructors -----------------------------------------------------------

	public PaymentOwnerController() {
		super();
	}
	
	//Create a payment
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public ModelAndView  finishPayment(@RequestParam int academyId, @RequestParam String paymentId,
			@RequestParam boolean isPremium, @RequestParam String token, @RequestParam String PayerID){
		ModelAndView result = null;
		Academy academy = academyService.findOne(academyId);
		Assert.notNull(academy);
		Assert.isTrue(academy.getOwner().getId() == ownerService.findByPrincipal().getId());
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		
		String accessToken = getAccessToken();
		APIContext apiContext = new APIContext(accessToken);
		apiContext.setConfigurationMap(sdkConfig);
		
		
		Payment payment = new Payment();
		Payment finalPayment = new Payment();
		payment.setId(paymentId);
		PaymentExecution paymentExecute = new PaymentExecution();
		paymentExecute.setPayerId(PayerID);
		try {
			finalPayment = payment.execute(apiContext, paymentExecute);
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(isPremium){
				academy.setIsPremium(true);
			}else{
				
			}
		}
//		result = new ModelAndView("petOnSale/ok");
//		
//		result.addObject("payId", finalPayment.getId());
//		result.addObject("payerId", finalPayment.getPayer().getPayerInfo().getPayerId());
//		result.addObject("state", finalPayment.getState());
		return null;
		
	}
	
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public ModelAndView  createPayment(@RequestParam int academyId,@RequestParam boolean isPremium){
		Academy academy = academyService.findOne(academyId);
		Assert.notNull(academy);
		Assert.isTrue(academy.getOwner().getId() == ownerService.findByPrincipal().getId());
		String rest = getAccessToken();
		
		Payment payment = passTwo(rest,academyId,isPremium);
		
		return new ModelAndView("redirect:"+payment.getLinks().get(1).getHref());
	}
	
	private Payment passTwo(String rest, int academyId, boolean premium) {
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		Payment createdPayment = null;
		String accessToken = rest;
		APIContext apiContext = new APIContext(accessToken);
		apiContext.setConfigurationMap(sdkConfig);

		Amount amount = new Amount();
		Transaction transaction = new Transaction();
		
		if(premium){
			amount.setCurrency("EUR");
			amount.setTotal("30");
			transaction.setDescription("Subcription");
			transaction.setAmount(amount);
			Item item = new Item();
			item.setName("premium subscripction").setQuantity("1").setCurrency("EUR").setPrice("30");
			ItemList itemList = new ItemList();
			List<Item> items = new ArrayList<Item>();
			items.add(item);
			itemList.setItems(items);
			transaction.setItemList(itemList);
		}else{
			amount.setCurrency("EUR");
			amount.setTotal("12");
			transaction.setDescription("Subcription");
			transaction.setAmount(amount);
			Item item = new Item();
			item.setName("basic subscripction").setQuantity("1").setCurrency("EUR").setPrice("12");
			ItemList itemList = new ItemList();
			List<Item> items = new ArrayList<Item>();
			items.add(item);
			itemList.setItems(items);
			transaction.setItemList(itemList);
		}

		
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/U-cademy");
		redirectUrls.setReturnUrl("http://localhost:8080/U-cademy/payment/owner/finish.do?academyId="+academyId+"&isPremium="+premium);
		payment.setRedirectUrls(redirectUrls);

		try {
			createdPayment = payment.create(apiContext);
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createdPayment;
	}
	
	private String getAccessToken() {
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		String accessToken = null;
		
		try {
			accessToken = new OAuthTokenCredential("AQkquBDf1zctJOWGKWUEtKXm6qVhueUEMvXO_-MCI4DQQ4-LWvkDLIN2fGsd", "EL1tVxAjhT7cJimnz5-Nsx9k2reTKSVfErNQF-CmrwJgxRtylkGTKlU4RvrX", sdkConfig).getAccessToken();
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		
		return accessToken;
	}
}

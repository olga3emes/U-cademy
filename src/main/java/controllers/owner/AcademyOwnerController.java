
package controllers.owner;

import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import services.OwnerService;
import controllers.AbstractController;
import domain.Academy;
import forms.AcademyForm;

@Controller
@RequestMapping("academy/owner")
public class AcademyOwnerController extends AbstractController {

	//Services
	
	@Autowired
	private AcademyService academyService;
	
	//@Autowired
	private OwnerService ownerService;
	
	// Constructors -----------------------------------------------------------

	public AcademyOwnerController() {
		super();
	}

	// List academies ---------------------------------------------------------------		
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		result = new ModelAndView("academy/list");
		
		try {
			Collection<Academy> academies = academyService.findAcademyByOwner(11/*ownerService.findByPrincipal().getId()*/);
			
			result.addObject("academies", academies);
			result.addObject("requestURI", "academy/owner/list.do");
		} catch (Exception e) {
			//TODO Poner vista del error discreto
		}
		return result;
		
	}
	
	// Create academy ---------------------------------------------------------------		

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		
		AcademyForm academyForm = new AcademyForm();
		
		result = createCreateAcademyModelAndView(academyForm);
		
		return result;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST, params="save")
	public ModelAndView saveCreate(@Valid AcademyForm academyForm, BindingResult binding){
		ModelAndView result;
		
		if (binding.hasErrors()) {
			result = createCreateAcademyModelAndView(academyForm);
		} else {
			try {
				byte[] data = academyForm.getMultipartFile().getBytes();
				Academy academy = academyService.reconstruct(academyForm, data);				
				academyService.save(academy);
				
				result =  new ModelAndView("redirect:/list.do");
			}catch (Throwable oops) {
				result = createCreateAcademyModelAndView(academyForm, "academy.commit.error");				
			}
		}

		return result;
		
	}
	
	// Edit an academy --------------------------------------------------------------
	
	
		
	// Ancillary methods ------------------------------------------------------------
		
	protected ModelAndView createCreateAcademyModelAndView(AcademyForm academyForm) {
		ModelAndView result;

		result = createCreateAcademyModelAndView(academyForm, null);
		
		return result;
	}	
	
	protected ModelAndView createCreateAcademyModelAndView(AcademyForm academyForm, String message) {
		ModelAndView result;
		
		result = new ModelAndView("academy/create");
		
		result.addObject("academyForm", academyForm);
		result.addObject("message",message);
		result.addObject("actionURI","academy/owner/create.do");
		return result;
		
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
	ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
		new ByteArrayMultipartFileEditor());
	}

}
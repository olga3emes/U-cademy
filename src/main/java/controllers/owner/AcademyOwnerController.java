
package controllers.owner;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
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
	//private OwnerService ownerService;
	
	// Constructors -----------------------------------------------------------

	public AcademyOwnerController() {
		super();
	}

	// List academies ---------------------------------------------------------------		
	/*
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		
		Collection<Academy> academies = academyService.findAll(ownerService.findByPrincipal());
		
		result = new ModelAndView("academy/list");
		
		result.addObject("academies", academies);
		result.addObject("requestURI", "academy/owner/list.do");
		
		return result;
		
	}
	*/
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
				Academy academy = academyService.reconstruct(academyForm);				
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
	
}
package controllers;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academy;
import services.AcademyService;


@Controller
@RequestMapping("/academy")
public class AcademyController extends AbstractController{
	
	// Constructors -----------------------------------------------------------
	
		public AcademyController() {
			super();
		}
		
	// DEPENDENCIES
		@Autowired
		private AcademyService academyService;
		
		@RequestMapping(value="/search", method = RequestMethod.GET)
		public ModelAndView search(@NotNull @Valid @RequestParam String s){
			
			ModelAndView result;
			Collection<Academy> academies;
			
			academies= academyService.search(s);
			
			result = new ModelAndView("academy/search");
			result.addObject("academies", academies);
			result.addObject("requestURI", "academy/search.do");
			
			return result;
			
		}

}

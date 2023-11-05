package br.com.mercuryviagens.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class AuthController {

	@GetMapping
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	
}

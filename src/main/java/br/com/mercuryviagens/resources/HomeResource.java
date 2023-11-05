package br.com.mercuryviagens.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mercuryviagens.domain.PacoteViagem;
import br.com.mercuryviagens.service.PacoteViagemService;

@Controller
@RequestMapping(value = "/")
public class HomeResource {

	@Autowired
	private PacoteViagemService pacoteService; 
	
	@GetMapping
	public String home(Model model) {
		
		List<PacoteViagem> pacotes = pacoteService.findAll();
		model.addAttribute("pacotes", pacotes);
		
		return "home";
	}
}

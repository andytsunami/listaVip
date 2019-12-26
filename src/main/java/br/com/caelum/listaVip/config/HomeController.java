package br.com.caelum.listaVip.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("listaConvidados")
	public String listaConvidados() {
		return "listaConvidados";
	}

}

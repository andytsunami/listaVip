package br.com.caelum.listaVip.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Configuracao {
	
	@RequestMapping("/")
	@ResponseBody
	public String ola(){
		return "<marquee>Olá, bem vindo ao sistema de lista vip! <blink><b>Topzeira!</b></blink></marquee>";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
}
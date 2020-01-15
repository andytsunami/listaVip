package br.com.caelum.listaVip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.caelum.listaVip.model.Convidado;
import br.com.caelum.listaVip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {
	
	
	@Autowired
	private ConvidadoRepository repository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("listaConvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = repository.findAll();
		
		model.addAttribute("convidados",convidados);
		
		return "listaConvidados";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome")String nome, @RequestParam("email")String email, @RequestParam("telefone") String telefone, Model model) {
		
		Convidado convidado = new Convidado(nome, email, telefone);
		repository.save(convidado);
		
		Iterable<Convidado> convidados = repository.findAll();
		model.addAttribute("convidados", convidados);
		
		return "listaConvidados";
		
	}

}

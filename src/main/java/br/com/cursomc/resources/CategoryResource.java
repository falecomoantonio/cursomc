package br.com.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

	public CategoryResource() {

	}
	

	@RequestMapping(method=RequestMethod.GET)
	public String all() {
		return "Rest Funcionando";
	}

}

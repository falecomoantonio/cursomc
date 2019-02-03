package br.com.cursomc.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.curstomc.domain.Category;


@RestController
public class CategoryResource {
	

	@RequestMapping(value="/categories/list",method=RequestMethod.GET)
	public List<Category> list() {
		
		List<Category> list = new ArrayList<>();
		
		list.add(new Category(1,"Categoria 1","categoria_1"));
		list.add(new Category(2,"Categoria 2","categoria_2"));
		list.add(new Category(3,"Categoria 3","categoria_3"));
		list.add(new Category(4,"Categoria 4","categoria_4"));
		list.add(new Category(5,"Categoria 5","categoria_5"));
		list.add(new Category(6,"Categoria 6","categoria_6"));
		list.add(new Category(7,"Categoria 7","categoria_7"));
		list.add(new Category(8,"Categoria 8","categoria_8"));
		list.add(new Category(9,"Categoria 9","categoria_9"));
		 
		return list;
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
	public Category show( @PathVariable(value = "id") Integer id ) {
		
		if( id == null ) {
			return null;
		}
		
		String name = String.format("Categoria %d", id);
		String slug = String.format("categoria_%d", id);
		
		Category cat = new Category(id, name, slug);
	
		
		return cat;
	}

}

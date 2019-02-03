package br.com.cursomc.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.Category;
import br.com.cursomc.services.CategoryService;


@RestController
@RequestMapping(value="categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Category>> list() {
		List<Category> lst = this.service.list();	
		
		if(lst.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lst);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> show( @PathVariable(value = "id") Integer id ) {
				
		Category cat = this.service.searchById(id);	
	
		if(cat == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok( cat );
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> store( @RequestBody Category entity ) {
		entity = this.service.save(entity);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(entity.getId())
				  .toUri();
		return ResponseEntity.created(location).build();
	}

}

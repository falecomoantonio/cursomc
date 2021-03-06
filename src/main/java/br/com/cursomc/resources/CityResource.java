package br.com.cursomc.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.City;
import br.com.cursomc.services.CityService;


@RestController
@RequestMapping(value="cities")
public class CityResource {
	
	@Autowired
	private CityService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<City>> list() {
		List<City> lst = this.service.list();	
		
		if(lst.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lst);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> show( @PathVariable(value = "id") Integer id ) throws Exception {
		City cat = this.service.searchById(id);	
		return ResponseEntity.ok( cat );
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> store( @RequestBody City entity ) {
		entity = this.service.save(entity);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(entity.getId())
				  .toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> update( @RequestBody City entity, @PathVariable(value = "id") Integer id) {
		entity.setId(id);
		this.service.update(entity);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete( @PathVariable(value = "id") Integer id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

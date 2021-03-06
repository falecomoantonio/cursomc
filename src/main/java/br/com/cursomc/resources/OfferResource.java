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

import br.com.cursomc.domain.Offer;
import br.com.cursomc.services.OfferService;

@RestController
@RequestMapping(value="offers")
public class OfferResource {

	@Autowired
	private OfferService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Offer>> list() {
		List<Offer> list = this.service.list();
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Offer> show( @PathVariable("id") Integer id){
		Offer offer = this.service.findById(id);
		return ResponseEntity.ok( offer );
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> store( @RequestBody Offer offer) {
		offer = this.service.save(offer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(offer.getId())
				  .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update( @RequestBody Offer entity, @PathVariable(value = "id") Integer id) {
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

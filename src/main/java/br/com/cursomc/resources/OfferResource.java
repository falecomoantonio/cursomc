package br.com.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}

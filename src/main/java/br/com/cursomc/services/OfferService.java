package br.com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Offer;
import br.com.cursomc.repositories.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository repository;
	
	public List<Offer> list() {
		return this.repository.findAll();
	}

}

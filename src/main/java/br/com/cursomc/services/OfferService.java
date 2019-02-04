package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Offer;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.exceptions.UnprocessableEntityException;
import br.com.cursomc.repositories.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository repository;
	
	public List<Offer> list() {
		return this.repository.findAll();
	}
	
	public Offer findById( final Integer id ) {
		Optional<Offer> offer = this.repository.findById(id);
		return offer.orElseThrow(()->new ObjectNotFoundException("Oferta Não Encontrada"));
	}
	
	public void delete(final Integer id){
		this.repository.deleteById(id);
	}
	
	public Offer update(Offer entity) {
		entity = this.repository.save(entity);
		if(entity == null) {
			throw new UnprocessableEntityException("Não Foi Possível Atualizar o Produto");
		}
		return entity;
	}
	
	public Offer save( Offer entity ) {
		entity.setId(null);
		entity = this.repository.save(entity);
		if(entity == null) {
			throw new UnprocessableEntityException("Não Foi Possível Registrar o Produto");
		}
		return entity;
	}
	
}

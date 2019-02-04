package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.State;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.exceptions.UnprocessableEntityException;
import br.com.cursomc.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;

	public List<State> list() {
		List<State> objects = this.repository.findAll();
		return objects;
	}
	
	/**
	public State searchByField( final String field, final String value ) throws Exception {
		this.repository.findByField(field,value);
		
		return null;
	}
	**/
	
	public State searchById( Integer id ) throws Exception {
		Optional<State> object = this.repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException("Estado Não Encontrado"));
	}
	
	public void delete(final Integer id){
		this.repository.deleteById(id);
	}

	
	public State update( State entity) {
		entity = this.repository.save(entity);
		if(entity == null) {
			throw new UnprocessableEntityException("Não Foi Possível Atualizar o Estado");
		}
		return entity;
	}
		
	
	public State save( State object ) {
		object.setId(null);
		object = this.repository.save(object);
		if(object==null) {
			throw new UnprocessableEntityException("Não foi possível registrar o Estado ");
		}
		return object;
	}

}

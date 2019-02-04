package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.City;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.exceptions.UnprocessableEntityException;
import br.com.cursomc.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;

	public List<City> list() {
		List<City> objects = this.repository.findAll();
		return objects;
	}
	
	/**
	public City searchByField( final String field, final String value ) throws Exception {
		this.repository.findByField(field,value);
		
		return null;
	}
	**/
	
	public City searchById( Integer id ) throws Exception {
		Optional<City> object = this.repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException("Cidade Não Encontrada"));
	}
	
	public void delete(final Integer id){
		this.repository.deleteById(id);
	}

	
	public City update( City entity ) {
		entity = this.repository.save(entity);
		if(entity == null) {
			throw new UnprocessableEntityException("Não Foi Possível Atualizar a Cidade");
		}
		return entity;
	}
		
	
	public City save( City object ) {
		object.setId(null);
		object = this.repository.save(object);
		if(object==null) {
			throw new UnprocessableEntityException("Não foi possível registrar a Cidade");
		}
		return object;
	}

}

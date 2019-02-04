package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Category;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.exceptions.UnprocessableEntityException;
import br.com.cursomc.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	public List<Category> list() {
		List<Category> objects = this.repository.findAll();
		return objects;
	}
	
	/**
	public Category searchByField( final String field, final String value ) throws Exception {
		this.repository.findByField(field,value);
		
		return null;
	}
	**/
	
	public Category searchById( Integer id ) throws Exception {
		Optional<Category> object = this.repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException("Categoria Não Encontrada"));
	}
	
	public void delete(final Integer id){
		this.repository.deleteById(id);
	}

	
	public Category update( Category entity) {
		entity = this.repository.save(entity);
		if(entity == null) {
			throw new UnprocessableEntityException("Não Foi Possível Atualizar a Categoria");
		}
		return entity;
	}
		
	
	public Category save( Category object ) {
		object.setId(null);
		object = this.repository.save(object);
		if(object==null) {
			throw new UnprocessableEntityException("Não foi possível registrar a categoria");
		}
		return object;
	}

}

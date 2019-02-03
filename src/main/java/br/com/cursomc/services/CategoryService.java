package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Category;
import br.com.cursomc.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	public List<Category> list() {
		List<Category> objects = this.repository.findAll();
		return objects;
	}
	
	public Category searchById( Integer id ) {
		Optional<Category> object = this.repository.findById(id);
		return object.orElse(new Category());
	}
	
	public void delete(final Integer id){
		this.repository.deleteById(id);
	}

	
	public Category update( Category object) {
		return this.repository.save(object);
	}
	
	public Category save( Category object ) {
		object.setId(null);
		return this.repository.save(object);
	}

}

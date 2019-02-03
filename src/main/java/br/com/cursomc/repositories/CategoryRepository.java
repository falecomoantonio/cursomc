package br.com.cursomc.repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursomc.domain.Category;

@Repository
@ComponentScan("br.com.cursomc.domain")
public interface CategoryRepository extends JpaRepository<Category, Integer>  {

}

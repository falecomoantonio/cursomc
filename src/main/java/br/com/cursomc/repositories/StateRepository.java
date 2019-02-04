package br.com.cursomc.repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursomc.domain.State;

@Repository
@ComponentScan("br.com.cursomc.domain")
public interface StateRepository extends JpaRepository<State, Integer> {


}

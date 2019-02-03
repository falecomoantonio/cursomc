package br.com.cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CursoMcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

}


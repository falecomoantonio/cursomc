package br.com.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cursomc.domain.Category;
import br.com.cursomc.repositories.CategoryRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class CursoMcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository catrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Category cat0 = new Category(null,"Categoria 0","categoria-0");
		Category cat1 = new Category(null,"Categoria 1","categoria-1");
		Category cat2 = new Category(null,"Categoria 2","categoria-2");
		Category cat3 = new Category(null,"Categoria 3","categoria-3");
		Category cat4 = new Category(null,"Categoria 4","categoria-4");
		Category cat5 = new Category(null,"Categoria 5","categoria-5");
		Category cat6 = new Category(null,"Categoria 6","categoria-6");
		Category cat7 = new Category(null,"Categoria 7","categoria-7");
		Category cat8 = new Category(null,"Categoria 8","categoria-8");
		Category cat9 = new Category(null,"Categoria 9","categoria-9");
		
		this.catrepo.saveAll(Arrays.asList(cat0,cat1,cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9));
		
	}


}


package br.com.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cursomc.domain.Category;
import br.com.cursomc.domain.Offer;
import br.com.cursomc.repositories.CategoryRepository;
import br.com.cursomc.repositories.OfferRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class CursoMcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository catrepo;


	@Autowired
	private OfferRepository offrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Category cat0 = new Category(null,"Categoria 0","categoria-0");
		Offer o1c0 = new Offer(null,"Title Product 1","Content of Product 1",1234.32);
			  o1c0.setCategory(cat0);
		Offer o2c0 = new Offer(null,"Title Product 2","Content of Product 2",1234.32);
		  	  o2c0.setCategory(cat0);
		Offer o3c0 = new Offer(null,"Title Product 3","Content of Product 3",1234.32);
		      o3c0.setCategory(cat0);
		Offer o4c0 = new Offer(null,"Title Product 4","Content of Product 4",1234.32);
		      o4c0.setCategory(cat0);
		cat0.setOffers(Arrays.asList(o1c0,o2c0,o3c0,o4c0));
		
		Category cat1 = new Category(null,"Categoria 1","categoria-1");
		Offer o1c1 = new Offer(null,"Title Product 5","Content of Product 5",1234.32);
		  	  o1c1.setCategory(cat1);
		Offer o2c1 = new Offer(null,"Title Product 6","Content of Product 6",1234.32);
	  	  	  o2c1.setCategory(cat1);
		Offer o3c1 = new Offer(null,"Title Product 7","Content of Product 7",1234.32);
	  	      o3c1.setCategory(cat1);
		Offer o4c1 = new Offer(null,"Title Product 8","Content of Product 8",1234.32);
	  	      o4c1.setCategory(cat1);
		cat1.setOffers(Arrays.asList(o1c1,o2c1,o3c1,o4c1));
		
		
		Category cat2 = new Category(null,"Categoria 2","categoria-2");
		Category cat3 = new Category(null,"Categoria 3","categoria-3");
		Category cat4 = new Category(null,"Categoria 4","categoria-4");
		Category cat5 = new Category(null,"Categoria 5","categoria-5");
		Category cat6 = new Category(null,"Categoria 6","categoria-6");
		Category cat7 = new Category(null,"Categoria 7","categoria-7");
		Category cat8 = new Category(null,"Categoria 8","categoria-8");
		Category cat9 = new Category(null,"Categoria 9","categoria-9");
		
		this.catrepo.saveAll(Arrays.asList(cat0,cat1,cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9));
		this.offrepo.saveAll(Arrays.asList(o1c0,o2c0,o3c0,o4c0,o1c1,o2c1,o3c1,o4c1));
		
	}


}


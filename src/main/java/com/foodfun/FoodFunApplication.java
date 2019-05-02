package com.foodfun;

import com.foodfun.domain.Ingrediente;
import com.foodfun.domain.Lanche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.foodfun.repositories.LancheRepository;
import com.foodfun.repositories.IngredienteRepository;
import java.util.Arrays;

@SpringBootApplication
public class FoodFunApplication implements CommandLineRunner{
        @Autowired
	private LancheRepository lancheRepository;
	@Autowired
	private IngredienteRepository ingredienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(FoodFunApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Lanche l1 = new Lanche(null,"X-Bacon");
        Lanche l2 = new Lanche(null,"X-Burger");
        Lanche l3 = new Lanche(null,"X-Egg");
        Lanche l4 = new Lanche(null,"X-Egg Bacon");
        
        Ingrediente ingAlface = new Ingrediente(null,"Alface",0.40);
        Ingrediente ingBacon = new Ingrediente(null,"Bacon",2.00);
        Ingrediente ingHamburgerCarne = new Ingrediente(null,"Hamburger de Carne",3.00);
        Ingrediente ingOvo = new Ingrediente(null,"Ovo",0.80);
        Ingrediente ingQueijo = new Ingrediente(null,"Queijo",1.50);
       
        l1.getIngredientes().addAll(Arrays.asList(ingBacon,ingHamburgerCarne,ingQueijo));
        l2.getIngredientes().addAll(Arrays.asList(ingHamburgerCarne,ingQueijo));
        l3.getIngredientes().addAll(Arrays.asList(ingOvo,ingHamburgerCarne,ingQueijo));
        l4.getIngredientes().addAll(Arrays.asList(ingOvo,ingBacon,ingHamburgerCarne,ingQueijo));
        
        
        ingBacon.getLanches().addAll(Arrays.asList(l1,l4));
        ingHamburgerCarne.getLanches().addAll(Arrays.asList(l1,l2,l3,l4));
        ingOvo.getLanches().addAll(Arrays.asList(l3,l4));
        ingQueijo.getLanches().addAll(Arrays.asList(l1,l2,l3,l4));
        
        lancheRepository.saveAll(Arrays.asList(l1, l2, l3 ,l4));
        ingredienteRepository.saveAll(Arrays.asList(ingAlface, ingBacon, ingHamburgerCarne,
                ingOvo, ingQueijo));
    }

}

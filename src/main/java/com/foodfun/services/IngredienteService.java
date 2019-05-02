package com.foodfun.services;

import com.foodfun.domain.Ingrediente;
import com.foodfun.domain.Lanche;
import java.util.Optional;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodfun.repositories.IngredienteRepository;

@Service
public class IngredienteService {
    @Autowired
	private IngredienteRepository ir;
    public Ingrediente find(Integer id) throws ObjectNotFoundException {
		Optional<Ingrediente> obj = ir.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ingrediente.class.getName()));
	}
    
}

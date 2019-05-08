package com.foodfun.services;

import com.foodfun.domain.Ingrediente;
import com.foodfun.domain.Lanche;
import com.foodfun.repositories.IngredienteRepository;
import java.util.Optional;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodfun.repositories.LancheRepository;
import java.util.List;

@Service
public class LancheService {
    @Autowired
    private LancheRepository lr;
    @Autowired
    private IngredienteRepository ir;
    
    public Lanche buscar(Integer id) throws ObjectNotFoundException {
		Optional<Lanche> obj = lr.findById(id);                
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Lanche.class.getName()));
    }
    
    public List<Lanche> listar()  {
	return  lr.findAll();  		
    }
    
    public List<Ingrediente> listarIngredientes()  {
	return  ir.findAll();  		
    }
    
    
    public Lanche inserirIngrediente(Integer id, int idIngrediente){
        Optional<Lanche> objlanche = lr.findById(id);
        Optional<Ingrediente> objing = ir.findById(idIngrediente);
        
        Lanche lanche = objlanche.get();
        Ingrediente ingrediente = objing.get();
        lanche.getIngredientes().add(ingrediente);
        ingrediente.getLanches().add(lanche);
       
      
         final Lanche  updatedObj = lr.save(lanche);
            ir.save(ingrediente);
         
         
        return updatedObj;
        
    }
    public Lanche excluirIngrediente(Integer id, int idIngrediente){
        Optional<Lanche> objlanche = lr.findById(id);
        Optional<Ingrediente> objing = ir.findById(idIngrediente);
        
        Lanche lanche = objlanche.get();
        Ingrediente ingrediente = objing.get();
        lanche.getIngredientes().remove(ingrediente);
        ingrediente.getLanches().remove(lanche);
       
        
         final Lanche updatedObj = lr.save(lanche);
         ir.save(ingrediente);
        return updatedObj;
    }
    
}

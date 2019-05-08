package com.foodfun.resources;

import com.foodfun.domain.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodfun.domain.Lanche;
import javassist.tools.rmi.ObjectNotFoundException;
import com.foodfun.services.LancheService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping(value="/lanches")
public class LancheResource {
	
	@Autowired
	private LancheService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Lanche obj = service.buscar(id);
                return ResponseEntity.ok().body(obj);
	}
        @GetMapping
	public List<Lanche> listar() {
		return  service.listar();
	}
        
        @RequestMapping(value="/ingredientes")
	public List<Ingrediente> listarIngredientes() {
		return  service.listarIngredientes();
	}
        
        @RequestMapping(value="/{id}/{iding}/{qtde}", method=RequestMethod.PUT)
	public ResponseEntity<Lanche> inserirIngrediente(@PathVariable("id") Integer id, 
                @PathVariable("iding") Integer iding,
                @PathVariable("qtde") Integer qtde) {
            
            Lanche obj = null;
            for (int i = 0; i < qtde; i++){  
                obj = service.inserirIngrediente(id, iding);
            }
            return ResponseEntity.ok(obj);
		
	}
        
        @RequestMapping(value="/{id}/{iding}/{qtde}", method=RequestMethod.DELETE)
	public ResponseEntity<Lanche> excluirIngrediente(@PathVariable("id") Integer id, 
                @PathVariable("iding") Integer iding,
                @PathVariable("qtde") Integer qtde)  {
            
        
            Lanche obj = null;
            for (int i = 0; i < qtde; i++){      
                obj = service.excluirIngrediente(id, iding);
            }
            return ResponseEntity.noContent().build();		
	}
        
}
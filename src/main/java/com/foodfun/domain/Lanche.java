package com.foodfun.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lanche implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;
     
    @ManyToMany(mappedBy="lanches")
    private List<Ingrediente> ingredientes = new ArrayList<>();
    
    public Lanche() {}

    public Lanche(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
        this.valor = 0.0;
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public Double getValor() {
        boolean hasAlface;
        boolean hasBacon;
        int qtdeCarne = 0;
        int qtdeQueijo = 0;
        double valorIngHamburger = 0;
        double valorIngQueijo = 0;
        double valorDescCarne = 0;
        double valorDescQueijo = 0;
        double valorDescLight = 0;
        
        hasAlface = ingredienteExiste("Alface");
        hasBacon = ingredienteExiste("Bacon");
        
        for(Ingrediente i: ingredientes){            
           if (i.getNome().equals("Hamburger de Carne")) { 
                qtdeCarne++; 
                valorIngHamburger = i.getValor();
           } 
           if (i.getNome().equals("Queijo")) {
                qtdeQueijo++; 
                valorIngQueijo = i.getValor();
           } 
            this.valor += i.getValor();
        }
        
        if  (qtdeCarne % 3 == 0) {
            int qtde = qtdeCarne /3 ;
            valorDescCarne = qtde * valorIngHamburger;
            
        }
        
        if  (qtdeQueijo % 3 == 0) {
            int qtde = qtdeQueijo /3 ;
             valorDescQueijo = qtde * valorIngQueijo;
           
        }
        
        if (hasAlface && hasBacon) 
            valorDescLight = valor * 0.1;
 
        return valor -= (valorDescCarne+valorDescQueijo+valorDescLight);
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public boolean ingredienteExiste(String nome) {
    return ingredientes.stream().anyMatch((i) -> (i.getNome() == null ? nome == null : i.getNome().equals(nome)));
    }
    
    
    
     
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lanche other = (Lanche) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
        
        
    
}

package com.foodfun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodfun.domain.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}

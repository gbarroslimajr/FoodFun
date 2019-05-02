package com.foodfun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodfun.domain.Lanche;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Integer> {

}

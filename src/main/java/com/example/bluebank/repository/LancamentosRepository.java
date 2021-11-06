package com.example.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bluebank.model.Lancamentos;

@Repository
public interface LancamentosRepository extends JpaRepository<Lancamentos, Integer> {

}

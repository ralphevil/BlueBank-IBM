package com.example.bluebank.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bluebank.model.Conta;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

}

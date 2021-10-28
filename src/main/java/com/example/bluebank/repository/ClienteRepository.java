package com.example.bluebank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.bluebank.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}

package com.example.bluebank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bluebank.model.Conta;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
	
	public List<Conta> findByIdAndIdcliente(int id,int idcliente);
		
		
		
	

}

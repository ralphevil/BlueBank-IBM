package com.example.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bluebank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
	
//	public List<Conta> findByIdAndIdcliente(Integer id,Integer idcliente);
		
		
		
	

}

package com.example.bluebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bluebank.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
    private ClienteRepository clienterepository;
	
	public boolean clienteExiste(int id) {
		return clienterepository.findById(id).isPresent();
	}
	
}

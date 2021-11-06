package com.example.bluebank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.bluebank.dto.ClienteConsultaDTO;
import com.example.bluebank.dto.ClienteRetornoDTO;
import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.model.Cliente;
import com.example.bluebank.model.Conta;
import com.example.bluebank.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
    private ClienteRepository clienterepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public boolean clienteExiste(int id) {
		return clienterepository.findById(id).isPresent();
	}
	
	public List<ClienteRetornoDTO> retornaClientes(ClienteConsultaDTO consulta) {
		Cliente cliente = mapper.map(consulta, Cliente.class);
		List<Cliente> lista  = clienterepository.findAll(Example.of(cliente));
		
		List<ClienteRetornoDTO> listaconvertida = new ArrayList<>();
		for(int c = 0; c < lista.size(); c++) {
			ClienteRetornoDTO ret = mapper.map(lista.get(c), ClienteRetornoDTO.class);
			listaconvertida.add(ret);
		}
		return listaconvertida;
//		//return lista.stream().map(obj-> mapper.map(obj, ContaRetornoDTO.class)).collect(Collectors.toList());
	}
	
}

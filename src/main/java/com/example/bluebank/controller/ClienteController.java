package com.example.bluebank.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.ClienteConsultaDTO;
import com.example.bluebank.dto.ClienteInserirDTO;
import com.example.bluebank.dto.ClienteRetornoDTO;
import com.example.bluebank.model.Cliente;
import com.example.bluebank.repository.ClienteRepository;
import com.example.bluebank.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Clientes"})
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	

	@Autowired
	private ClienteRepository clienterepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ClienteService clienteservice;
	
	@PostMapping
	@ApiOperation(value = "Enviar cadastro de clientes", notes = "Requisição para gravar os dados do cliente, sendo obrigatorio o campo cpf/cnpj")
	public  Cliente novocliente(@RequestBody ClienteInserirDTO clientedto) {
		Cliente cliente = mapper.map(clientedto, Cliente.class);
		clienterepository.save(cliente);
		return cliente;
	}
	
	@ApiOperation(value = "Lista os dados de cliente", notes = "Requisição para buscar por qualquer campo da entidade Cliente.")
	@PostMapping("listar")
	public List<ClienteRetornoDTO> retornaCliente(@RequestBody ClienteConsultaDTO consulta) {
		return clienteservice.retornaClientes(consulta);
	}
	
	/*@GetMapping
	@ApiOperation(value = "Consulta Todos os Clientes", notes = "Requisição para listar todos os clientes")
	public Iterable<Cliente> obterTodosClientes() {
		return clienterepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	@ApiOperation(value = "Consulta Cliente por ID", notes = "Requisição para listar clientes por ID")
	public Optional<Cliente> obterClientePorId(@PathVariable int id) {
		return clienterepository.findById(id);
	}*/
	
	

}

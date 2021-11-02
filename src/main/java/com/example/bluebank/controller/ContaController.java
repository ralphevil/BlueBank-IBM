package com.example.bluebank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.ContaInserirDTO;
import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.model.Conta;
import com.example.bluebank.repository.ContaRepository;
import com.example.bluebank.request.ResponseModel;
import com.example.bluebank.service.ContaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Contas"})
@RestController
@RequestMapping("/api/contas")
public class ContaController {

	@Autowired
	private ContaService contaservice;
	@Autowired
	private ContaRepository contarepository;
	
	
	@PostMapping
	@ApiOperation(value = "Enviar cadastro de contas bancarias", notes = "Requisição para gravar os dados de contas bancarias")
	public ResponseModel<ContaRetornoDTO> novaConta(@RequestBody ContaInserirDTO contadto) {

		return contaservice.inserirConta(contadto);
	}
	
	@GetMapping
	public Iterable<Conta> obterTodasContas() {
		return contarepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Conta> obterContasPorId(@PathVariable int id) {
		return contarepository.findById(id);
	}
	
}

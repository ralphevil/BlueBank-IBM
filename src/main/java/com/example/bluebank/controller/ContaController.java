package com.example.bluebank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.ContaConsultaDTO;
import com.example.bluebank.dto.ContaInserirDTO;
import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.model.Cliente;
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
	@ApiOperation(value = "Lista os dados da conta bancaria", notes = "Requisição para buscar por qualquer campo da entidade contabancaria.")
	@PostMapping("listar")
	public List<ContaRetornoDTO> obterContas(@RequestBody ContaConsultaDTO consulta) {
		return contaservice.retornaTodasContas(consulta);
	}
	
//	@GetMapping
//	public Iterable<Conta> obterTodasContas() {
//		return contarepository.findAll();
//	}
//		
//		
//	@GetMapping("/porid")
//	public Conta obterContasPorId() {
//		Conta c = new Conta();// contarepository.findAll().iterator().next();
//		c.setId(1);
//		c.setNomeagencia("Agencia");
//		System.out.println(c);
//		return c;
//	}
//	
}

package com.example.bluebank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.LancamentoInserirDTO;
import com.example.bluebank.dto.LancamentoRetornoDTO;
import com.example.bluebank.model.Lancamentos;
import com.example.bluebank.repository.ClienteRepository;
import com.example.bluebank.repository.LancamentosRepository;
import com.example.bluebank.request.ResponseModel;
import com.example.bluebank.service.LancamentosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Lancamentos"})
@RestController
@RequestMapping("/api/lancamento")
public class LancamentosController {
	
	@Autowired
	private LancamentosService lancamentosservice;
	@Autowired
	private LancamentosRepository lancamentosrepository;
	@Autowired
	private ClienteRepository clienterepository;
	
	@PostMapping
	@ApiOperation(value = "Lançamentos bancarios", notes = "Requisição para gravar os lancamentos bancarias")
	public ResponseModel<LancamentoRetornoDTO> novoLancamento(@RequestBody LancamentoInserirDTO lancamentodto) {

		return lancamentosservice.inserirLancamento(lancamentodto);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Lancamentos> obterLancamentosPorIdCliente(@PathVariable int id) {

		return lancamentosrepository.findById(id);
	}

}

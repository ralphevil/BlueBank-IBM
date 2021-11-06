package com.example.bluebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.LancamentoConsultaDTO;
import com.example.bluebank.dto.LancamentoInserirDTO;
import com.example.bluebank.dto.LancamentoRetornoDTO;
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

	
	
	
	@PostMapping
	@ApiOperation(value = "Lançamentos bancarios", notes = "Requisição para gravar os lancamentos bancarias")
	public ResponseModel<LancamentoRetornoDTO> novoLancamento(@RequestBody LancamentoInserirDTO lancamentodto) {

		return lancamentosservice.inserirLancamento(lancamentodto);
	}
	
	@PostMapping("listar")
	@ApiOperation(value = "Lista Todas os lancamentos da conta bancaria", notes = "Requisição para buscar por qualquer campo da entidade de Lancamentos de contas bancarias.")
	public List<LancamentoRetornoDTO> obterContas(@RequestBody LancamentoConsultaDTO consulta) {
		return lancamentosservice.retornaTodosLancamentos(consulta);
	}
	
	/*@GetMapping(path="/{id}")
	public Optional<Lancamentos> obterLancamentosPorIdCliente(@PathVariable int id) {

		return lancamentosrepository.findById(id);
	}*/

}

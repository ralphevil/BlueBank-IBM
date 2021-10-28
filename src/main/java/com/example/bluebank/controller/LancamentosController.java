package com.example.bluebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.ContaInserirDTO;
import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.dto.LancamentoInserirDTO;
import com.example.bluebank.dto.LancamentoRetornoDTO;
import com.example.bluebank.request.ResponseModel;
import com.example.bluebank.service.LancamentosService;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentosController {
	
	@Autowired
	private LancamentosService lancamentosservice;
	
	@PostMapping
	public ResponseModel<LancamentoRetornoDTO> novoLancamento(@RequestBody LancamentoInserirDTO lancamentodto) {

		return lancamentosservice.inserirLancamento(lancamentodto);
	}
	

}
package com.example.bluebank.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.ContaInserirDTO;
import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.model.Conta;
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
	
	
	@PostMapping
	@ApiOperation(value = "Enviar cadastro de contas bancarias", notes = "Requisição para gravar os dados de contas bancarias")
	public ResponseModel<ContaRetornoDTO> novaConta(@RequestBody ContaInserirDTO contadto) {

		return contaservice.inserirConta(contadto);
	}
	
}

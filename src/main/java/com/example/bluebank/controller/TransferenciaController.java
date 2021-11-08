package com.example.bluebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebank.dto.ContaInserirDTO;
import com.example.bluebank.dto.TransferenciaDTO;
import com.example.bluebank.request.ResponseModel;
import com.example.bluebank.service.TransferenciaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Transferencias"})
@RestController
@RequestMapping("/api/transferencia")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService transferenciaservice;
	
	@PostMapping
	@ApiOperation(value = "Realizar transferência entre contas bancarias", notes = "Requisição para transferir valores entre contas bancárias")
	public ResponseModel<TransferenciaDTO> realizarTransferencia(@RequestBody TransferenciaDTO transdto) {
		return transferenciaservice.efetuarTransferencia(transdto);
	}

}

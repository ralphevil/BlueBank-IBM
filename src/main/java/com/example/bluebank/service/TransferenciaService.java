package com.example.bluebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bluebank.dto.TransferenciaDTO;
import com.example.bluebank.model.Conta;
import com.example.bluebank.repository.ContaRepository;
import com.example.bluebank.request.ResponseModel;

@Service
public class TransferenciaService {
	
	@Autowired
	private LancamentosService lancamentoservice;
	
	@Autowired
	private ContaRepository contarepository;
	
	public ResponseModel<TransferenciaDTO> efetuarTransferencia(TransferenciaDTO transdto){	
		if (!verificaContas(transdto.getIdcontaprincipal(), transdto.getIdcontafavorecido())) throw new RuntimeException("Não foi possível encontrar a conta principal e/ou do favorecido");
		if (!verificaSaldo(transdto.getIdcontaprincipal(), transdto.getValor())) throw new RuntimeException("O valor inserido para transferência é menor ou excede o saldo disponível");
		
		lancamentoservice.lancamanual(transdto.getIdcontaprincipal(), transdto.getValor(), "Transferência","D");
		lancamentoservice.lancamanual(transdto.getIdcontafavorecido(), transdto.getValor(), "Transferência","C");
		
		ResponseModel<TransferenciaDTO> retorno = new ResponseModel<>();
		
		retorno.setStatus("ok");
		retorno.setMensagem("Transferência realizada com sucesso!");
		retorno.setData(transdto);
		
		return retorno;
	}
	
	public boolean verificaContas(int idcontaprincipal, int idcontafavorecido) {
		if (!contarepository.findById(idcontaprincipal).isPresent() && !contarepository.findById(idcontafavorecido).isPresent()) return false;
		return true;
	}
	
	public boolean verificaSaldo(int idcontaprincipal, double valor) {
		Conta conta = contarepository.findById(idcontaprincipal).get();
		if (valor > conta.getSaldo() || valor < conta.getSaldo()) return false;
		return true;
	}	
}




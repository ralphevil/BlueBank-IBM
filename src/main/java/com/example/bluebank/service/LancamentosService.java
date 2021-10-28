package com.example.bluebank.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.dto.LancamentoInserirDTO;
import com.example.bluebank.dto.LancamentoRetornoDTO;
import com.example.bluebank.model.Conta;
import com.example.bluebank.model.Lancamentos;
import com.example.bluebank.repository.ClienteRepository;
import com.example.bluebank.repository.ContaRepository;
import com.example.bluebank.repository.LancamentosRepository;
import com.example.bluebank.request.ResponseModel;

@Service
public class LancamentosService {
	
	@Autowired
	private LancamentosRepository lancamentosrepository;
	@Autowired
	private ContaRepository contarepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private ModelMapper mapper;
	
	public ResponseModel<LancamentoRetornoDTO> inserirLancamento(LancamentoInserirDTO lancadto){
		
		Lancamentos lancamentos = mapper.map(lancadto, Lancamentos.class);
		lancamentosrepository.save(lancamentos);
		
		ResponseModel<LancamentoRetornoDTO> retorno = new ResponseModel<>();
		
		retorno.setStatus("ok");
		retorno.setMensagem("");
		retorno.setData(mapper.map(lancamentos, LancamentoRetornoDTO.class));
		
		return retorno;
		
		
	}
	
}

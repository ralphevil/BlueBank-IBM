package com.example.bluebank.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bluebank.dto.ContaInserirDTO;
import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.model.Conta;
import com.example.bluebank.model.Lancamentos;
import com.example.bluebank.repository.ContaRepository;
import com.example.bluebank.repository.LancamentosRepository;
import com.example.bluebank.request.ResponseModel;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contarepository;
	
	@Autowired
	private ClienteService clienteservice;
	
	@Autowired
	private LancamentosService lancamentoservice;
	
	@Autowired
	private ModelMapper mapper;

	public ResponseModel<ContaRetornoDTO> inserirConta(ContaInserirDTO contadto) {

		if(!clienteservice.clienteExiste(contadto.getIdcliente())) {
		throw new RuntimeException("Cliente não existe");
		}
		
		
		Conta conta = mapper.map(contadto, Conta.class);
		contarepository.save(conta);
		lancamentoservice.lancamanual(conta.getId(), conta.getSaldoinicial(), "Saldo Inicial","C");
		
	
		ResponseModel<ContaRetornoDTO> retorno = new ResponseModel<>();
		
		retorno.setStatus("ok");
		retorno.setMensagem("");
		retorno.setData(mapper.map(conta, ContaRetornoDTO.class));
		
		return retorno;
		
	}
	
	public boolean contacliente (int id,int idcliente) {
		return contarepository.findByIdAndIdcliente(id, idcliente).size() > 0;
	}
	


	

	
}

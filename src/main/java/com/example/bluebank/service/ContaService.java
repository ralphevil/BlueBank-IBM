package com.example.bluebank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.bluebank.dto.ContaConsultaDTO;
import com.example.bluebank.dto.ContaInserirDTO;
import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.model.Conta;
import com.example.bluebank.repository.ContaRepository;
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
		retorno.setMensagem("Conta inserida com sucesso!");
		retorno.setData(mapper.map(conta, ContaRetornoDTO.class));
		
		return retorno;
		
	}
	
	public boolean contacliente (int id,int idcliente) {
//		return contarepository.findByIdAndIdcliente(id, idcliente).size() > 0;
		return false;
	}
	

	public List<ContaRetornoDTO> retornaTodasContas(ContaConsultaDTO consulta) {
		Conta conta = mapper.map(consulta, Conta.class);
		List<Conta> lista  = contarepository.findAll(Example.of(conta));
		
		List<ContaRetornoDTO> listaconvertida = new ArrayList<>();
		for(int c = 0; c < lista.size(); c++) {
			ContaRetornoDTO ret = mapper.map(lista.get(c), ContaRetornoDTO.class);
			listaconvertida.add(ret);
		}
		return listaconvertida;
//		//return lista.stream().map(obj-> mapper.map(obj, ContaRetornoDTO.class)).collect(Collectors.toList());
	}
	

	
}

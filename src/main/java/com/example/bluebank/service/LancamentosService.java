package com.example.bluebank.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.bluebank.dto.ContaRetornoDTO;
import com.example.bluebank.dto.LancamentoConsultaDTO;
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
	
	@Autowired
	private ContaService contaservice;
	
	public ResponseModel<LancamentoRetornoDTO> inserirLancamento(LancamentoInserirDTO lancadto){
		
		
		if(!contaservice.contacliente(lancadto.getIdconta(), lancadto.getIdcliente())) {
			throw new RuntimeException("Conta não pertence ao cliente");
		}
		
		Lancamentos lancamentos = mapper.map(lancadto, Lancamentos.class);
		lancamentosrepository.save(lancamentos);
		
		ResponseModel<LancamentoRetornoDTO> retorno = new ResponseModel<>();
		
		retorno.setStatus("ok");
		retorno.setMensagem("");
		retorno.setData(mapper.map(lancamentos, LancamentoRetornoDTO.class));
		
		return retorno;
		
		
	}
	
	public LancamentoRetornoDTO lancamanual(Integer idconta,BigDecimal valor,String motivo,String tipo) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Lancamentos lancamento = new Lancamentos();
		lancamento.setData_evento(format.format(new Date()));
		lancamento.setIdconta(idconta);
		Optional<Conta> optconta = contarepository.findById(idconta);
		lancamento.setIdcliente(optconta.get().getIdcliente());
		lancamento.setMotivo(motivo);
		lancamento.setValor(valor);		
		lancamento.setTipo(tipo);
		lancamentosrepository.save(lancamento);
		return mapper.map(lancamento, LancamentoRetornoDTO.class);		
	}
	
	public List<LancamentoRetornoDTO> retornaTodosLancamentos(LancamentoConsultaDTO consulta) {
		Lancamentos lancamento = mapper.map(consulta, Lancamentos.class);
		List<Lancamentos> lista  = lancamentosrepository.findAll(Example.of(lancamento));
		
		List<LancamentoRetornoDTO> listaconvertida = new ArrayList<>();
		for(int c = 0; c < lista.size(); c++) {
			LancamentoRetornoDTO ret = mapper.map(lista.get(c), LancamentoRetornoDTO.class);
			listaconvertida.add(ret);
		}
		return listaconvertida;
//		//return lista.stream().map(obj-> mapper.map(obj, ContaRetornoDTO.class)).collect(Collectors.toList());
	}

}

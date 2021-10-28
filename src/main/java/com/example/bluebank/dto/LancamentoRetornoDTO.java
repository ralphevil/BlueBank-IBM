package com.example.bluebank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LancamentoRetornoDTO {
	
	private int id;
	private int idcliente;
	private int idconta;
	private String data_evento;
	private String tipo;
	private String motivo;
	private double valor;

}

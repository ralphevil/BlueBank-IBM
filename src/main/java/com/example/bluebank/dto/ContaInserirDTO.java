package com.example.bluebank.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContaInserirDTO {

	private int idcliente;
	private String numagencia;
	private String nomeagencia;
	private String numconta;
	private String nomeConta;
	private double saldoinicial;
	
}
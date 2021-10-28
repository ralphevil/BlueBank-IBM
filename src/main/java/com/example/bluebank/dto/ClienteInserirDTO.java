package com.example.bluebank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteInserirDTO {
	
	private String nome;
	private String pessoa;
	private String status;
	private String endereco;
	private String email;
	private String telefone;
	private String celular;
	private String cgc;

}

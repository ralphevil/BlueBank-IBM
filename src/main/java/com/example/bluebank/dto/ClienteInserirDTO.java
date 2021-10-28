package com.example.bluebank.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteInserirDTO {
	
	@ApiModelProperty(value = "nome do cliente", required = true,position = 1)
	private String nome;
	private String pessoa;
	private String status;
	private String endereco;
	private String email;
	private String telefone;
	private String celular;
	private String cgc;

}

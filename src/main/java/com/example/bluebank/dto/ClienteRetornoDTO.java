package com.example.bluebank.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteRetornoDTO {
	
	private Integer id;
	@ApiModelProperty(value = "Nome do cliente, tamanho 100", required = true,position = 1)
	private String nome;
	@ApiModelProperty(value = "Tipo de pessoa se e fisica ou juridica valores (F,J) tamanho 1", required = true,position = 2)
	private String pessoa;
	@ApiModelProperty(value = "Se o cliente e ativo ou inativo valores (A,I), tamanho 100", required = true,position = 3)
	private String status;
	@ApiModelProperty(value = "Endereço do cliente, tamanho 150", required = true,position = 4)
	private String endereco;
	@ApiModelProperty(value = "Email do cliente, tamanho 80", required = true,position = 5)
	private String email;
	@ApiModelProperty(value = "Telefone do cliente, tamanho 14", required = true,position = 6)
	private String telefone;
	@ApiModelProperty(value = "Celular do cliente, tamanho 14", required = true,position = 7)
	private String celular;
	@ApiModelProperty(value = "CPF OU CNPJ do cliente, tamanho 14", required = true,position = 8)
	private String cgc;


}

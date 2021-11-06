package com.example.bluebank.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContaRetornoDTO {
	
	    @ApiModelProperty(value = "ID da tabela conta, tamanho 32 int", required = true,position = 1)
		private Integer id;
	    @ApiModelProperty(value = "ID do cliente, tamanho 32 int", required = true,position = 2)
		private Integer idcliente;
	    @ApiModelProperty(value = "Numero da agencia bancaria, tamanho 10", required = true,position = 3)
		private String numagencia;
	    @ApiModelProperty(value = "Nome da agencia bancaria, tamanho 100", required = true,position = 4)
		private String nomeagencia;
	    @ApiModelProperty(value = "Nome da conta bancaria, tamanho 100", required = true,position = 5)
		private String numconta;
	    @ApiModelProperty(value = "Numero da conta bancaria, tamanho 15", required = true,position = 6)
		private String nomeConta;
		
	}



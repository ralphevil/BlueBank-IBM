package com.example.bluebank.dto;


import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaInserirDTO {
	
	@ApiModelProperty(value = "ID do cliente, tamanho 32 int", required = true,position = 1)
	private Integer idcliente;
	@ApiModelProperty(value = "Numero da agencia bancaria, tamanho 10", required = true,position = 2)
	private String numagencia;
	@ApiModelProperty(value = "Nome da agencia bancaria, tamanho 100", required = true,position = 3)
	private String nomeagencia;
	@ApiModelProperty(value = "Nome da conta bancaria, tamanho 100", required = true,position = 4)
	private String numconta;
	@ApiModelProperty(value = "Numero da conta bancaria, tamanho 15", required = true,position = 5)
	private String nomeConta;
	@ApiModelProperty(value = "Saldo inicial da conta bancaria, tamanho 13 precisao 2", required = true,position = 6)
	private BigDecimal saldoinicial;
	
}

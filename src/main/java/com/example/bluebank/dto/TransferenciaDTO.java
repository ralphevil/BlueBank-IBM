package com.example.bluebank.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferenciaDTO {
	
	@ApiModelProperty(value = "ID da conta principal", required = true,position = 1)
	private int idcontaprincipal;
	@ApiModelProperty(value = "ID da conta favorecida", required = true,position = 2)
	private int idcontafavorecido;
	@ApiModelProperty(value = "Valor da transferencia", required = true,position = 3)
	private double valor;	
}
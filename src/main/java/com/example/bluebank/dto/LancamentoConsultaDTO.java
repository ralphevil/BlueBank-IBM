package com.example.bluebank.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoConsultaDTO {

	@ApiModelProperty(value = "ID da tabela Lancamento, tamanho 32 int", required = true,position = 1)
	private Integer id;
	@ApiModelProperty(value = "ID do Cliente, tamanho 32 int", required = true,position = 2)
	private Integer idcliente;
	@ApiModelProperty(value = "ID da conta bancaria, tamanho 32 int", required = true,position = 3)
	private Integer idconta;
	@ApiModelProperty(value = "Data em que o evento aconteceu", required = true,position = 4)
	private String data_evento;
	@ApiModelProperty(value = "Tipo de transação (D,C)- Debito ou Credito, tamanho 1", required = true,position = 5)
	private String tipo;
	@ApiModelProperty(value = "Motivo da transação Bancaria, tamanho 100", required = true,position = 6)
	private String motivo;
	@ApiModelProperty(value = "Valor da transação, tamanho 13 precisão 2", required = true,position = 7)
	private BigDecimal valor;
	
}

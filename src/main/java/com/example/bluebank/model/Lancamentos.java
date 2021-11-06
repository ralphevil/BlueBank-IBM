package com.example.bluebank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Lancamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Integer id;
	@Column(name = "c_idcliente",columnDefinition = "integer")
	private Integer idcliente;
	@Column(name = "c_idconta",columnDefinition = "integer")
	private Integer idconta;
	@Column(name = "c_dataevento",columnDefinition = "varchar(10)")
	private String data_evento;
	@Column(name = "c_tipo",columnDefinition = "varchar(1)")
	private String tipo;
	@Column(name = "c_motivo",columnDefinition = "varchar(100)")
	private String motivo;
	@Column(name = "c_valor",columnDefinition = "numeric(13,2)")
	private BigDecimal valor;

}

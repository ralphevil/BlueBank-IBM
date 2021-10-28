package com.example.bluebank.model;

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
	private int id;
	@Column(name = "c_idcliente",columnDefinition = "integer")
	private int idcliente;
	@Column(name = "c_idconta",columnDefinition = "integer")
	private int idconta;
	@Column(name = "c_dataevento",columnDefinition = "date")
	private String data_evento;
	@Column(name = "c_tipo",columnDefinition = "varchar(1)")
	private String tipo;
	@Column(name = "c_motivo",columnDefinition = "varchar(100)")
	private String motivo;
	@Column(name = "c_valor",columnDefinition = "numeric(13,2)")
	private boolean valor;

}

package com.example.bluebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private int id;
	@Column(name="c_idcliente",columnDefinition = "integer")
	private int idcliente;
	@Column(name="c_numagencia",columnDefinition = "varchar(10)")
	private String numagencia;
	@Column(name="c_nomeagencia",columnDefinition = "varchar(100)")
	private String nomeagencia;
	@Column(name="c_numconta",columnDefinition = "varchar(15)")
	private String numconta;
	@Column(name="c_nomeconta",columnDefinition = "varchar(100)")
	private String nomeConta;
	@Column(name="c_saldoinicial",columnDefinition = "numeric(13,2)") 
	private double saldoinicial;
	
}

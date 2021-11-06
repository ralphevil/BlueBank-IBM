package com.example.bluebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Integer id;
	@Column(name="c_nome",columnDefinition = "varchar(100)")
	private String nome;
	@Column(name="c_pessoa",columnDefinition = "varchar(1)")
	private String pessoa;
	@Column(name="c_status",columnDefinition = "varchar(1)")
	private String status;
	@Column(name="c_endereco",columnDefinition = "varchar(150)")
	private String endereco;
	@Column(name="c_email",columnDefinition = "varchar(80)")
	private String email;
	@Column(name="c_telefone",columnDefinition = "varchar(14)")
	private String telefone;
	@Column(name="c_celular",columnDefinition = "varchar(14)")
	private String celular;
	@Column(name="c_cgccpf",columnDefinition = "varchar(14)")
	@Size(min=11 ,max=14)
	@NotNull
	private String cgc;
	

}

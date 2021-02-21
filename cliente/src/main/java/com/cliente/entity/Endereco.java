package com.cliente.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "tb_endereco")
@Data
public class Endereco implements Serializable{
	
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id_endereco;
		
		private String logradouro;
		private String nro;
		private String bairro;
		private String cidade;
		private String uf;
		private String CEP;
		
}

package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id_endereco;
	private String logradouro;
	private String nro;
	private String bairro;
	private String cidade;
	private String uf;
	private String CEP;
	
	public EnderecoDTO (Endereco x) {
		id_endereco = x.getId_endereco();
		logradouro = x.getLogradouro();
		nro = x.getNro();
		bairro = x.getBairro();
		cidade = x.getCidade();
		uf = x.getUf();
		CEP = x.getCEP();
	}
}

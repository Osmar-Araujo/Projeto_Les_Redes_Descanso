package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Cliente;
import com.cliente.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String logradouro;
	private String nro;
	private String bairro;
	private String cidade;
	private String uf;
	private String CEP;
	private Cliente cliente;
	
	public EnderecoDTO (Endereco x) {
		id = x.getId();
		logradouro = x.getLogradouro();
		nro = x.getNro();
		bairro = x.getBairro();
		cidade = x.getCidade();
		uf = x.getUf();
		CEP = x.getCEP();
		cliente = x.getCliente();
	}
}

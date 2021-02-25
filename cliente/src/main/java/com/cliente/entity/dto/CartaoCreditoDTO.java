package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Cliente;

import lombok.Data;

@Data
public class CartaoCreditoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nroCartao;
	private String dataValidade;
	private String codigoSegurança;
	private String nome;
	
	private Cliente cliente;

}

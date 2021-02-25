package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Cliente;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	private String senha;
	
	private Cliente cliente;

}

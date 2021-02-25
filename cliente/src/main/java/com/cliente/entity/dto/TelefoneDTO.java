package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String ddd;
	private String numero;
	private Cliente cliente;

}

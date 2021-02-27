package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Cliente;
import com.cliente.entity.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id_usuario;
	private String email;
	private String senha;
	
	private Cliente cliente;
	
	public static UsuarioDTO consumeDTO(Usuario usu) {
		return UsuarioDTO.builder().
				id_usuario(usu.getId_usario()).
				email(usu.getEmail()).
				senha(usu.getSenha()).
				cliente(usu.getCliente()).
				build();
	}
	
	public static Usuario consumeEntity(UsuarioDTO usuDTO) {
		return Usuario.builder().
				id_usario(usuDTO.getId_usuario()).
				email(usuDTO.getEmail()).
				senha(usuDTO.getSenha()).
				cliente(usuDTO.getCliente()).
				build();
	}

}

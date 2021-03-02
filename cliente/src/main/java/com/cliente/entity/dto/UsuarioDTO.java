package com.cliente.entity.dto;

import com.cliente.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Parsable<Usuario> {
	
	private Long id_usuario;
	private String email;
	private String senha;
	private ClienteDTO cliente;
	
	public UsuarioDTO (Usuario entity) {
		this.id_usuario = entity.getId_usario();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
	}
	

	@Override
	public Usuario convert() {
		return new Usuario(this);
	}
	
}

package com.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cliente.entity.dto.Parsable;
import com.cliente.entity.dto.UsuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_usuario")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Parsable<UsuarioDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false, updatable = false)
	private Long id_usario;

	private String email;
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "Id_cliente")
	private Cliente cliente;

	public Usuario(UsuarioDTO dto) {
		this.id_usario = dto.getId_usuario();
		this.email = dto.getEmail();
		this.senha = dto.getSenha();

	}

	@Override
	public UsuarioDTO convert() {
		return new UsuarioDTO(this);
	}
}
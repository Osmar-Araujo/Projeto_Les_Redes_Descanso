package com.cliente.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cliente", nullable = false, updatable = false)
	private Long id_cliente;
	private String nome;
	private Date dtNascimento;
	private String genero;
	private boolean status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn (name = "id_endereco")
	private List<Endereco> endereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn (name = "id_cartaoCredito")
	private List<CartaoCredito> cartao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn (name = "id_telefone")
	private List<Telefone> telefone;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn (name = "id_usuario")
	private List<Usuario> usuario;
	
}

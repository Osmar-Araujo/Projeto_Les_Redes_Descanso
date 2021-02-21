package com.cliente.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "tb_cliente")
@Data
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String CPF;
	private Date dtNascimento;
	private String genero;
	private boolean status;
	
	@OneToMany
	@JoinColumn (name = "id_telefone")
	private Set<Endereco> endereco = new HashSet<>();
	
	/*@OneToMany
	@JoinTable (name = "tb_cartoes_credito")
	private Set<CartaoCredito> cratao = new HashSet<>();*/
	
	/*@OneToMany
	@JoinTable (name = "tb_telefones")
	private Set<Telefone> telefone = new HashSet<>();*/
	
	/*@OneToMany
	@JoinTable (name = "tb_usuarios")
	private Set<Usuario> usuario = new HashSet<>();*/
	
}

package com.cliente.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cliente.entity.dto.ClienteDTO;

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
	
	public Cliente(ClienteDTO dto) {
		this.id_cliente =dto.getId_cliente();
		this.nome = dto.getNome();
		this.dtNascimento = dto.getDtNascimento();
		this.genero = dto.getGenero();
		this.status = dto.isStatus();
		if(!dto.getEndereco().isEmpty()) {
			List<Endereco> listEnd = dto.getEndereco().stream().map(end -> new Endereco(end)).collect(Collectors.toList());
			this.setEndereco(listEnd);
		}
	}
	
}

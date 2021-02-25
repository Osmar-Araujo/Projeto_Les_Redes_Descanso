package com.cliente.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cliente.entity.Cliente;
import com.cliente.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Long id_cliente;
	private String nome;
	private Date dtNascimento;
	private String genero;
	private boolean status;
	private List<Endereco> endereco;
	
	
	/*private Set<CartaoCredito> cartao = new HashSet<>();*/
	
	/*private Set<Telefone> telefone = new HashSet<>();*/
	
	/*private Set<Usuario> usuario = new HashSet<>();*/
	
	public ClienteDTO(Cliente x) {
		id_cliente = x.getId();
		nome = x.getNome();
		dtNascimento = x.getDtNascimento();
		genero = x.getGenero();
		status = x.isStatus();
		endereco = x.getEndereco();
	}
	
}

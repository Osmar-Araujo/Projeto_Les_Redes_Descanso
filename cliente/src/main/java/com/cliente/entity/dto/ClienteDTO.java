package com.cliente.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cliente.entity.CartaoCredito;
import com.cliente.entity.Cliente;
import com.cliente.entity.Endereco;
import com.cliente.entity.Telefone;
import com.cliente.entity.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Long id_cliente;
	private String nome;
	private Date dtNascimento;
	private String genero;
	private boolean status;
	
	private List<Endereco> endereco;
	
	private List<CartaoCredito> cartao;
	
	private List<Telefone> telefone;
	
	private List<Usuario> usuario;
	
	public static ClienteDTO consumeDTO(Cliente cli) {
		return ClienteDTO.builder().
				id_cliente(cli.getId_cliente()).
				nome(cli.getNome()).
				dtNascimento(cli.getDtNascimento()).
				genero(cli.getGenero()).
				status(true).
				endereco(cli.getEndereco()).
				cartao(cli.getCartao()).
				telefone(cli.getTelefone()).
				usuario(cli.getUsuario()).
				build();
	}
	
	public static Cliente consumeEntity(ClienteDTO cliDTO) {
		return Cliente.builder().
				id_cliente(cliDTO.getId_cliente()).
				nome(cliDTO.getNome()).
				dtNascimento(cliDTO.getDtNascimento()).
				genero(cliDTO.getGenero()).
				status(true).
				endereco(cliDTO.getEndereco()).
				cartao(cliDTO.getCartao()).
				telefone(cliDTO.getTelefone()).
				usuario(cliDTO.getUsuario()).
				build();
	}
	
}

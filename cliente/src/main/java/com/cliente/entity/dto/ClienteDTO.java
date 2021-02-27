package com.cliente.entity.dto;

import java.util.Date;
import java.util.List;

import com.cliente.entity.Cliente;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ClienteDTO implements Parsable<Cliente>{
	
	
	private Long id_cliente;
	private String nome;
	private Date dtNascimento;
	private String genero;
	private boolean status;
	
	private List<EnderecoDTO> endereco;
	
	private List<CartaoCreditoDTO> cartao;
	
	private List<TelefoneDTO> telefone;
	
	private List<UsuarioDTO> usuario;
	

	@Override
	public Cliente convert() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

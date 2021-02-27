package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Cliente;
import com.cliente.entity.Endereco;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id_endereco;
	private String logradouro;
	private String nro;
	private String bairro;
	private String cidade;
	private String uf;
	private String CEP;
	private Cliente cliente;
	
	public static EnderecoDTO consumeDTO(Endereco end) {
		return EnderecoDTO.builder().
				id_endereco(end.getId_endereco()).
				logradouro(end.getLogradouro()).
				nro(end.getNro()).
				bairro(end.getBairro()).
				cidade(end.getCidade()).
				uf(end.getUf()).
				CEP(end.getCEP()).
				cliente(end.getCliente()).
				build();
	}
	
	public static Endereco consumeEntity(EnderecoDTO endDTO) {
		return Endereco.builder().
				id_endereco(endDTO.getId_endereco()).
				logradouro(endDTO.getLogradouro()).
				nro(endDTO.getNro()).
				bairro(endDTO.getBairro()).
				cidade(endDTO.getCidade()).
				uf(endDTO.getUf()).
				CEP(endDTO.getCEP()).
				cliente(endDTO.getCliente()).
				build();
	}
	
}

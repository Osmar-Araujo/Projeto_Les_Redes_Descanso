package com.cliente.entity.dto;

import com.cliente.entity.Cliente;
import com.cliente.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO implements Parsable<Endereco> {
	
	private Long id;
	private String logradouro;
	private String nro;
	private String bairro;
	private String cidade;
	private String uf;
	private String CEP;
	private Cliente cliente;
	
	
	public EnderecoDTO (Endereco entity) {
		this.logradouro = entity.getLogradouro();
		this.nro = entity.getNro();
		this.bairro = entity.getBairro();
		this.cidade = entity.getCidade();
		this.uf = entity.getUf();
		this.CEP = entity.getCEP();
		
	}
	public static EnderecoDTO consumeDTO(Endereco end) {
		return EnderecoDTO.builder().
				id(end.getId()).
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
				id(endDTO.getId()).
				logradouro(endDTO.getLogradouro()).
				nro(endDTO.getNro()).
				bairro(endDTO.getBairro()).
				cidade(endDTO.getCidade()).
				uf(endDTO.getUf()).
				CEP(endDTO.getCEP()).
				cliente(endDTO.getCliente()).
				build();
	}

	@Override
	public Endereco convert() {		
		return new Endereco(this);
	}
	
}

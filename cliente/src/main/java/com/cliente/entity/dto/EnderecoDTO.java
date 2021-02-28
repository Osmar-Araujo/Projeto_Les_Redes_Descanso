package com.cliente.entity.dto;

import com.cliente.entity.Cliente;
import com.cliente.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO implements Parsable<Endereco> {
	
	private Long id_endereco;
	private String logradouro;
	private String nro;
	private String bairro;
	private String cidade;
	private String uf;
	private String CEP;
	private Cliente cliente;
	
	}

	@Override
	public Endereco convert() {		
		return new Endereco(this);
	}
	
}
package com.cliente.entity.dto;

import com.cliente.entity.Telefone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO implements Parsable<Telefone> {
	
	
	private Long id_telefone;
	private String ddd;
	private String numero;
	private ClienteDTO cliente;
	
	
	public TelefoneDTO(Telefone tel) {
		this.id_telefone = tel.getId_telefone();
		this.ddd =tel.getDdd();
		this.numero = tel.getNumero();
	}


	@Override
	public Telefone convert() {
		return new Telefone(this);
	}
}

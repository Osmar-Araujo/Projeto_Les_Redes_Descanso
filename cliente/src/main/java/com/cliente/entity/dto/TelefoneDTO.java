package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.Cliente;
import com.cliente.entity.Telefone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelefoneDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id_telefone;
	private String ddd;
	private String numero;
	private Cliente cliente;
	
	public static TelefoneDTO consumeDTO(Telefone tel) {
		return TelefoneDTO.builder().
				id_telefone(tel.getId_telefone()).
				ddd(tel.getDdd()).
				numero(tel.getNumero()).
				cliente(tel.getCliente()).
				build();
	}
	
	public static Telefone consumeEntity(TelefoneDTO teldto) {
		return Telefone.builder().
				id_telefone(teldto.getId_telefone()).
				ddd(teldto.getDdd()).
				numero(teldto.getNumero()).
				cliente(teldto.getCliente()).
				build();
	}

}

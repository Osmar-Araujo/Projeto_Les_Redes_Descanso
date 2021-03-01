package com.cliente.entity.dto;

import com.cliente.entity.Documento;
import com.cliente.entity.tipoDocumento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoDTO implements Parsable<Documento> {

	private Long id_documento;
	private tipoDocumento tpdoc;
	private String numero;
	private String nome;
	private ClienteDTO cliente;

	public DocumentoDTO (Documento entity) {
		this.id_documento = entity.getId_documento();
		this.tpdoc = entity.getTpdoc();
		this.numero = entity.getNumero();
		this.nome = entity.getNome();
	}
	@Override
	public Documento convert() {
		return new Documento(this);
	}
}

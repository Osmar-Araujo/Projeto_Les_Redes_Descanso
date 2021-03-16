package com.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cliente.entity.dto.DocumentoDTO;
import com.cliente.entity.dto.Parsable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_documento")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documento implements Parsable <DocumentoDTO>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_documento")
	private Long id_documento;
	private tipoDocumento tpdoc;
	private String numero;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "Id_cliente")
	private Cliente cliente;
	
	public Documento (DocumentoDTO dto) {
		this.id_documento = dto.getId_documento();
		this.tpdoc = dto.getTpdoc();
		this.numero = dto.getNumero();
		this.nome = dto.getNome();
		
		Cliente cli = new Cliente();
		cli.setId_cliente(dto.getCliente().getId_cliente());
		this.cliente = cli;
	}

	@Override
	public DocumentoDTO convert() {
		return new DocumentoDTO(this);
	}	
}

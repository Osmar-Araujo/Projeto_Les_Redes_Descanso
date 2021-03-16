package com.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cliente.entity.dto.Parsable;
import com.cliente.entity.dto.TelefoneDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_telefone")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone implements Parsable <TelefoneDTO> {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_telefone", nullable = false, updatable = false)
	private Long id_telefone;
	
	private String ddd;
	private String numero;
	private tipoTelefone tptel;
	
	@ManyToOne
	@JoinColumn(name = "Id_cliente")
	private Cliente cliente;

	public Telefone (TelefoneDTO dto) {
		this.id_telefone = dto.getId_telefone();
		this.ddd = dto.getDdd();
		this.numero = dto.getNumero();
		this.tptel =dto.getTptel();
		Cliente cli = new Cliente();
		cli.setId_cliente(dto.getCliente().getId_cliente());
		this.cliente = cli;
	}
	
	
	@Override
	public TelefoneDTO convert() {
		return new TelefoneDTO(this);
	}
}

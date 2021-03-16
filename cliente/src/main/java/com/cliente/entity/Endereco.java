package com.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cliente.entity.dto.EnderecoDTO;
import com.cliente.entity.dto.Parsable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_endereco")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Parsable<EnderecoDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;

	private String logradouro;
	private String nro;
	private String bairro;
	private String cidade;
	private String uf;
	private String CEP;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Endereco(EnderecoDTO dto) {
		this.id = dto.getId_endereco();
		this.logradouro = dto.getLogradouro();
		this.nro = dto.getNro();
		this.bairro = dto.getBairro();
		this.cidade = dto.getCidade();
		this.uf = dto.getUf();
		this.CEP = dto.getCEP();
		
		Cliente cli = new Cliente();
		cli.setId_cliente(dto.getCliente().getId_cliente());
		this.cliente = cli;
	}

	@Override
	public EnderecoDTO convert() {
		return new EnderecoDTO(this);
	}

}

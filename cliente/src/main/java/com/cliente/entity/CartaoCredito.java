package com.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cliente.entity.dto.CartaoCreditoDTO;
import com.cliente.entity.dto.Parsable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cartao_credito")
public class CartaoCredito implements Parsable<CartaoCreditoDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cartao")
	private Long id;
	private String nroCartao;
	private String dataValidade;
	private String codigoSegurança;
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public CartaoCredito(CartaoCreditoDTO dto) {
		this.id = dto.getId();
		this.nroCartao = dto.getNroCartao();
		this.dataValidade = dto.getDataValidade();
		this.codigoSegurança = dto.getCodigoSegurança();
		this.nome = dto.getNome();
		if (this.cliente != null)
			this.cliente = new Cliente(dto.getCliente());

	}

	@Override
	public CartaoCreditoDTO convert() {
		return new CartaoCreditoDTO(this);
	}

}
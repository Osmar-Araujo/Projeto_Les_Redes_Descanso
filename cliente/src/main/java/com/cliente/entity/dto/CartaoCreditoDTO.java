package com.cliente.entity.dto;

import com.cliente.entity.CartaoCredito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class CartaoCreditoDTO implements Parsable<CartaoCredito> {

	private Long id;
	private String nroCartao;
	private String dataValidade;
	private String codigoSeguranca;
	private String nome;

	private ClienteDTO cliente;

	public CartaoCreditoDTO(CartaoCredito entity) {
		this.id = entity.getId();
		this.nroCartao = entity.getNroCartao();
		this.dataValidade = entity.getDataValidade();
		this.codigoSeguranca = entity.getCodigoSeguranca();
		this.nome = entity.getNome();
		if (this.cliente != null)
			this.cliente = new ClienteDTO(entity.getCliente());

	}

	@Override
	public CartaoCredito convert() {
		return new CartaoCredito(this);
	}
}

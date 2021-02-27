package com.cliente.entity.dto;

import java.io.Serializable;

import com.cliente.entity.CartaoCredito;
import com.cliente.entity.Cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartaoCreditoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id_cartao;
	private String nroCartao;
	private String dataValidade;
	private String codigoSeguranca;
	private String nome;
	
	private Cliente cliente;
	
	public static CartaoCreditoDTO consumeDTO(CartaoCredito cartao) {
		return CartaoCreditoDTO.builder().
				id_cartao(cartao.getId_cartao()).
				nroCartao(cartao.getNroCartao()).
				dataValidade(cartao.getDataValidade()).
				codigoSeguranca(cartao.getCodigoSeguranca()).
				nome(cartao.getNome()).
				build();
	}
	
	public static CartaoCredito consumeEntity(CartaoCreditoDTO cartaodto) {
		return CartaoCredito.builder().
				id_cartao(cartaodto.getId_cartao()).
				nroCartao(cartaodto.getNroCartao()).
				dataValidade(cartaodto.getDataValidade()).
				codigoSeguranca(cartaodto.getCodigoSeguranca()).
				nome(cartaodto.getNome()).
				build();
	}

}

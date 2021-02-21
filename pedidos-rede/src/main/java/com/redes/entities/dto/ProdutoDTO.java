package com.redes.entities.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.redes.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String tipo;
	private String descricao;
	private Long quantidade;
	private String cor;
	private String urlfoto;
	private BigDecimal preco;
	
	public ProdutoDTO (Produto x) {
		id = x.getId();
		tipo = x.getTipo();
		descricao = x.getDescricao();
		quantidade = x.getQuantidade();
		cor = x.getCor();
		urlfoto = x.getUrlfoto();
		preco = x.getPreco();
	}
	
}

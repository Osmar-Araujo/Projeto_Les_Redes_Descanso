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
import com.cliente.entity.dto.ClienteDTO;
import com.cliente.entity.dto.Parsable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_cartao_credito")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartaoCredito implements Parsable<CartaoCreditoDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cartao")
	private Long id_cartao;
	
	private String nroCartao;
	private String dataValidade;
	private String codigoSeguranca;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public CartaoCredito(CartaoCreditoDTO dto) {
		
		this.id_cartao = dto.getId_cartao();
		this.nroCartao = dto.getNroCartao();
		this.dataValidade = dto.getDataValidade();
		this.codigoSeguranca = dto.getCodigoSeguranca();
		this.nome = dto.getNome();
		
		Cliente cli = new Cliente();
		cli.setId_cliente(dto.getCliente().getId_cliente());
		this.cliente = cli;

	}

	@Override
	public CartaoCreditoDTO convert() {
		return new CartaoCreditoDTO(this);
	}
}

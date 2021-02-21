package com.redes.entities.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.redes.entities.Pedido;
import com.redes.entities.pedidoStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long IdCliente;
	private Instant moment;
	private pedidoStatus pedidostatus;
	private List<ProdutoDTO> produtos = new ArrayList<>();
	
	public PedidoDTO(Pedido x) {
		
	}

}

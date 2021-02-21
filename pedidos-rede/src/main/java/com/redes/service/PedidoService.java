package com.redes.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redes.entities.Pedido;
import com.redes.entities.Produto;
import com.redes.entities.pedidoStatus;
import com.redes.entities.dto.PedidoDTO;
import com.redes.entities.dto.ProdutoDTO;
import com.redes.repository.PedidoRepository;
import com.redes.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedRep;
	
	@Autowired
	private ProdutoRepository prodRep;
	
	
	@Transactional(readOnly = true)
	public List<PedidoDTO> findAll(){
		List<Pedido> list = pedRep.findAll();
				
		return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public PedidoDTO insert(PedidoDTO dto) {
		Pedido pedido = new Pedido(null, dto.getIdCliente(), Instant.now(),pedidoStatus.EM_PROCESSAMENTO);
		
		for(ProdutoDTO p : dto.getProdutos()) {
			Produto product = prodRep.getOne(p.getId());
			pedido.getProdutos().add(product);
		}
		pedido = pedRep.save(pedido);
		return new PedidoDTO(pedido);
	}
}

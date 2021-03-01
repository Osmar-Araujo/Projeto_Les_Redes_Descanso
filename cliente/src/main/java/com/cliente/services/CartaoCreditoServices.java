package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cliente.entity.CartaoCredito;
import com.cliente.entity.dto.CartaoCreditoDTO;
import com.cliente.repository.CartaoCreditoRepository;

@Service
public class CartaoCreditoServices implements GenericService <CartaoCredito, Long, CartaoCreditoDTO>{
	
	@Autowired
	private CartaoCreditoRepository cartRepo;

	@Override
	public JpaRepository<CartaoCredito, Long> getRepository() {
		
		return cartRepo;
	}
	
	

}

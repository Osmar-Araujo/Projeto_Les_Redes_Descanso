package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.repository.CartaoCreditoRepository;

@Service
public class CartaoCreditoServices {
	
	@Autowired
	private CartaoCreditoRepository cartRepo;
	
	

}

package com.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cliente.entity.CartaoCredito;
import com.cliente.entity.dto.CartaoCreditoDTO;
import com.cliente.repository.CartaoCreditoRepository;

import javassist.NotFoundException;

@Service
public class CartaoCreditoServices {
	
	@Autowired
	private CartaoCreditoRepository cartRepo;
	
	public List<CartaoCredito> findAll(){
		List<CartaoCredito> list = cartRepo.findAll();
		return list;
	}
	
	public CartaoCreditoDTO update(CartaoCreditoDTO cartdto, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o cartão!");
		CartaoCredito cart = cartRepo.findById(id).get();
		
		cart.setNroCartao(cartdto.getNroCartao());
		cart.setCodigoSeguranca(cartdto.getCodigoSeguranca());
		cart.setNome(cartdto.getNome());
		cart.setDataValidade(cartdto.getDataValidade());
		cart.setCliente(cartdto.getCliente());
		
		return CartaoCreditoDTO.consumeDTO(cartRepo.save(cart));
	}
	
	public CartaoCreditoDTO findById(Long id) throws NotFoundException {
		CartaoCredito cart = cartRepo.findById(id).orElseThrow(() -> new NotFoundException("Cartão não encontrado!!!"));
		return CartaoCreditoDTO.consumeDTO(cart);
	}
	
	public void deletar(Long id) {
		cartRepo.deleteById(id);
	}

}

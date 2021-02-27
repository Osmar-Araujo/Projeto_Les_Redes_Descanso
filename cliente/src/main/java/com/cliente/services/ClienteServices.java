package com.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cliente.entity.Cliente;
import com.cliente.entity.dto.ClienteDTO;
import com.cliente.repository.ClienteRepository;

import javassist.NotFoundException;

@Service 
public class ClienteServices {
	
	@Autowired
	ClienteRepository cliRep;
	
	
	public List<Cliente> findAll(){
		List<Cliente> list = cliRep.findAll();
		return list;
	}
	
	
	public ClienteDTO findById(Long id) throws NotFoundException {
		Cliente cli = cliRep.findById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado!!!"));
		return ClienteDTO.consumeDTO(cli) ;
	}
	
	public ClienteDTO salvaCliente(Cliente cliEnt) {
		return ClienteDTO.consumeDTO(cliRep.save(cliEnt));
	}
	
	
	public ClienteDTO update(Cliente cliEnt, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o cadastro!");
		Cliente cliente = cliRep.findById(id).get();
		
		cliente.setNome(cliEnt.getNome());
		cliente.setGenero(cliEnt.getGenero());
		cliente.setDtNascimento(cliEnt.getDtNascimento());
		cliente.setStatus(true);
		cliente.setCartao(cliEnt.getCartao());
		cliente.setEndereco(cliEnt.getEndereco());
		cliente.setTelefone(cliEnt.getTelefone());
		cliente.setUsuario(cliEnt.getUsuario());
		
		return ClienteDTO.consumeDTO(cliRep.save(cliente));
	}
	
	public ClienteDTO inativa(Cliente cliEnt, Long id) {
		Assert.notNull(id,"Não foi possível inativar o cliente!");
		Cliente cliente = cliRep.findById(id).get();
		
		cliente.setStatus(false);		
		return ClienteDTO.consumeDTO(cliRep.save(cliente));			
	}
	
	public ClienteDTO ativa(Cliente cliEnt, Long id) {
		Assert.notNull(id,"Não foi possível ativar o cliente!");
		Cliente cliente = cliRep.findById(id).get();
		
		cliente.setStatus(true);		
		return ClienteDTO.consumeDTO(cliRep.save(cliente));			
	}

}

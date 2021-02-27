package com.cliente.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cliente.entity.Cliente;
import com.cliente.entity.dto.ClienteDTO;
import com.cliente.repository.ClienteRepository;

@Service 
public class ClienteServices {
	
	@Autowired
	private ClienteRepository cliRep;
	
	
	public List<ClienteDTO> findAll(){
		List<Cliente> list = cliRep.findAll();
		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
	}
	
	
	
	public Optional<Cliente> findById(Long id) {
		Optional<Cliente> op = cliRep.findById(id);
		return op;
	}
	
	public Cliente salvaCliente(Cliente cliEnt) {
		return cliRep.save(cliEnt);
	}
	
	
	public Cliente update(Cliente cliEnt, Long id) throws Exception {
		Assert.notNull(id,"Não foi possível atualizar o cadastro!");
		
		Optional<Cliente> optional = findById(id);
		if (optional.isPresent()) {
			Cliente client = optional.get();
			client.setNome(cliEnt.getNome());
			client.setDtNascimento(cliEnt.getDtNascimento());
			client.setGenero(cliEnt.getGenero());
			client.setStatus(true);	
			client.setEndereco(cliEnt.getEndereco());
						
			return cliRep.save(client);
			
		}else {
			throw new Exception("Não foi possível atualizar o cadastro!");
		}
	}
	
	public Cliente alteraStatus(Cliente cliEnt, Long id) throws Exception {
		Assert.notNull(id,"Não foi possível inativar o cliente!");
		
		Optional<Cliente> optional = findById(id);
		if (optional.isPresent()) {
			Cliente client = optional.get();
			client.setStatus(false);		
						
			return cliRep.save(client);
			
		}else {
			throw new Exception("Não foi possível inativar o cliente!");
		}
	}

}

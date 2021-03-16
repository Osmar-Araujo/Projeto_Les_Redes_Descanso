package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cliente.entity.Cliente;
import com.cliente.entity.dto.ClienteDTO;
import com.cliente.repository.ClienteRepository;

@Service
public class ClienteServices implements GenericService<Cliente, Long, ClienteDTO> {

	@Autowired
	ClienteRepository repository;

	@Override
	public JpaRepository<Cliente, Long> getRepository() {
		return repository;
	}

	public ClienteDTO inativa(Long id) {
		Assert.notNull(id, "Não foi possível inativar o cliente!");
		Cliente cliente = this.getRepository().findById(id).get();
		cliente.setStatus(false);
		return new ClienteDTO((repository.save(cliente)));
	}

	public ClienteDTO ativa(Long id) {
		Assert.notNull(id, "Não foi possível ativar o cliente!");
		Cliente cliente = this.getRepository().findById(id).get();
		cliente.setStatus(true);
		return new ClienteDTO((repository.save(cliente)));
	}
	
}
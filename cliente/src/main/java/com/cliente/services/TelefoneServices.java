package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cliente.entity.Telefone;
import com.cliente.entity.dto.TelefoneDTO;
import com.cliente.repository.TelefoneRepository;

@Service
public class TelefoneServices implements GenericService<Telefone, Long, TelefoneDTO> {
	
	@Autowired
	private TelefoneRepository repository;

	@Override
	public JpaRepository<Telefone, Long> getRepository() {
		
		return repository;
	}
	
	
}
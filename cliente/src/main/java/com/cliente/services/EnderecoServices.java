package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cliente.entity.Endereco;
import com.cliente.entity.dto.EnderecoDTO;
import com.cliente.repository.EnderecoRepository;

@Service
public class EnderecoServices implements GenericService<Endereco, Long, EnderecoDTO> {

	@Autowired
	private EnderecoRepository reporitory;

	@Override
	public JpaRepository<Endereco, Long> getRepository() {
		return reporitory;
	}
}

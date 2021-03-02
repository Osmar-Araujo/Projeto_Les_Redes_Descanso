package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cliente.entity.Usuario;
import com.cliente.entity.dto.UsuarioDTO;
import com.cliente.repository.UsuarioRepository;

@Service
public class UsuarioServices implements GenericService<Usuario, Long, UsuarioDTO> {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public JpaRepository<Usuario, Long> getRepository() {
		
		return repository;
	}
	
}

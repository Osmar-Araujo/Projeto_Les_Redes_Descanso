package com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cliente.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}

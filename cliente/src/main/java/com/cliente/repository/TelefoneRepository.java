package com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cliente.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

}

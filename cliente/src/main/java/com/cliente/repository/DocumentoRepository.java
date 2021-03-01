package com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cliente.entity.Documento;

public interface DocumentoRepository extends JpaRepository <Documento, Long> {

}

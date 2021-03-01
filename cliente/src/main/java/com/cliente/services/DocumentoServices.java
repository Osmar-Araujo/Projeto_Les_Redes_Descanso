package com.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cliente.entity.Documento;
import com.cliente.entity.dto.DocumentoDTO;
import com.cliente.repository.DocumentoRepository;

@Service
public class DocumentoServices implements GenericService <Documento, Long, DocumentoDTO>{

	@Autowired
	private DocumentoRepository repository;
	
	@Override
	public JpaRepository<Documento, Long> getRepository() {
		
		return repository;
	}
	
	
}

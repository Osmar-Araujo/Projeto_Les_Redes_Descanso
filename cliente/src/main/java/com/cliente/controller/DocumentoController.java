package com.cliente.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cliente.entity.dto.DocumentoDTO;
import com.cliente.services.DocumentoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/documentos")
@Api(value = "API de cadastro de clientes")
public class DocumentoController {
	
	@Autowired
	private DocumentoServices service;
	
	@ApiOperation(value = "Listar todos os documentos")

	@GetMapping

	public ResponseEntity<List<DocumentoDTO>> findAll() {

		List<DocumentoDTO> dto = service.findAll();

		return dto.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dto);

	}
	
	@ApiOperation(value = "Buscar documento por id")

	@GetMapping(value = "/{id}")

	public ResponseEntity<DocumentoDTO> buscarPorId(@PathVariable(name = "id", required = true) Long id) {

		DocumentoDTO dto = service.findById(id);

		return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);

	}
	
	@ApiOperation(value = "Salvar um documento na base")

	@PostMapping

	public ResponseEntity<DocumentoDTO> salvar(@RequestBody DocumentoDTO dto) {

		DocumentoDTO docDTO = service.insert(dto);

		URI location = getUri(docDTO.getId_documento());

		return ResponseEntity.created(location).build();

	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
	@ApiOperation(value = "Alteração de dados do documento cadastrado")

	@PutMapping(value = "/{id}")

	public ResponseEntity<DocumentoDTO> update(@PathVariable("id") Long id, @RequestBody DocumentoDTO dto) {

		dto.setId_documento(id);

		DocumentoDTO docDTO = service.update(dto, id);

		return docDTO == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(docDTO);

	}
	
	@ApiOperation(value = "Deleta um documento pelo id")

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		service.delete(id);

		return ResponseEntity.ok().build();

	}
}

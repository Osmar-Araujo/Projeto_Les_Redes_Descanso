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

import com.cliente.entity.dto.EnderecoDTO;
import com.cliente.services.EnderecoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@RequestMapping("/api/v1/endereco")

@Api(value = "API de Cadastro de clientes")

public class EnderecoController {

	@Autowired

	private EnderecoServices service;

	@ApiOperation(value = "Listar todos os endereços")

	@GetMapping

	public ResponseEntity<List<EnderecoDTO>> findAll() {

		List<EnderecoDTO> enderecos = service.findAll();

		return enderecos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(enderecos);

	}

	@ApiOperation(value = "Buscar endereço por id")

	@GetMapping(value = "/{id}")

	public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable(name = "id", required = true) Long id) {

		EnderecoDTO dto = service.findById(id);

		return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);

	}

	@ApiOperation(value = "Salvar um endereço na base")

	@PostMapping

	public ResponseEntity<EnderecoDTO> salvar(@RequestBody EnderecoDTO dto) {

		EnderecoDTO end = service.insert(dto);

		URI location = getUri(end.getId_endereco());

		return ResponseEntity.created(location).build();

	}

	@ApiOperation(value = "Alteração de dados do endereço cadastrado")

	@PutMapping(value = "/{id}")

	public ResponseEntity<EnderecoDTO> update(@PathVariable("id") Long id, @RequestBody EnderecoDTO dto) {

		dto.setId_endereco(id);

		EnderecoDTO endDTO = service.update(dto, id);

		return endDTO == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(endDTO);

	}

	@ApiOperation(value = "Deleta um endereço pelo id")

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		service.delete(id);

		return ResponseEntity.ok().build();

	}

	/*
	 * 
	 * Método para gerar URI no retorno do post
	 * 
	 */

	private URI getUri(Long id) {

		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

	}

}
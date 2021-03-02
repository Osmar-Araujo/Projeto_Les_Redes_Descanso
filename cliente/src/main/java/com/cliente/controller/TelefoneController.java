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

import com.cliente.entity.dto.TelefoneDTO;
import com.cliente.services.TelefoneServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@RequestMapping("/api/v1/telefone")

@Api(value = "API de cadastro de clientes")
public class TelefoneController {
	
	@Autowired
	private TelefoneServices service;
	
	@ApiOperation(value = "Listar todos os telefones")

	@GetMapping

	public ResponseEntity<List<TelefoneDTO>> findAll() {

		List<TelefoneDTO> telefones = service.findAll();

		return telefones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(telefones);

	}
	
	@ApiOperation(value = "Buscar telefone por id")

	@GetMapping(value = "/{id}")

	public ResponseEntity<TelefoneDTO> buscarPorId(@PathVariable(name = "id", required = true) Long id) {

		TelefoneDTO dto = service.findById(id);

		return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);

	}
	
	@ApiOperation(value = "Salvar um telefone na base")

	@PostMapping

	public ResponseEntity<TelefoneDTO> salvar(@RequestBody TelefoneDTO dto) {

		TelefoneDTO tel = service.insert(dto);

		URI location = getUri(tel.getId_telefone());

		return ResponseEntity.created(location).build();

	}
	
	private URI getUri(Long id_telefone) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id_telefone).toUri();
	}

	@ApiOperation(value = "Alteração de telefone cadastrado")

	@PutMapping(value = "/{id}")

	public ResponseEntity<TelefoneDTO> update(@PathVariable("id") Long id, @RequestBody TelefoneDTO dto) {

		dto.setId_telefone(id);

		TelefoneDTO telDTO = service.update(dto, id);

		return telDTO == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(telDTO);

	}
	
	@ApiOperation(value = "Deleta um telefone pelo id")

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		service.delete(id);

		return ResponseEntity.ok().build();

	}

}

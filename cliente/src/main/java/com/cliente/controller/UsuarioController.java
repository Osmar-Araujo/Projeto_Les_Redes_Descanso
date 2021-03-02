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

import com.cliente.entity.dto.UsuarioDTO;
import com.cliente.services.UsuarioServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/usuario")
@Api(value = "API de cadastro de clientes")
public class UsuarioController {

	@Autowired
	private UsuarioServices service;

	@ApiOperation(value = "Listar todos os usuários")

	@GetMapping

	public ResponseEntity<List<UsuarioDTO>> findAll() {

		List<UsuarioDTO> dto = service.findAll();

		return dto.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dto);

	}

	@ApiOperation(value = "Buscar usuário por id")

	@GetMapping(value = "/{id}")

	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable(name = "id", required = true) Long id) {

		UsuarioDTO dto = service.findById(id);

		return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);

	}

	@ApiOperation(value = "Salvar um usuário na base")

	@PostMapping

	public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO dto) {

		UsuarioDTO usu = service.insert(dto);

		URI location = getUri(usu.getId_usuario());

		return ResponseEntity.created(location).build();

	}

	private URI getUri(Long id_usuario) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id_usuario).toUri();
	}

	@ApiOperation(value = "Alteração de usuário cadastrado")

	@PutMapping(value = "/{id}")

	public ResponseEntity<UsuarioDTO> update(@PathVariable("id") Long id, @RequestBody UsuarioDTO dto) {

		dto.setId_usuario(id);

		UsuarioDTO usuDTO = service.update(dto, id);

		return usuDTO == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(usuDTO);

	}

	@ApiOperation(value = "Deleta um usuário pelo id")

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		service.delete(id);

		return ResponseEntity.ok().build();

	}

}

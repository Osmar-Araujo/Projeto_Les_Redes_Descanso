package com.cliente.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cliente.entity.dto.ClienteDTO;
import com.cliente.services.ClienteServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API de Cadastro de clientes")
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteServices service;

	@ApiOperation(value = "Listar todos os clientes")
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<ClienteDTO> clientes = service.findAll();
		return clientes.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(clientes);
	}

	@ApiOperation(value = "Buscar cliente por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable(name = "id", required = true) Long id) {
		ClienteDTO dto = service.findById(id);
		return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
	}

	@ApiOperation(value = "Salvar um cliente na base")
	@PostMapping
	public ResponseEntity<ClienteDTO> salvaCliente(@RequestBody ClienteDTO client) {
		ClienteDTO c = service.insert(client);
		URI location = getUri(c.getId_cliente());
		return ResponseEntity.created(location).build();
	}

	@ApiOperation(value = "Alteração de dados do cliente cadastrado")
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable(name = "id", required = true) Long id,
			@RequestBody ClienteDTO dto) {
		dto.setId_cliente(id);
		ClienteDTO clieDTO = service.update(dto, id);
		return clieDTO == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(clieDTO);
	}

	@ApiOperation(value = "Alteração de status do cliente cadastrado - inativar")
	@PatchMapping(value = "inativar/{id}")
	public ResponseEntity<ClienteDTO> inativa(@PathVariable(name = "id", required = true) Long id) {
		ClienteDTO cliEnt = service.inativa(id);
		return cliEnt == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cliEnt);
	}

	@ApiOperation(value = "Alteração de status do cliente cadastrado - ativar")
	@PatchMapping(value = "ativar/{id}")
	public ResponseEntity<ClienteDTO> ativa(@PathVariable(name = "id", required = true) Long id) {
		ClienteDTO cliEnt = service.ativa(id);
		return cliEnt == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cliEnt);
	}

	/*
	 * Método para gerar URI no retorno do post
	 */
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}

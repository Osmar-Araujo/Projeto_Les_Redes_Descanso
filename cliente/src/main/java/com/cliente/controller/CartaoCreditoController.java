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

import com.cliente.entity.dto.CartaoCreditoDTO;
import com.cliente.services.CartaoCreditoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/cartao")
@Api(value = "API de cadastro de clientes")
public class CartaoCreditoController {

	
	@Autowired
	private CartaoCreditoServices service;

	@ApiOperation(value = "Listar todos os cartões")

	@GetMapping

	public ResponseEntity<List<CartaoCreditoDTO>> findAll() {

		List<CartaoCreditoDTO> dto = service.findAll();

		return dto.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dto);

	}
	
	@ApiOperation(value = "Buscar cartão por id")

	@GetMapping(value = "/{id}")

	public ResponseEntity<CartaoCreditoDTO> buscarPorId(@PathVariable(name = "id", required = true) Long id) {

		CartaoCreditoDTO dto = service.findById(id);

		return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);

	}
	
	@ApiOperation(value = "Salvar um cartão na base")

	@PostMapping

	public ResponseEntity<CartaoCreditoDTO> salvar(@RequestBody CartaoCreditoDTO dto) {

		CartaoCreditoDTO credCard = service.insert(dto);

		URI location = getUri(credCard.getId_cartao());

		return ResponseEntity.created(location).build();

	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@ApiOperation(value = "Alteração de dados do cartão cadastrado")

	@PutMapping(value = "/{id}")

	public ResponseEntity<CartaoCreditoDTO> update(@PathVariable("id") Long id, @RequestBody CartaoCreditoDTO dto) {

		dto.setId_cartao(id);

		CartaoCreditoDTO credCard = service.update(dto, id);

		return credCard == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(credCard);

	}
	
	@ApiOperation(value = "Deleta um endereço pelo id")

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		service.delete(id);

		return ResponseEntity.ok().build();

	}
}

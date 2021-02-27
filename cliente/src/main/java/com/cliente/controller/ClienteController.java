package com.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.entity.Cliente;
import com.cliente.entity.dto.ClienteDTO;
import com.cliente.services.ClienteServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/clientes")
@Api(value = "API de Cadastro de clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServices cliserv;
	
	@PostMapping
	@ApiOperation(value = "Salvar um cliente na base")
	public void salvaCliente (@RequestBody Cliente client) {
		cliserv.salvaCliente(client);
	}
	
	@GetMapping(value = "/lista")
	@ApiOperation(value = "Listar todos os clientes")
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> list = cliserv.findAll();
		return ResponseEntity.ok(list);
	}
	
		
	@GetMapping (value = "/{id}")
	@ApiOperation(value = "Buscar cliente por id")
	public ClienteDTO buscarPorId(@PathVariable (name = "id", required = true) Long id)throws Exception {
		return cliserv.findById(id);
	}
	
	@ApiOperation(value = "Alteração de dados do cliente cadastrado")
	@PutMapping(value = "/{id}")
	public String update(@PathVariable ("id") Long id, @RequestBody Cliente client) throws Exception {
		ClienteDTO cliEnt = cliserv.update(client, id);
		return "Cadastro atualizado com sucesso!" + cliEnt.getId_cliente();
	}
	
	@ApiOperation(value = "Alteração de status do cliente cadastrado - inativar")
	@PutMapping(value = "inativar/{id}")
	public String inativa(@PathVariable ("id") Long id, @RequestBody Cliente client) throws Exception {
		ClienteDTO cliEnt = cliserv.inativa(client, id);
		return "Cadastro inativado com sucesso!" + cliEnt.getId_cliente();
	}
	
	@ApiOperation(value = "Alteração de status do cliente cadastrado - ativar")
	@PutMapping(value = "ativar/{id}")
	public String ativa(@PathVariable ("id") Long id, @RequestBody Cliente client) throws Exception {
		ClienteDTO cliEnt = cliserv.ativa(client, id);
		return "Cadastro inativado com sucesso!" + cliEnt.getId_cliente();
	}

}

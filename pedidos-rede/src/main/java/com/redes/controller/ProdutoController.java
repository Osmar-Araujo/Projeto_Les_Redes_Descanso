package com.redes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redes.entities.Produto;
import com.redes.entities.dto.ProdutoDTO;
import com.redes.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1/produto")
@Api(value = "API de Pedidos")
public class ProdutoController {
	
	@Autowired
	ProdutoService prodService;
	
	@GetMapping(value = "/lista")
	@ApiOperation(value = "Listar todos os produtos")
	public ResponseEntity<List<ProdutoDTO>> findAll(){
		List<ProdutoDTO> list = prodService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	@ApiOperation(value = "Salvar um produto na base")
	public void salvaProduto (@RequestBody Produto produto) {
		prodService.salvaProd(produto);
	}
	
	@GetMapping (value = "buscaID/{id}")
	@ApiOperation(value = "Buscar por id")
	public Optional<Produto> buscarPorId(@PathVariable (name = "id", required = true) Long id)throws Exception {
		return prodService.findById(id);
	}
	
	@ApiOperation(value = "Alteração de dados do documento cadastrado")
	@PutMapping(value = "/{id}")
	public String update(@PathVariable ("id") Long id, @RequestBody Produto produto) throws Exception {
		Produto prod = prodService.update(produto, id);
		return "Cadastro atualizado com sucesso!" + prod.getId();
	}
}
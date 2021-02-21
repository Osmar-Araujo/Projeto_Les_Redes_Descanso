package com.redes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.redes.entities.Produto;
import com.redes.entities.dto.ProdutoDTO;
import com.redes.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository ProdutoRep;
	
	public List<ProdutoDTO> findAll(){
		List<Produto> list = ProdutoRep.findAll();
		return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}
	
	public Produto salvaProd(Produto prod) {
		return ProdutoRep.save(prod);
	}
	
	public Produto update(Produto prod, Long id) throws Exception {
		Assert.notNull(id,"Não foi possível atualizar o produto!");
		
		Optional<Produto> optional = findById(id);
		if (optional.isPresent()) {
			Produto produto = optional.get();
			produto.setCor(prod.getCor());
			produto.setDescricao(prod.getDescricao());
			produto.setTipo(prod.getTipo());
			produto.setPreco(prod.getPreco());
			produto.setQuantidade(prod.getQuantidade());
			produto.setUrlfoto(prod.getUrlfoto());
									
			ProdutoRep.save(produto);
			
			return prod;
			
		}else {
			throw new Exception("Não foi possipvel atualizar o produto!");
		}
	}


	public Optional<Produto> findById(Long id) {
		Optional<Produto> op = ProdutoRep.findById(id);
		return op;
	}
}

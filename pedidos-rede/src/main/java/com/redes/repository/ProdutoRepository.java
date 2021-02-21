package com.redes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redes.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Optional<Produto> findById(Integer id);
}

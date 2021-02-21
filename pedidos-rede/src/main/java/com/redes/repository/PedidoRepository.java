package com.redes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redes.entities.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long>{

}

package com.redes.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tb_pedidos")
@Data
public class Pedido implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long IdCliente;
	private Instant moment;
	private pedidoStatus pedidostatus;
	
	@ManyToMany
	@JoinTable(name="tb_pedidos_produto", 
	joinColumns = @JoinColumn(name="pedido_id"),
	inverseJoinColumns = @JoinColumn(name="produto_id"))
	private Set<Produto> produtos = new HashSet<>();
	
	public Pedido(Long id, Long idCliente, Instant moment, pedidoStatus status) {
		
	}

}

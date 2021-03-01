package com.cliente.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cliente.entity.dto.ClienteDTO;
import com.cliente.entity.dto.Parsable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Parsable<ClienteDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id_cliente;
	private String nome;
	private Date dtNascimento;
	private String genero;
	private boolean status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private List<Endereco> endereco;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cartaoCredito")
	private List<CartaoCredito> cartao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_telefone")
    private List<Telefone> telefone;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_usuario")
//	private List<Usuario> usuario;

	public Cliente(ClienteDTO dto) {
		this.id_cliente = dto.getId_cliente();
		this.nome = dto.getNome();
		this.dtNascimento = dto.getDtNascimento();
		this.genero = dto.getGenero();
		this.status = dto.isStatus();
		if (dto.getEndereco() != null) {
			List<Endereco> listEnd = dto.getEndereco().stream().map(end -> new Endereco(end))
					.collect(Collectors.toList());
			this.setEndereco(listEnd);
		}
		
		if (dto.getTelefone() != null) {
			List<Telefone> listTel = dto.getTelefone().stream().map(tel -> new Telefone(tel))
					.collect(Collectors.toList());
			this.setTelefone(listTel);
		}
		
		if (dto.getCartao() != null) {
		List<CartaoCredito> listCartao = dto.getCartao().stream().map(cart -> new CartaoCredito(cart))
				.collect(Collectors.toList());
		this.setCartao(listCartao);
		}
	}

	@Override
	public ClienteDTO convert() {

		return new ClienteDTO(this);
	}

}

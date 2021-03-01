package com.cliente.entity.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.cliente.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Parsable<Cliente> {

	private Long id_cliente;
	private String nome;
	private Date dtNascimento;
	private String genero;
	private boolean status;

	private List<EnderecoDTO> endereco;

	private List<CartaoCreditoDTO> cartao;

	 private List<TelefoneDTO> telefone;
	 
	 private List<DocumentoDTO> documento;
	 
	 /* 
	 * private List<UsuarioDTO> usuario;
	 */

	public ClienteDTO(Cliente entity) {
		this.id_cliente = entity.getId_cliente();
		this.nome = entity.getNome();
		this.dtNascimento = entity.getDtNascimento();
		this.genero = entity.getGenero();
		this.status = entity.isStatus();
		if (entity.getEndereco() != null) {
			List<EnderecoDTO> listEnd = entity.getEndereco().stream().map(end -> new EnderecoDTO(end))
					.collect(Collectors.toList());
			this.setEndereco(listEnd);
		}
		
		if (entity.getTelefone() != null) {
			List<TelefoneDTO> listTel = entity.getTelefone().stream().map(tel -> new TelefoneDTO(tel))
					.collect(Collectors.toList());
			this.setTelefone(listTel);
		}
		
		if (entity.getCartao() != null) {
			List<CartaoCreditoDTO> listCard = entity.getCartao().stream().map(card -> new CartaoCreditoDTO(card))
					.collect(Collectors.toList());
			this.setCartao(listCard);
		}
		
		if (entity.getDocumento() != null) {
			List<DocumentoDTO> listDoc = entity.getDocumento().stream().map(doc -> new DocumentoDTO(doc))
					.collect(Collectors.toList());
			this.setDocumento(listDoc);
		}

	}

	@Override
	public Cliente convert() {
		return new Cliente(this);
	}

}

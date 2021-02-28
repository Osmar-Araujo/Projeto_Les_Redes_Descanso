package com.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cliente.entity.Usuario;
import com.cliente.entity.dto.UsuarioDTO;
import com.cliente.repository.UsuarioRepository;

import javassist.NotFoundException;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuRep;
	
	public List<Usuario> findAll(){
		List<Usuario> list = usuRep.findAll();
		return list;
	}
	
	public UsuarioDTO findById(Long id) throws NotFoundException {
		Usuario usu = usuRep.findById(id).orElseThrow(() -> new NotFoundException("Telefone não encontrado!!!"));
		return UsuarioDTO.consumeDTO(usu);
	}
	
	public UsuarioDTO update(UsuarioDTO usudto, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o cadastro!");
		Usuario usu = usuRep.findById(id).get();
		
		usu.setEmail(usudto.getEmail());
		usu.setSenha(usudto.getSenha());
		usu.setCliente(usudto.getCliente());
		
		return UsuarioDTO.consumeDTO(usuRep.save(usu));
	}
	
	public UsuarioDTO AlteraSenha(UsuarioDTO usudto, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o cadastro!");
		Usuario usu = usuRep.findById(id).get();
		usu.setSenha(usudto.getSenha());
		
		return UsuarioDTO.consumeDTO(usuRep.save(usu));
	}

	
	public void deletar(Long id) {
		usuRep.deleteById(id);
	}

}

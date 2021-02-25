package com.cliente.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cliente.entity.Endereco;
import com.cliente.entity.dto.EnderecoDTO;
import com.cliente.repository.EnderecoRepository;

@Service
public class EnderecoServices {
	
	 @Autowired
	private EnderecoRepository endRep;
	
	public List<EnderecoDTO> findAll(){
		List<Endereco> list = endRep.findAll();
		return list.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
	}
	
	public Optional<Endereco> findById(Long id) {
		Optional<Endereco> op = endRep.findById(id);
		return op;
	}

	public Endereco salvaEndereco(Endereco end) {
		return endRep.save(end);
	}
	
	public Endereco update(EnderecoDTO endDTO, Long id) throws Exception {
		Assert.notNull(id,"Não foi possível atualizar o endereço!");
		
		Optional<Endereco> optional = findById(id);
		if (optional.isPresent()) {
			Endereco End = optional.get();
			End.setId(endDTO.getId());
			End.setLogradouro(endDTO.getLogradouro());
			End.setNro(endDTO.getNro());
			End.setBairro(endDTO.getBairro());
			End.setCidade(endDTO.getCidade());
			End.setUf(endDTO.getUf());
			End.setCEP(endDTO.getCEP());
			End.setCliente(endDTO.getCliente());
			
						
			return endRep.save(End);
			
		}else {
			throw new Exception("Não foi possível atualizar o endereço!");
		}
	}
	
	public void delete(Long id) {
		Optional<Endereco> op = findById(id);
		if (op.isPresent()) {
		endRep.deleteById(id);
		}
	}
}

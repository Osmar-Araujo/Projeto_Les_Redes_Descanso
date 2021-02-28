package com.cliente.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.cliente.entity.Endereco;
import com.cliente.entity.dto.EnderecoDTO;
import com.cliente.repository.EnderecoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EnderecoServices implements GenericService<Endereco, Long, EnderecoDTO> {
	
	@Override
	public JpaRepository<Endereco, Long> getRepository() {
		return null;
	}
	
	 @Autowired
	private EnderecoRepository endRep;
	
	public List<EnderecoDTO> listarEnderecos(Endereco end){
		
		List<Endereco> list = getRepository().findAll();
		if (list.isEmpty())
			new ObjectNotFoundException("Nenhum registro encontrado");
		return list.stream().map(x -> x.convert()).collect(Collectors.toList());
	}
	
	public EnderecoDTO findById(Long id) throws ObjectNotFoundException {
		
		Optional<Endereco> entity = getRepository().findById(id);
		return entity.map(x -> x.convert())
				.orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
	}

	public EnderecoDTO salvaEndereco(EnderecoDTO dto) {
		Endereco entity = this.getRepository().save(dto.convert());
		return entity.convert();	
	}
	
	public EnderecoDTO update(EnderecoDTO dto, Long id) throws ObjectNotFoundException {
		
		Optional<Endereco> optional = this.getRepository().findById(id);
		if (optional.isPresent()) {
			Endereco local = optional.get();
			local = dto.convert();
			local = this.getRepository().save(local);
			return local.convert();
		} else {
			throw new ObjectNotFoundException("Nenhum registro encontrado");
		}	
	}
	
	public void delete(Long id) {
		endRep.deleteById(id);
		
	}

}

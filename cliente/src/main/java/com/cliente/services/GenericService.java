package com.cliente.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.api.exception.ObjectNotFoundException;
import com.carros.domain.dto.Parsable;

public interface GenericService<T extends Parsable<DTO>, ID, DTO extends Parsable<T>> {

	JpaRepository<T, ID> getRepository();

	default List<DTO> findAll() {
		
		List<T> list = getRepository().findAll();
		if (list.isEmpty())
			new ObjectNotFoundException("Nenhum registro encontrado");
		return list.stream().map(x -> x.convert()).collect(Collectors.toList());

	}

	default DTO findById(ID id) {
		
		Optional<T> entity = getRepository().findById(id);
		return entity.map(x -> x.convert())
				.orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
	}

	default DTO insert(DTO dto) {

		T entity = this.getRepository().save(dto.convert());
		return entity.convert();
	}

	default DTO update(DTO dto, ID id) {

		Optional<T> optional = this.getRepository().findById(id);
		if (optional.isPresent()) {
			T local = optional.get();
			local = dto.convert();
			local = this.getRepository().save(local);			
			return local.convert();
		} else {
			throw new ObjectNotFoundException("Nenhum registro encontrado");
		}
	}

	default void delete(ID id) {
		getRepository().deleteById(id);
	}
}

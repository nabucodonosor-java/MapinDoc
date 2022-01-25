package com.mapin.docmapin.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.mapin.docmapin.dto.ProfessionDto;
import com.mapin.docmapin.model.Profession;
import com.mapin.docmapin.repositories.ProfessionRepository;
import com.mapin.docmapin.services.exceptions.DatabaseException;
import com.mapin.docmapin.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfessionService {
	
	@Autowired
	private ProfessionRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ProfessionDto> findAllPaged(String name, Pageable pageable) {
		Page<Profession> page = repository.findAllPaged(name, pageable);
		return page.map(x -> new ProfessionDto(x));
	}
	
	@Transactional(readOnly = true)
	public ProfessionDto findById(Long id) {
		Optional<Profession> optional = repository.findById(id);
		Profession entity = optional.orElseThrow(() -> new ResourceNotFoundException("Profissão não encontrada!"));
		return new ProfessionDto(entity);
	}
	
	@Transactional
	public ProfessionDto insert(ProfessionDto dto) {
		Profession entity = new Profession();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProfessionDto(entity);
	}
	
	@Transactional
	public ProfessionDto update(Long id, ProfessionDto dto) {
		
		try {
			
		Profession entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProfessionDto(entity);
		
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Profissão não enconrada!");
		}
	}
	
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Profissão não enconrada!");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação no DB");
		}
	}

	private void copyDtoToEntity(ProfessionDto dto, Profession entity) {
		
		entity.setName(dto.getName());
		
	}

}

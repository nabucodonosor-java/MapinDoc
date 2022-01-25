package com.mapin.docmapin.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.mapin.docmapin.dto.PlaceServiceDto;
import com.mapin.docmapin.model.PlaceService;
import com.mapin.docmapin.repositories.PlaceServiceRepository;
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
public class PlaceServiceService {
	
	@Autowired
	private PlaceServiceRepository repository;
	
	@Transactional(readOnly = true)
	public Page<PlaceServiceDto> findAllPaged(String name, String logradouro, String localidade, Pageable pageable) {
		Page<PlaceService> page = repository.findAllPaged(name, logradouro, localidade, pageable);
		return page.map(x -> new PlaceServiceDto(x, x.getHealthPro()));
	}
	
	@Transactional(readOnly = true)
	public Page<PlaceServiceDto> findAllApae(String localidade, Pageable pageable) {
		Page<PlaceService> page = repository.findAllApae(localidade, pageable);
		return page.map(x -> new PlaceServiceDto(x, x.getHealthPro()));
	}
	
	@Transactional(readOnly = true)
	public Page<PlaceServiceDto> findAllHospital(String name, String localidade, Pageable pageable) {
		Page<PlaceService> page = repository.findAllHospital(name, localidade, pageable);
		return page.map(x -> new PlaceServiceDto(x, x.getHealthPro()));
	}
	
	@Transactional(readOnly = true)
	public Page<PlaceServiceDto> findAllClinic(String name, String localidade, Pageable pageable) {
		Page<PlaceService> page = repository.findAllClinic(name, localidade, pageable);
		return page.map(x -> new PlaceServiceDto(x, x.getHealthPro()));
	}
	
	@Transactional(readOnly = true)
	public Page<PlaceServiceDto> findAllMedicalCenter(String name, String localidade, Pageable pageable) {
		Page<PlaceService> page = repository.findAllMedicalCenter(name, localidade, pageable);
		return page.map(x -> new PlaceServiceDto(x, x.getHealthPro()));
	}
	
	@Transactional(readOnly = true)
	public Page<PlaceServiceDto> findAllCityHall(String localidade, Pageable pageable) {
		Page<PlaceService> page = repository.findAllCityHall(localidade, pageable);
		return page.map(x -> new PlaceServiceDto(x, x.getHealthPro()));
	}
	
	@Transactional(readOnly = true)
	public Page<PlaceServiceDto> findAllCir(String localidade, Pageable pageable) {
		Page<PlaceService> page = repository.findAllCir(localidade, pageable);
		return page.map(x -> new PlaceServiceDto(x, x.getHealthPro()));
	}
	
	@Transactional(readOnly = true)
	public PlaceServiceDto findById(Long id) {
		Optional<PlaceService> optional = repository.findById(id);
		PlaceService entity = optional.orElseThrow(() -> new ResourceNotFoundException("Local não encontrado!"));
		return new PlaceServiceDto(entity, entity.getHealthPro());
	}
	
	@Transactional
	public PlaceServiceDto insert(PlaceServiceDto dto) {
		PlaceService entity = new PlaceService();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PlaceServiceDto(entity);
	}
	
	@Transactional
	public PlaceServiceDto update(Long id, PlaceServiceDto dto) {
		
		try {
			
		PlaceService entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PlaceServiceDto(entity);
		
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Local não enconrado!");
		}
	}
	
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Profissional não enconrado!");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação no DB");
		}
	}
	
	private void copyDtoToEntity(PlaceServiceDto dto, PlaceService entity) {
		
		entity.setName(dto.getName());
		entity.setPhone(dto.getPhone());
		entity.setCellPhone(dto.getCellPhone());
		entity.setCep(dto.getCep());
		entity.setLogradouro(dto.getLogradouro());
		entity.setComplemento(dto.getComplemento());
		entity.setBairro(dto.getBairro());
		entity.setLocalidade(dto.getLocalidade());
		entity.setUf(dto.getUf());
		
		entity.setClinic(dto.isClinic());
		entity.setHospital(dto.isHospital());
		entity.setMedicalCenter(dto.isMedicalCenter());
		entity.setCir(dto.isCir());
		entity.setCityHall(dto.isCityHall());
		entity.setApae(dto.isApae());
		
		entity.setDescription(dto.getDescription());
	}
	
}

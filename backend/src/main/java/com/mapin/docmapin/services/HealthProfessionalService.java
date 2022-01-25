package com.mapin.docmapin.services;

import com.mapin.docmapin.dto.HealthProfessionalDto;
import com.mapin.docmapin.dto.SpecializationDto;
import com.mapin.docmapin.model.HealthProfessional;
import com.mapin.docmapin.model.PlaceService;
import com.mapin.docmapin.model.Profession;
import com.mapin.docmapin.model.Specialization;
import com.mapin.docmapin.repositories.HealthProfessionalRepository;
import com.mapin.docmapin.repositories.PlaceServiceRepository;
import com.mapin.docmapin.repositories.ProfessionRepository;
import com.mapin.docmapin.repositories.SpecializationRepository;
import com.mapin.docmapin.services.exceptions.DatabaseException;
import com.mapin.docmapin.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HealthProfessionalService {
	
	@Autowired
	private HealthProfessionalRepository repository;
	
	@Autowired
	private com.mapin.docmapin.services.S3Service s3Service;
	
	@Autowired
	private SpecializationRepository specializationRepository;
	
	@Autowired
	private PlaceServiceRepository placeRepository;
	
	@Autowired
	private ProfessionRepository professionRepository;
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllPagedProStatus(Long specializationId, String profession, String localidade,
															 Boolean partner, Boolean strategic, Boolean potencial, String name, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findAllPagedProStatus(specialization, profession, localidade, partner, strategic, potencial, name, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllPaged(Long specializationId, String profession, String localidade,
			String name, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findAllPaged(specialization, profession, localidade, name, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllProApaePaged(Long specializationId, String profession, String localidade, 
			String name, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findAllProApaePaged(specialization, profession, localidade, name, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllByMonday(Long specializationId, String profession, String localidade, 
			String segPeriod, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findByMonday(specialization, profession, localidade, segPeriod, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllByTuesday(Long specializationId, String profession, String localidade, 
			String terPeriod, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findByTuesday(specialization, profession, localidade, terPeriod, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllByWednesday(Long specializationId, String profession, String localidade, 
			String quaPeriod, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findByWednesday(specialization, profession, localidade, quaPeriod, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllByThursday(Long specializationId, String profession, String localidade, 
			String quiPeriod, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findByThursday(specialization, profession, localidade, quiPeriod, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllByFriday(Long specializationId, String profession, String localidade, 
			String sexPeriod, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findByFriday(specialization, profession, localidade, sexPeriod, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public Page<HealthProfessionalDto> findAllBySaturday(Long specializationId, String profession, String localidade, 
			String sabPeriod, Pageable pageable) {
		List<Specialization> specialization = (specializationId == 0) ? null : Arrays.asList(specializationRepository.getOne(specializationId));
		Page<HealthProfessional> page = repository.findBySaturday(specialization, profession, localidade, sabPeriod, pageable);
		repository.find(page.getContent());
		return page.map(x -> new HealthProfessionalDto(x, x.getSpecializations()));
	}
	
	@Transactional(readOnly = true)
	public HealthProfessionalDto findById(Long id) {
		Optional<HealthProfessional> optional = repository.findById(id);
		HealthProfessional entity = optional.orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado!"));
		return new HealthProfessionalDto(entity, entity.getSpecializations());
	}
	
	@Transactional
	public HealthProfessionalDto insert(HealthProfessionalDto dto) {
		HealthProfessional entity = new HealthProfessional();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new HealthProfessionalDto(entity);
	}
	
	@Transactional
	public HealthProfessionalDto update(Long id, HealthProfessionalDto dto) {
		
		try {
			
		HealthProfessional entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new HealthProfessionalDto(entity);
		
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Profissional não enconrado!");
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

	private void copyDtoToEntity(HealthProfessionalDto dto, HealthProfessional entity) {
		entity.setFemaleDoc(dto.isFemaleDoc());

		if (dto.isFemaleDoc()) {
			entity.setImgUrl("https://doc-admin-jacomo.s3.sa-east-1.amazonaws.com/padrao-F.png");
		} else {
			entity.setImgUrl("https://doc-admin-jacomo.s3.sa-east-1.amazonaws.com/padrao-M.png");
		}
		
		entity.setRegister(dto.getRegister());
		entity.setName(dto.getName().toUpperCase());
		
		String cardName = dto.getName();

		String[] cardNameArray = cardName.split(" ");

		for (int i = 0; i < cardNameArray.length; i++) {
			cardName = cardNameArray[0] + " " + cardNameArray[cardNameArray.length - 1];
		}
		
		entity.setCardName(cardName);
		
		entity.setPhone(dto.getPhone());
		entity.setEmail(dto.getEmail());
		entity.setBirthDate(dto.getBirthDate());
		entity.setResume(dto.getResume());
		entity.setByScheduling(dto.isByScheduling());
		entity.setSeg(dto.isSeg());
		entity.setSegPeriod(dto.getSegPeriod());
		entity.setTer(dto.isTer());
		entity.setTerPeriod(dto.getTerPeriod());
		entity.setQua(dto.isQua());
		entity.setQuaPeriod(dto.getQuaPeriod());
		entity.setQui(dto.isQui());
		entity.setQuiPeriod(dto.getQuiPeriod());
		entity.setSex(dto.isSex());
		entity.setSexPeriod(dto.getSexPeriod());
		entity.setSab(dto.isSab());
		entity.setSabPeriod(dto.getSabPeriod());
		entity.setOfficeHours(dto.getOfficeHours());
		
		entity.setPartner(dto.isPartner());
		entity.setStrategic(dto.isStrategic());
		entity.setPotencial(dto.isPotencial());

		entity.setProfession(new Profession(dto.getProfession()));

		entity.setPlaceService(new PlaceService(dto.getPlaceService()));

		
		entity.getSpecializations().clear();
		
		for (SpecializationDto speDto : dto.getSpecializations()) {
			Specialization entitySpe = specializationRepository.getOne(speDto.getId());
			entity.getSpecializations().add(entitySpe);
		}
		
	}
	
}

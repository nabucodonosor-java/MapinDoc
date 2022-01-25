package com.mapin.docmapin.controllers;

import com.mapin.docmapin.dto.HealthProfessionalDto;
import com.mapin.docmapin.services.HealthProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/hp")
public class HealthProfessionalController {
	
	@Autowired
	private HealthProfessionalService service;
	
	@GetMapping
	public ResponseEntity<Page<HealthProfessionalDto>> findAllPaged(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "partner", defaultValue = "") Boolean partner,
			@RequestParam(value = "strategic", defaultValue = "") Boolean strategic,
			@RequestParam(value = "potencial", defaultValue = "") Boolean potencial,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllPagedProStatus(specializationId, profession.trim(), localidade.trim(), 
				partner, strategic, potencial, name.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	/*
	@GetMapping
	public ResponseEntity<Page<HealthProfessionalDto>> findAllPaged(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllPaged(specializationId, profession.trim(), localidade.trim(), 
				name.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	*/
	@GetMapping("/apae")
	public ResponseEntity<Page<HealthProfessionalDto>> findAllProApaePaged(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllProApaePaged(specializationId, profession.trim(), localidade.trim(), 
				name.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/byMonday")
	public ResponseEntity<Page<HealthProfessionalDto>> findAllByMonday(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "periodo", defaultValue = "") String periodo,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllByMonday(specializationId, profession.trim(), localidade.trim(), 
				periodo.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/byTuesday")
	public ResponseEntity<Page<HealthProfessionalDto>> findAllByTuesday(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "periodo", defaultValue = "") String periodo,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllByTuesday(specializationId, profession.trim(), localidade.trim(), 
				periodo.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/byWednesday")
	public ResponseEntity<Page<HealthProfessionalDto>> findAllByWednesday(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "periodo", defaultValue = "") String periodo,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllByWednesday(specializationId, profession.trim(), localidade.trim(), 
				periodo.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/byThursday")
	public ResponseEntity<Page<HealthProfessionalDto>> findAllByThursday(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "periodo", defaultValue = "") String periodo,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllByThursday(specializationId, profession.trim(), localidade.trim(), 
				periodo.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/byFriday")
	public ResponseEntity<Page<HealthProfessionalDto>> findAllByFriday(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "periodo", defaultValue = "") String periodo,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllByFriday(specializationId, profession.trim(), localidade.trim(), 
				periodo.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/bySaturday")
	public ResponseEntity<Page<HealthProfessionalDto>> findAllBySaturday(
			@RequestParam(value = "specializationId", defaultValue = "0") Long specializationId,
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "periodo", defaultValue = "") String periodo,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<HealthProfessionalDto> list = service.findAllBySaturday(specializationId, profession.trim(), localidade.trim(), 
				periodo.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HealthProfessionalDto> findById(@PathVariable Long id) {
		HealthProfessionalDto dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<HealthProfessionalDto> insert(@Valid @RequestBody HealthProfessionalDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HealthProfessionalDto> update(@PathVariable Long id, @Valid @RequestBody HealthProfessionalDto dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

package com.mapin.docmapin.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import com.mapin.docmapin.dto.MedicalVisitDto;
import com.mapin.docmapin.services.MedicalVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/visits")
public class MedicalVisitController {
	
	@Autowired
	private MedicalVisitService service;
	
	@GetMapping
	public ResponseEntity<Page<MedicalVisitDto>> findAll(
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "sort", defaultValue = "visitDate") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<MedicalVisitDto> list = service.findAllWithFilters(profession, name, localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping("/byPeriod")
	public ResponseEntity<Page<MedicalVisitDto>> findAllByPeriod(	
			@RequestParam(value = "profession", defaultValue = "") String profession,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "first", defaultValue = "") String first,
			@RequestParam(value = "second", defaultValue = "") String second,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "sort", defaultValue = "visitDate") String sort) {
		
		LocalDate ld1 = LocalDate.parse(first, DateTimeFormatter.ofPattern("yyyy-MM-dd"));	
		LocalDate ld2 = LocalDate.parse(second, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<MedicalVisitDto> list = service.findAllByPeriod(ld1, ld2, profession.trim(), localidade.trim(), name.trim(), pageRequest);
		
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicalVisitDto> findById(@PathVariable Long id) {
		MedicalVisitDto entity = service.findById(id);
		return ResponseEntity.ok().body(entity);
	}
	
	@PostMapping
	public ResponseEntity<MedicalVisitDto> insert(@Valid @RequestBody MedicalVisitDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedicalVisitDto> update(@PathVariable Long id, @Valid @RequestBody MedicalVisitDto dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
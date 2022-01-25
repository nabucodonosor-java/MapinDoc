package com.mapin.docmapin.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.mapin.docmapin.dto.PlaceServiceDto;
import com.mapin.docmapin.services.PlaceServiceService;
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
@RequestMapping("/places")
public class PlaceServiceController {
	
	@Autowired
	private PlaceServiceService service;
	
	@GetMapping
	public ResponseEntity<Page<PlaceServiceDto>> findAllPaged(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "logradouro", defaultValue = "") String logradouro,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<PlaceServiceDto> list = service.findAllPaged(name, logradouro, localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/apae")
	public ResponseEntity<Page<PlaceServiceDto>> findAllApae(
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<PlaceServiceDto> list = service.findAllApae(localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/hospital")
	public ResponseEntity<Page<PlaceServiceDto>> findAllHospital(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<PlaceServiceDto> list = service.findAllHospital(name, localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/clinic")
	public ResponseEntity<Page<PlaceServiceDto>> findAllClinic(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<PlaceServiceDto> list = service.findAllClinic(name, localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/medical_center")
	public ResponseEntity<Page<PlaceServiceDto>> findAllMedicalCenter(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<PlaceServiceDto> list = service.findAllMedicalCenter(name, localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/city_hall")
	public ResponseEntity<Page<PlaceServiceDto>> findAllCityHall(
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<PlaceServiceDto> list = service.findAllCityHall(localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/cir")
	public ResponseEntity<Page<PlaceServiceDto>> findAllCir(
			@RequestParam(value = "localidade", defaultValue = "") String localidade,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "1000") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "sort", defaultValue = "name") String sort) {
				
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<PlaceServiceDto> list = service.findAllCir(localidade, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PlaceServiceDto> findById(@PathVariable Long id) {
		PlaceServiceDto dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<PlaceServiceDto> insert(@Valid @RequestBody PlaceServiceDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PlaceServiceDto> update(@PathVariable Long id, @Valid @RequestBody PlaceServiceDto dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

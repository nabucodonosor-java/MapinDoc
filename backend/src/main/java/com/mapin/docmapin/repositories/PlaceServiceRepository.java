package com.mapin.docmapin.repositories;

import com.mapin.docmapin.model.PlaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaceServiceRepository extends JpaRepository<PlaceService, Long> {
	
	@Query("SELECT DISTINCT obj FROM PlaceService obj WHERE "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) AND "
			+ "(LOWER(obj.logradouro) LIKE LOWER(CONCAT('%',:logradouro,'%'))) AND "
			+ "(LOWER(obj.localidade) LIKE LOWER(CONCAT('%',:localidade,'%')))")
	Page<PlaceService> findAllPaged(String name, String logradouro, String localidade, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM PlaceService obj WHERE "
			+ "(LOWER(obj.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "obj.apae = true")
	Page<PlaceService> findAllApae(String localidade, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM PlaceService obj WHERE "
			+ "(LOWER(obj.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "obj.cir = true")
	Page<PlaceService> findAllCir(String localidade, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM PlaceService obj WHERE "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) AND "
			+ "(LOWER(obj.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "obj.hospital = true")
	Page<PlaceService> findAllHospital(String name, String localidade, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM PlaceService obj WHERE "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) AND "
			+ "(LOWER(obj.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "obj.clinic = true")
	Page<PlaceService> findAllClinic(String name, String localidade, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM PlaceService obj WHERE "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) AND "
			+ "(LOWER(obj.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "obj.medicalCenter = true")
	Page<PlaceService> findAllMedicalCenter(String name, String localidade, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM PlaceService obj WHERE "
			+ "(LOWER(obj.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "obj.cityHall = true")
	Page<PlaceService> findAllCityHall(String localidade, Pageable pageable);
}

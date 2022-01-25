package com.mapin.docmapin.repositories;

import java.time.LocalDate;

import com.mapin.docmapin.model.MedicalVisit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicalVisitRepository extends JpaRepository<MedicalVisit, Long> {
	
	@Query("SELECT obj FROM MedicalVisit obj WHERE obj.visitDate >= :first AND obj.visitDate <= :second AND "
			+ "(LOWER(obj.healthPro.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.healthPro.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.healthPro.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<MedicalVisit> findByPeriodWithFilters(LocalDate first, LocalDate second, String profession, String localidade, String name, Pageable pageable);
	
	@Query("SELECT obj FROM MedicalVisit obj WHERE "
			+ "(LOWER(obj.healthPro.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.healthPro.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.healthPro.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<MedicalVisit> findAllWithFilters(String profession, String name, String localidade, Pageable pageable);
	
	@Query("SELECT obj FROM MedicalVisit obj WHERE obj.visitDate >= :first AND obj.visitDate <= :second")
	Page<MedicalVisit> findByPeriod(LocalDate first, LocalDate second, Pageable pageable);
	
}

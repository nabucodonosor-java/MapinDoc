package com.mapin.docmapin.repositories;

import java.util.List;

import com.mapin.docmapin.model.HealthProfessional;
import com.mapin.docmapin.model.Specialization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HealthProfessionalRepository extends JpaRepository<HealthProfessional, Long> {
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.segPeriod) LIKE LOWER(CONCAT('%',:segPeriod,'%'))) AND "
			+ "obj.seg = true")
	Page<HealthProfessional> findByMonday(List<Specialization> specializations, String profession, String localidade,
										  String segPeriod, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.terPeriod) LIKE LOWER(CONCAT('%',:terPeriod,'%'))) AND "
			+ "obj.ter = true")
	Page<HealthProfessional> findByTuesday(List<Specialization> specializations, String profession, String localidade, 
			String terPeriod, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.quaPeriod) LIKE LOWER(CONCAT('%',:quaPeriod,'%'))) AND "
			+ "obj.qua = true")
	Page<HealthProfessional> findByWednesday(List<Specialization> specializations, String profession, String localidade, 
			String quaPeriod, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.quiPeriod) LIKE LOWER(CONCAT('%',:quiPeriod,'%'))) AND "
			+ "obj.qui = true")
	Page<HealthProfessional> findByThursday(List<Specialization> specializations, String profession, String localidade, 
			String quiPeriod, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.sexPeriod) LIKE LOWER(CONCAT('%',:sexPeriod,'%'))) AND "
			+ "obj.sex = true")
	Page<HealthProfessional> findByFriday(List<Specialization> specializations, String profession, String localidade, 
			String sexPeriod, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.sabPeriod) LIKE LOWER(CONCAT('%',:sabPeriod,'%'))) AND "
			+ "obj.sex = true")
	Page<HealthProfessional> findBySaturday(List<Specialization> specializations, String profession, String localidade, 
			String sabPeriod, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "obj.placeService.apae = true AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<HealthProfessional> findAllProApaePaged(List<Specialization> specializations, String profession, String localidade, 
			String name, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<HealthProfessional> findAllPaged(List<Specialization> specializations, String profession, String localidade, 
			String name, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM HealthProfessional obj INNER JOIN obj.specializations esp WHERE "
			+ "(COALESCE(:specializations) IS NULL OR esp IN :specializations) AND "
			+ "(LOWER(obj.profession.name) LIKE LOWER(CONCAT('%',:profession,'%'))) AND "
			+ "(LOWER(obj.placeService.localidade) LIKE LOWER(CONCAT('%',:localidade,'%'))) AND "
			+ "(:partner IS NULL OR obj.partner = :partner) AND "
			+ "(:strategic IS NULL OR obj.strategic = :strategic) AND "
			+ "(:potencial IS NULL OR obj.potencial = :potencial) AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<HealthProfessional> findAllPagedProStatus(List<Specialization> specializations, String profession, String localidade, 
			Boolean partner, Boolean strategic, Boolean potencial, String name, Pageable pageable);
	
	@Query("SELECT obj FROM HealthProfessional obj JOIN FETCH obj.specializations WHERE obj IN :healthProfessional")
	List<HealthProfessional> find(List<HealthProfessional> healthProfessional);
	
	
	

}

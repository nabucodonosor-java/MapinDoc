package com.mapin.docmapin.repositories;

import com.mapin.docmapin.model.Specialization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
	
	@Query("SELECT DISTINCT obj FROM Specialization obj WHERE "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<Specialization> findAllPaged(String name, Pageable pageable);

}

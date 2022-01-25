package com.mapin.docmapin.repositories;

import com.mapin.docmapin.model.Profession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
	
	@Query("SELECT DISTINCT obj FROM Profession obj WHERE "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<Profession> findAllPaged(String name, Pageable pageable);

}

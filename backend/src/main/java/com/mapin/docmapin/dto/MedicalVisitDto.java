package com.mapin.docmapin.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.mapin.docmapin.model.MedicalVisit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalVisitDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private LocalDate visitDate;

	private HealthProfessionalDto healthPro;

	private boolean success;

	private String description;
	public MedicalVisitDto(MedicalVisit entity) {
		id = entity.getId();
		visitDate = entity.getVisitDate();
		healthPro = new HealthProfessionalDto(entity.getHealthPro());
		success = entity.isSuccess();
		description = entity.getDescription();
	}

	public static Page<MedicalVisitDto> converter(Page<MedicalVisit> page) {
		return page.map(MedicalVisitDto::new);
	}
}

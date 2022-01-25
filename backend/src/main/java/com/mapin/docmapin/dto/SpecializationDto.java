package com.mapin.docmapin.dto;

import com.mapin.docmapin.model.HealthProfessional;
import com.mapin.docmapin.model.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	private List<HealthProfessionalDto> healthPro = new ArrayList<>();
	public SpecializationDto(Specialization entity) {
		id = entity.getId();
		name = entity.getName();
	}
	public SpecializationDto(Specialization entity, Set<HealthProfessional> healthPro) {
		this(entity);
		healthPro.forEach(s -> this.healthPro.add(new HealthProfessionalDto(s)));
	}
}

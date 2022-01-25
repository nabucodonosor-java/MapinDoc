package com.mapin.docmapin.dto;

import com.mapin.docmapin.model.HealthProfessional;
import com.mapin.docmapin.model.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceServiceDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
	private String phone;
	private String cellPhone;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private boolean clinic;
	private boolean hospital;
	private boolean medicalCenter;
	private boolean cir;
	private boolean cityHall;
	private boolean apae;
	private String description;
	
	private List<HealthProfessionalDto> healthPro = new ArrayList<>();

	public PlaceServiceDto(PlaceService entity) {
		id = entity.getId();
		name = entity.getName();
		phone = entity.getPhone();
		cellPhone = entity.getCellPhone();
		cep = entity.getCep();
		logradouro = entity.getLogradouro();
		complemento = entity.getComplemento();
		bairro = entity.getBairro();
		localidade = entity.getLocalidade();
		uf = entity.getUf();
		clinic = entity.isClinic();
		hospital = entity.isHospital();
		medicalCenter = entity.isMedicalCenter();
		cir = entity.isCir();
		cityHall = entity.isCityHall();
		apae = entity.isApae();
		description = entity.getDescription();
	}
	
	public PlaceServiceDto(PlaceService entity, List<HealthProfessional> healthPro) {
		this(entity);	
		healthPro.forEach(hp -> this.healthPro.add(new HealthProfessionalDto(hp)));
	}
}

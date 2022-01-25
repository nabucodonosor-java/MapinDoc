package com.mapin.docmapin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mapin.docmapin.dto.PlaceServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_place_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
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
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@OneToMany(mappedBy = "placeService")
	private List<HealthProfessional> healthPro = new ArrayList<>();
	public PlaceService(PlaceServiceDto dto) {
		id = dto.getId();
		name = dto.getName();
		phone = dto.getPhone();
		cellPhone = dto.getCellPhone();
		cep = dto.getCep();
		logradouro = dto.getLogradouro();
		complemento = dto.getComplemento();
		bairro = dto.getBairro();
		localidade = dto.getLocalidade();
		uf = dto.getUf();
		clinic = dto.isClinic();
		hospital = dto.isHospital();
		medicalCenter = dto.isMedicalCenter();
		cir = dto.isCir();
		cityHall = dto.isCityHall();
		apae = dto.isApae();
		description = dto.getDescription();
	}
}

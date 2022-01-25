package com.mapin.docmapin.dto;

import com.mapin.docmapin.model.HealthProfessional;
import com.mapin.docmapin.model.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HealthProfessionalDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String imgUrl;
	private boolean femaleDoc;
	@NotBlank(message = "Campo obrigatório")
	private String register;
	@NotBlank(message = "Campo obrigatório")
	private String name;
	private String cardName;
	private String phone;
	@Email(message = "Digitar email válido!")
	private String email;
	private LocalDate birthDate;
	private String resume;
	private boolean byScheduling;
	
	private boolean seg;
	private String segPeriod;
	private boolean ter;
	private String terPeriod;
	private boolean qua;
	private String quaPeriod;
	private boolean qui;
	private String quiPeriod;
	private boolean sex;
	private String sexPeriod;
	private boolean sab;
	private String sabPeriod;
	private String officeHours;
	private boolean partner;
	private boolean strategic;
	private boolean potencial;
	private LocalDate schedulingDate;
	private ProfessionDto profession;
	private PlaceServiceDto placeService;
	
	private List<SpecializationDto> specializations = new ArrayList<>();
	
	public HealthProfessionalDto(HealthProfessional entity) {
		id = entity.getId();
		femaleDoc = entity.isFemaleDoc();
		imgUrl = entity.getImgUrl();
		register = entity.getRegister();
		name = entity.getName();
		cardName = entity.getName();
		
		String[] cardNameArray = name.split(" ");

		for (int i = 0; i < cardNameArray.length; i++) {
			cardName = cardNameArray[0] + " " + cardNameArray[cardNameArray.length - 1];
		}
		
		phone = entity.getPhone();
		email = entity.getEmail();
		birthDate = entity.getBirthDate();
		resume = entity.getResume();
		byScheduling = entity.isByScheduling();
		
		seg = entity.isSeg();
		
		if (entity.isSeg() == false) {
			segPeriod = "N/A";
		} else {
			segPeriod = entity.getSegPeriod();
		}
		
		ter = entity.isTer();
		
		if (entity.isTer() == false) {
			terPeriod = "N/A";
		} else {
			terPeriod = entity.getTerPeriod();
		}
		
		qua = entity.isQua();
		
		if (entity.isQua() == false) {
			quaPeriod = "N/A";
		} else {
			quaPeriod = entity.getQuaPeriod();
		}
		
		qui = entity.isQui();
		
		if (entity.isQui() == false) {
			quiPeriod = "N/A";
		} else {
			quiPeriod = entity.getQuiPeriod();
		}
		
		sex = entity.isSex();
		
		if (entity.isSex() == false) {
			sexPeriod = "N/A";
		} else {
			sexPeriod = entity.getSexPeriod();
		}
		
		sab = entity.isSab();
		
		if (entity.isSab() == false) {
			sabPeriod = "N/A";
		} else {
			sabPeriod = entity.getSabPeriod();
		}
		
		officeHours = entity.getOfficeHours();
		partner = entity.isPartner();
		strategic = entity.isStrategic();
		potencial = entity.isPotencial();

		profession = new ProfessionDto(entity.getProfession());
		placeService = new PlaceServiceDto(entity.getPlaceService());
		
	}
	
	public HealthProfessionalDto(HealthProfessional entity, Set<Specialization> specializations) {
		this(entity);
		specializations.forEach(s -> this.specializations.add(new SpecializationDto(s)));
	}
}

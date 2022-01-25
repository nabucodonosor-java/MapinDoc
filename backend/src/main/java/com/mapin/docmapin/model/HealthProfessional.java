package com.mapin.docmapin.model;

import com.mapin.docmapin.dto.HealthProfessionalDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_health_professional")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthProfessional implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String imgUrl;
	private boolean femaleDoc;
	@Column(unique = true)
	private String register;
	
	@Column(unique = true)
	private String name;
	private String cardName;
	private String phone;
	private String email;
	private LocalDate birthDate;
	
	@Column(columnDefinition = "TEXT")
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
	
	@Column(columnDefinition = "TEXT")
	private String officeHours;
	
	private boolean partner;
	private boolean strategic;
	private boolean potencial;
	
	@ManyToMany
	@JoinTable(name = "tb_professional_specialization", joinColumns = @JoinColumn(name = "professional_id"), 
	inverseJoinColumns = @JoinColumn(name = "specialization_id"))
	private Set<Specialization> specializations = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "profession_id")
	private Profession profession;
	
	@ManyToOne
	@JoinColumn(name = "place_service_id")
	private PlaceService placeService;
	
	public HealthProfessional(HealthProfessionalDto dto) {
		id = dto.getId();
		femaleDoc = dto.isFemaleDoc();
		imgUrl = dto.getImgUrl();
		register = dto.getRegister();
		name = dto.getName();
		cardName = dto.getCardName();
		
		String[] cardNameArray = name.split(" ");

		for (int i = 0; i < cardNameArray.length; i++) {
			cardName = cardNameArray[0] + " " + cardNameArray[cardNameArray.length - 1];
		}
		
		phone = dto.getPhone();
		email = dto.getEmail();
		birthDate = dto.getBirthDate();
		resume = dto.getResume();
		seg = dto.isSeg();
		segPeriod = dto.getSegPeriod();
		ter = dto.isTer();
		terPeriod = dto.getTerPeriod();
		qua = dto.isQua();
		quaPeriod = dto.getQuaPeriod();
		qui = dto.isQui();
		quiPeriod = dto.getQuiPeriod();
		sex = dto.isSex();
		sexPeriod = dto.getSexPeriod();
		sab = dto.isSab();
		sabPeriod = dto.getSabPeriod();
		officeHours = dto.getOfficeHours();
		partner = dto.isPartner();
		strategic = dto.isStrategic();
		potencial = dto.isPotencial();
		profession = new Profession(dto.getProfession());
		placeService = new PlaceService(dto.getPlaceService());
	}
	
	public HealthProfessional(HealthProfessionalDto dto, Set<Specialization> specializations) {
		this(dto);
		specializations.forEach(s -> this.specializations.add(s));
	}
}

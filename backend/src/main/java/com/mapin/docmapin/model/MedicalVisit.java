package com.mapin.docmapin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medical_visit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalVisit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate visitDate;

	@OneToOne
	@JoinColumn(name = "health_pro_id")
	private HealthProfessional healthPro;

	private boolean success;

	@Column(columnDefinition = "TEXT")
	private String description;
}

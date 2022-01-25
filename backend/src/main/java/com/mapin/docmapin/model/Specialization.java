package com.mapin.docmapin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_specialization")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	private Integer counter;
	
	@ManyToMany(mappedBy = "specializations")
	private Set<HealthProfessional> professionals = new HashSet<>();
}

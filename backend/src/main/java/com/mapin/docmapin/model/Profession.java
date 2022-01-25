package com.mapin.docmapin.model;

import com.mapin.docmapin.dto.ProfessionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_profession")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profession implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	public Profession(ProfessionDto dto) {
		id = dto.getId();
		name = dto.getName();
	}
}

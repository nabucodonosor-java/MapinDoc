package com.mapin.docmapin.dto;

import com.mapin.docmapin.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String authority;
	public RoleDto(Role entity) {
		id = entity.getId();
		authority = entity.getAuthority();
	}
}

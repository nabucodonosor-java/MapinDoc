package com.mapin.docmapin.dto;

import com.mapin.docmapin.model.User;
import com.mapin.docmapin.services.validations.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDto extends UserDto {
	private static final long serialVersionUID = 1L;
	
	public UserUpdateDto(User entity) {
		super(entity);
	}

}

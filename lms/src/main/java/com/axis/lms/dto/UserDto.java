package com.axis.lms.dto;

import com.axis.lms.constants.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private Integer userId;
	private String userName;
	private String password;
	private Role role;

}

package com.axis.lms.service;

import com.axis.lms.dto.UserDto;

public interface UserService {
	boolean save(UserDto udto);

	UserDto login(String userName, String password);
}

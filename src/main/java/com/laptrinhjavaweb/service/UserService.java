package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserService {
	UserEntity findByUserAndPass(UserEntity userEntity);
	
	UserEntity findByUser(UserEntity userEntity);
	
	UserEntity findByUserId(UserEntity userEntity);
}

package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserService {
	UserEntity findByUserAndPass(UserEntity userEntity);
	
	UserEntity findByName(String username);
	
	UserEntity findByUserId(UserEntity userEntity);
	
	UserEntity findNameAuthorByNewsId(int newsId);
	
	UserEntity getUserByUsername(String username);
	
	UserEntity findByUserId(int userId);
	
	void save(UserEntity userEntity);
}

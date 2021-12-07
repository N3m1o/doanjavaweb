package com.laptrinhjavaweb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity findByUserAndPass(UserEntity userEntity) {
		try {
			return userRepository.findByNameAndPass(userEntity.getUsername(), userEntity.getPassword());
		} catch (Exception e) {
			return null;
		}
	}


	public UserEntity findByUserId(UserEntity userEntity) {
		try {
			return userRepository.findById(userEntity.getFullname(), userEntity.getGender(), userEntity.getUsername(), userEntity.getPassword());
		} catch (Exception e) {
			return null;
		}
	}


	public UserEntity findByUser(UserEntity userEntity) {
		return userRepository.findByName(userEntity.getUsername());
	}


	public String nameAuthorByNewsId(int newsId) {
		return userRepository.nameAuthor(newsId);
	}
	
}

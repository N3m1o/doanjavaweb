package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Query(value = "select * from users u where u.username = ?1 and u.[password] = ?2", nativeQuery = true)
	UserEntity findByNameAndPass(String username, String password);
	
	@Query(value = "select * from users u where u.username = ?1", nativeQuery = true)
	UserEntity findByName(String username);
	
	@Query(value = "insert into users u values (null, u.fullname = ?1, u.gender = ?2, 0, 0, u.username = ?3, u.password = ?4)", nativeQuery = true)
	UserEntity findById(String fullname, Integer gender, String username, String password);
}

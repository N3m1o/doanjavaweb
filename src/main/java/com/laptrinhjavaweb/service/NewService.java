package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Optional;

import com.laptrinhjavaweb.entity.NewEntity;

public interface NewService {
	List<NewEntity> getAllNew();
	
	void saveNew(NewEntity newEntity);
	
	void deleteNew(int id);
	
	Optional<NewEntity> findNewById(int id);
}

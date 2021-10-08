package com.laptrinhjavaweb.serviceIpm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.NewService;

@Service
public class NewServiceImpl implements NewService{
	@Autowired
	private NewRepository newRepository;

	public List<NewEntity> getAllNew() {
		return (List<NewEntity>) newRepository.findAll();
	}

	public void saveNew(NewEntity newEntity) {
		newRepository.save(newEntity);
	}

	public void deleteNew(int id) {
		newRepository.delete(id);
	}

	public Optional<NewEntity> findNewById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public Optional<NewEntity> findNewById(int id) {
//		return newRepository.findById(id);
//	}
}

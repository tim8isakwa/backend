package com.univerzitet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Univerzitet;

@Service
public class UniverzitetService extends GenericService<Univerzitet, Long> {

	@Autowired
	public UniverzitetService(Repo<Univerzitet, Long> repository) {
		super(repository);
	}

	@Override
	public Univerzitet save(Univerzitet t) {
		return super.save(t);
	}

	@Override
	public Univerzitet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<Univerzitet> findAll() {
		return super.findAll();
	}

	public boolean existsById(Long id) {
		return this.existsById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}

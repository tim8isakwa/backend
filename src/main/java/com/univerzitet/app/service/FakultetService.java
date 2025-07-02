package com.univerzitet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Fakultet;

@Service
public class FakultetService extends GenericService<Fakultet, Long>{

	@Autowired
	public FakultetService(Repo<Fakultet, Long> repository) {
		super(repository);
	}

	@Override
	public Fakultet save(Fakultet t) {
		return super.save(t);
	}

	@Override
	public Fakultet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<Fakultet> findAll() {
		return super.findAll();
	}
	
	public Fakultet findByNaziv(String naziv) {
		return this.findByNaziv(naziv);
	}
	
	public boolean existsById(Long id) {
		return this.existsById(id);
	}

	@Override
	public Fakultet update(Fakultet t, Long id) {
		return super.update(t, id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}

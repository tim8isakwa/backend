package com.univerzitet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Fakultet;
import com.univerzitet.app.repo.FakultetRepo;

@Service
public class FakultetService extends GenericService<Fakultet, Long>{

	private FakultetRepo repo;
	
	@Autowired
	public FakultetService(Repo<Fakultet, Long> repository, FakultetRepo repo) {
		super(repository);
		this.repo = repo;
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
		return repo.findByNaziv(naziv);
	}
	
	public boolean existsById(Long id) {
		return repo.existsById(id);
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

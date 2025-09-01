package com.univerzitet.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Predmet;
import com.univerzitet.app.repo.PredmetRepo;

@Service
public class PredmetService extends GenericService<Predmet, Long> {

	private final PredmetRepo repository;
	
	public PredmetService(PredmetRepo repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Predmet save(Predmet t) {
		return super.save(t);
	}

	@Override
	public Predmet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<Predmet> findAll() {
		return super.findAll();
	}

	@Override
	public Predmet update(Predmet t, Long id) {
		return super.update(t, id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}

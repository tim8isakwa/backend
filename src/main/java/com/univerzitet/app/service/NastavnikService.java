package com.univerzitet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Nastavnik;

@Service
public class NastavnikService extends GenericService<Nastavnik, Long>{

	@Autowired
	public NastavnikService(Repo<Nastavnik, Long> repository) {
		super(repository);
	}

	@Override
	public Nastavnik save(Nastavnik t) {
		return super.save(t);
	}

	@Override
	public Nastavnik findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<Nastavnik> findAll() {
		return super.findAll();
	}

	@Override
	public Nastavnik update(Nastavnik t, Long id) {
		return super.update(t, id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}	
}

package com.univerzitet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.StudijskiProgram;
import com.univerzitet.app.repo.StudijskiProgramRepo;

@Service
public class StudijskiProgramService extends GenericService<StudijskiProgram, Long>{

	private StudijskiProgramRepo repo;
	
	@Autowired
	public StudijskiProgramService(Repo<StudijskiProgram, Long> repository, StudijskiProgramRepo repo) {
		super(repository);
		this.repo = repo;
	}

	@Override
	public StudijskiProgram save(StudijskiProgram t) {
		return super.save(t);
	}

	@Override
	public StudijskiProgram findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<StudijskiProgram> findAll() {
		return super.findAll();
	}

	public StudijskiProgram findByNaziv(String naziv) {
		return repo.findByNaziv(naziv);
	}
	
	public boolean existsById(Long id) {
		return repo.existsById(id);
	}
	
	@Override
	public StudijskiProgram update(StudijskiProgram t, Long id) {
		return super.update(t, id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}

package com.univerzitet.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Student;

@Service
public class StudentService extends GenericService<Student, Long> {

	public StudentService(Repo<Student, Long> repository) {
		super(repository);
	}

	@Override
	public Student save(Student t) {
		return super.save(t);
	}

	@Override
	public Student findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<Student> findAll() {
		return super.findAll();
	}

	@Override
	public Student update(Student t, Long id) {
		return super.update(t, id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}

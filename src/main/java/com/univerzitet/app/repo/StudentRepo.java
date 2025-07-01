package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Student;

@Repository
public interface StudentRepo extends Repo<Student, Long>{
	
}

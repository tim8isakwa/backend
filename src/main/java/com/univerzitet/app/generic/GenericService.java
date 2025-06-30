package com.univerzitet.app.generic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityNotFoundException;

public abstract class GenericService<T, Long> {

	@Autowired
	private Repo<T, Long> repository;
	
	public GenericService(Repo<T, Long> repository) {
		super();
		this.repository = repository;
	}

	public T save(T t) {
		return repository.save(t);
	}
	
	public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T update(T t, Long id) {
    	if (!repository.existsById(id)) {
    		throw new EntityNotFoundException("Entity with ID " + id + " not found.");
    	}
    	
    	return repository.save(t);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

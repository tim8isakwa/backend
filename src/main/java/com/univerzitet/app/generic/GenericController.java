package com.univerzitet.app.generic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class GenericController<T> {

	private final GenericService<T, Long> service;

	public GenericController(GenericService<T, Long> service) {
		super();
		this.service = service;
	}
	
    public ResponseEntity<List<T>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
	
    public ResponseEntity<T> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    public ResponseEntity<T> update(@RequestBody T updated, Long id){
        return ResponseEntity.ok(service.update(updated, id));
    }

    public ResponseEntity<T> create(@RequestBody T created){
        return ResponseEntity.ok(service.save(created));
    }
    
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Ok");
    }	
}

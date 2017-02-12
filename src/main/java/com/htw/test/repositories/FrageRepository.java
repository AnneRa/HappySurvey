package com.htw.test.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.htw.test.model.Frage;

public interface FrageRepository extends CrudRepository<Frage, Long> {
	
}

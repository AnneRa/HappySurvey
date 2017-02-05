package com.htw.test.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.htw.test.model.Frage;
import com.htw.test.model.FrageOptionen;

public interface FrageOptionenRepository extends CrudRepository<FrageOptionen, Long> {
	
    @Modifying
    @Transactional
    @Query("delete from FrageOptionen where fragen_id = ?1")
    void deleteAllForQuestion(Long questionId);

}

package com.htw.test.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.htw.test.model.Antworten;

public interface AntwortRepository extends CrudRepository<Antworten, Long> {
	
	//@Query(value = "SELECT avg(antworten.wert) FROM antworten JOIN frage ON antworten.frage_id=frage.frage_id WHERE frage.frage_id=:id", nativeQuery = true)
	@Query(value = "SELECT avg(wert) FROM antworten WHERE frage_id=:id", nativeQuery = true)
	  Float getAverageResultForQuestionId(@Param("id") long id );
	
	//@Query(value = "SELECT antworten.wert FROM antworten JOIN frage ON antworten.frage_id=frage.frage_id WHERE frage.frage_id=:id", nativeQuery = true)
	@Query(value = "SELECT wert FROM antworten WHERE frage_id=:id", nativeQuery = true)
	  String[] getTextsForQuestionId(@Param("id") long id );

	@Query(value = "SELECT count(frage_option_id) FROM multiple_choice_antworten WHERE frage_option_id=:id", nativeQuery = true)
	  long getCountsForQuestionOptionId(@Param("id") long id );
	
}

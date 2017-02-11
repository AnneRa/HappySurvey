package com.htw.test.repositories;

import org.springframework.data.repository.CrudRepository;

import com.htw.test.model.Antworten;
import com.htw.test.model.Teilnehmer;

public interface TeilnehmerRepository extends CrudRepository<Teilnehmer, Long> {

}

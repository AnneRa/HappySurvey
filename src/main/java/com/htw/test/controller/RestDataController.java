package com.htw.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htw.test.model.Umfrage;
import com.htw.test.repositories.UmfrageRepository;

@RestController
// @RequestMapping("/api/v1")
public class RestDataController {

	@Autowired
	private UmfrageRepository umfrageRepository;

	@RequestMapping(path = "/get/umfragen", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<List<Umfrage>> getAllUmfragen() {
		List<Umfrage> umfragen = new ArrayList<Umfrage>();
		for (Umfrage u : umfrageRepository.findAll()) {

			umfragen.add(u);
		}
		if (umfragen.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(umfragen);
	}

	@RequestMapping(path = "/get/umfrage/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> getUmfrageById(@PathVariable int id) {
		Umfrage umfrage = umfrageRepository.findOne(id);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(umfrage);
	}

	@RequestMapping(path = "/new/umfrage/{id}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> addUmfrage(@PathVariable int id) {

		Umfrage tst = new Umfrage();
		tst.setId(id);

		Umfrage saved = umfrageRepository.save(tst);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@RequestMapping(path = "/del/umfrage/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> deleteumfrageById(@PathVariable int id) {
		Umfrage umfrage = umfrageRepository.findOne(id);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		umfrageRepository.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@RequestMapping(path = "/update/umfrage/{id}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> updateUmfrageById(@PathVariable int id, @RequestBody Umfrage update) {
		Umfrage umfrage = umfrageRepository.findOne(id);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		umfrage.setName(update.getName());
		umfrageRepository.save(umfrage);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}

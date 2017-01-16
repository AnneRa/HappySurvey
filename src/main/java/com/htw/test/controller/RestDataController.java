package com.htw.test.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.google.common.collect.Lists;
import com.htw.test.model.Frage;
import com.htw.test.model.Gruppe;
import com.htw.test.model.Umfrage;
import com.htw.test.repositories.FrageRepository;
import com.htw.test.repositories.GruppeRepository;
import com.htw.test.repositories.UmfrageRepository;

import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class RestDataController {

	@Autowired
	private UmfrageRepository umfrageRepository;
	private FrageRepository frageRepository;
	private GruppeRepository gruppeRepository;

	/*#### UMFRAGE ####*/

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

	@RequestMapping(path = "/new/umfrage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	//public ResponseEntity<Umfrage> addUmfrage(@PathVariable int id) {
	public ResponseEntity<Umfrage> addUmfrage(@RequestBody Umfrage umf) {
		
		// Werte Übergeben
		Umfrage umfrage = new Umfrage(umf);
		Umfrage saved = umfrageRepository.save(umfrage);
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


	/*************************************************************************************************************************
	 *
	 * @param gruppeId
	 * @return
	 */
	@RequestMapping(path = "get/fragen/{gruppeId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<List<Frage>> getUmfrage(@PathVariable("gruppenId") Integer gruppeId)
	{

		Gruppe gruppen = gruppeRepository.findOne(gruppeId);

		if (gruppen == null) {
			throw new EntityNotFoundException("Gruppen id " + gruppeId + " not found.");
		}

		List<Frage> datasets = Lists.newArrayList(gruppen.getFragen());

		return ResponseEntity.status(HttpStatus.OK).body(datasets);


	}

	/**********************************************************************************************************************
	 * 
	 * @param gruppeId
	 * @param fragen
	 * @return
	 */

	@RequestMapping(path = "/fragen/{gruppenId}", method = RequestMethod.POST, produces = "application/json; charset=utf-8",
			consumes = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Frage> addFrage(@PathVariable("gruppeId") Integer gruppeId,
			@RequestBody Frage frage) {

		Gruppe gruppe = gruppeRepository.findOne(gruppeId);

		if (gruppe == null) {
			throw new EntityNotFoundException("Gruppe id " + gruppeId + " not found.");
		}

		Integer umfrage = frage.getUmfrageNr();
		if (!umfrageRepository.exists(umfrage)) {
			throw new EntityNotFoundException("Umfrage  " + umfrage + " not found.");
		}


		gruppe.addFrage(frage);
		gruppeRepository.save(gruppe);

		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	/*****************************************************************************************************************************************************
	 *
	 * @param newGruppe
	 * @return
	 */
	@RequestMapping(path = "/new/gruppen", method = RequestMethod.POST, consumes = "application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	@ResponseBody
	//@ApiResponses(value = {
			//@ApiResponse(code = 201, message = "New gruppe created.", response = Gruppe.class),
			//@ApiResponse(code = 400, message = "Bad input.") })
	public ResponseEntity<Gruppe> addGruppe(@RequestBody Gruppe newGruppe) {

		if (gruppeRepository.exists(newGruppe.getId())) {
			throw new IllegalArgumentException("Error: Gruppe " + newGruppe.getId() + " already exists.");
		}

		Gruppe savedGruppe = gruppeRepository.save(newGruppe);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedGruppe);
	}

	/*****************************************************************************************************************************************************
	 *
	 * @param gruppeId
	 * @param updatedGruppe
	 * @return
	 */
	@RequestMapping(path = "/update/gruppen/{gruppeId}", method = RequestMethod.PUT, consumes = "application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	@ResponseBody
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "Gruppe updated.", response = Gruppe.class) })
	public ResponseEntity<Gruppe> updateGruppe(@PathVariable("GruppeId") Integer gruppeId,
			@RequestBody Gruppe updatedGruppe) {

		if (!gruppeRepository.exists(gruppeId)) {
			throw new EntityNotFoundException("Error: Control unit " + gruppeId + " does not exist.");
		}

		Gruppe savedGruppe = gruppeRepository.save(updatedGruppe);
		return ResponseEntity.status(HttpStatus.OK).body(savedGruppe);
	}



}

package com.htw.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.htw.test.model.Typ;
import com.htw.test.model.Umfrage;
import com.htw.test.repositories.FrageRepository;
import com.htw.test.repositories.GruppeRepository;
import com.htw.test.repositories.TypRepository;
import com.htw.test.repositories.UmfrageRepository;

import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class RestDataController {

	@Autowired
	private UmfrageRepository umfrageRepository;
	@Autowired
	private TypRepository typRepository;
	@Autowired
	private FrageRepository frageRepository;
	@Autowired
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

	@RequestMapping(path = "/get/umfrage/{link}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> getUmfrageByLink(@PathVariable String link) {
		Umfrage umfrage = umfrageRepository.findOne(link);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(umfrage);
	}

	@RequestMapping(path = "/new/umfrage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> addUmfrage(@RequestBody Umfrage umf) {
		
		   	UUID r1 = UUID.randomUUID();
			UUID r2 = UUID.randomUUID();
			String random_UUID = String.valueOf(r1+""+r2);
			umf.setLink(random_UUID);
			
		// Werte Übergeben
		Umfrage umfrage = new Umfrage(umf);
		Umfrage saved = umfrageRepository.save(umfrage);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);

	}

	@RequestMapping(path = "/del/umfrage/{link}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> deleteumfrageById(@PathVariable String link) {
		Umfrage umfrage = umfrageRepository.findOne(link);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		umfrageRepository.delete(link);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	
	
	@RequestMapping(path = "/update/umfrage/{link}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> updateUmfrageById(@PathVariable String link, @RequestBody Umfrage update) {
		Umfrage umfrage = umfrageRepository.findOne(link);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		umfrage.setName(update.getName());
		umfrage.setBeschr(update.getBeschr());
		umfrage.setIntro(update.getIntro());
		umfrage.setStartdat(update.getStartdat());
		umfrage.setEnddat(update.getEnddat());
		umfrageRepository.save(umfrage);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	/*#### FRAGETYP ####*/

	@RequestMapping(path = "/get/typen", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<List<Typ>> getAllTypen() {
		List<Typ> typen = new ArrayList<Typ>();
		for (Typ t : typRepository.findAll()) {

			typen.add(t);
		}
		if (typen.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(typen);
	}

	@RequestMapping(path = "/get/typ/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Typ> getTypById(@PathVariable int id) {
		Typ typ = typRepository.findOne(id);
		if (typ == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(typ);
	}

	@RequestMapping(path = "/new/typ", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Typ> addTyp(@RequestBody Typ t) {
				
		// Werte Übergeben
		Typ typ = new Typ(t);
		Typ saved = typRepository.save(typ);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);

	}

	@RequestMapping(path = "/del/typ/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> deleteTypById(@PathVariable int id) {
		Typ typ = typRepository.findOne(id);
		if (typ == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		typRepository.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	
	
	@RequestMapping(path = "/update/typ/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> updateTypById(@PathVariable int id, @RequestBody Typ update) {
		Typ typ = typRepository.findOne(id);
		if (typ == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		typ.setBezeichnung(update.getBezeichnung());
		typ.setFormat(update.getFormat());
		typ.setWert1(update.getWert1());
		typ.setWert2(update.getWert2());

		typRepository.save(typ);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/*#### FRAGE ####*/
	
	
	/*************************************************************************************************************************
	 *
	 * @param gruppeId
	 * @return
	 */
	@RequestMapping(path = "/get/fragen/{gruppeId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
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

		String umfrage = frage.getumfrageLink();
		if (!umfrageRepository.exists(umfrage)) {
			throw new EntityNotFoundException("Umfrage  " + umfrage + " not found.");
		}


		gruppe.addFrage(frage);
		gruppeRepository.save(gruppe);

		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	
	/*#### Gruppe ####*/
	
	@RequestMapping(path = "/get/gruppen", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<List<Gruppe>> getAllGruppen() {
		List<Gruppe> gruppen = new ArrayList<Gruppe>();
		for (Gruppe g : gruppeRepository.findAll()) {

			gruppen.add(g);
		}
		if (gruppen.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(gruppen);
	}

	@RequestMapping(path = "/get/gruppe/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Gruppe> getGruppeById(@PathVariable int id) {
		Gruppe gruppe = gruppeRepository.findOne(id);
		if (gruppe == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(gruppe);
	}
	
	@RequestMapping(path = "/new/gruppe", method = RequestMethod.POST, consumes = "application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Gruppe> addGruppe(@RequestBody Gruppe gru) {

		
		// Werte Übergeben
	    Gruppe gruppe = new Gruppe(gru);
		Gruppe saved = gruppeRepository.save(gruppe);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}


	@RequestMapping(path = "/del/gruppe/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> deleteGruppeById(@PathVariable int id) {
		Gruppe gruppe = gruppeRepository.findOne(id);
		if (gruppe == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		gruppeRepository.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	
	@RequestMapping(path = "/update/gruppe/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> updateGruppeById(@PathVariable int id, @RequestBody Gruppe update) {
		Gruppe gruppe = gruppeRepository.findOne(id);
		if (gruppe == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		gruppe.setName(update.getName());
		gruppe.setUmfrage(update.getUmfrage());
		gruppeRepository.save(gruppe);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}




}

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

import com.htw.test.Links;
import com.htw.test.model.Antworten;
import com.htw.test.model.Frage;
import com.htw.test.model.FrageOptionen;
import com.htw.test.model.Gruppe;
import com.htw.test.model.MultipleChoiceAntworten;
import com.htw.test.model.Teilnehmer;
import com.htw.test.model.Umfrage;
import com.htw.test.repositories.FrageOptionenRepository;
import com.htw.test.repositories.FrageRepository;
import com.htw.test.repositories.GruppeRepository;
import com.htw.test.repositories.TeilnehmerRepository;
import com.htw.test.repositories.UmfrageRepository;

@RestController
@RequestMapping("/api/v1")
public class RestDataController {

	@Autowired
	private UmfrageRepository umfrageRepository;
	@Autowired
	private FrageRepository frageRepository;
	@Autowired
	private FrageOptionenRepository frageOptionenRepository;
	@Autowired
	private GruppeRepository gruppeRepository;
	@Autowired
	private TeilnehmerRepository teilnehmerRepository;
	
	/*#### UMFRAGE ####*/
	
	@RequestMapping(path = "/getUmfrage/{link}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> getUmfrageByLink(@PathVariable String link) {
		Umfrage umfrage = umfrageRepository.findOne(Links.decodeLink(link));
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(umfrage);
	}

	@RequestMapping(path = "/umfragen", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
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

	@RequestMapping(path = "/umfrage/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> getUmfrageById(@PathVariable long id) {
		Umfrage umfrage = umfrageRepository.findOne(id);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(umfrage);
	}

	@RequestMapping(path = "/umfrage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> addUmfrage(@RequestBody Umfrage umf) {
		
		   	//UUID r1 = UUID.randomUUID();
			//UUID r2 = UUID.randomUUID();
			//String random_UUID = String.valueOf(r1+""+r2);
			//umf.setLink(random_UUID);
			
		// Werte Übergeben
		Umfrage umfrage = new Umfrage(umf);
		Umfrage saved = umfrageRepository.save(umfrage);
		addGruppe(new Gruppe(saved));
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);

	}

	@RequestMapping(path = "/umfrage/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> deleteumfrageById(@PathVariable long id) {
		Umfrage umfrage = umfrageRepository.findOne(id);
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		umfrageRepository.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	
	
	@RequestMapping(path = "/umfrage", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Umfrage> updateUmfrageById(@RequestBody Umfrage umf) {
		Umfrage umfrage = umfrageRepository.findOne(umf.getId());
		if (umfrage == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		umfrage.setName(umf.getName());
		umfrage.setBeschr(umf.getBeschr());
		umfrage.setIntro(umf.getIntro());
		umfrage.setStartdat(umf.getStartdat());
		umfrage.setEnddat(umf.getEnddat());
		umfrageRepository.save(umfrage);
		
		// Gruppen in Umfrage erstellen
		for ( Gruppe group : umf.getGruppen() ) {
			if (group.getId() == 0) {
				group.setUmfrage(umfrage);
				addGruppe(group);
			} else {
				updateGruppe(group);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(umfrage);
	}
	
	/*#### FRAGE ####*/
	
	/*************************************************************************************************************************
	 *
	 * @param FrageId
	 * @return
	 */
	@RequestMapping(path = "/frage/{frageId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Frage> getFrage(@PathVariable("frageId") long fraId)
	{	
		Frage fra = frageRepository.findOne(fraId);
		if (fra == null) {
			throw new EntityNotFoundException("Frage id " + fraId + " not found.");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(fra);
		
	}


	/*************************************************************************************************************************
	 *
	 * @param FrageId
	 * @param UmfrageId
	 * @return
	 */
	@RequestMapping(path = "/del/umfrage/{umfrageId}/frage/{frageId}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<List<Frage>> delFrage(@PathVariable("umfrageId") long umfId, @PathVariable("frageId") long fraId)
	{	
		Frage fra = frageRepository.findOne(fraId);
		if (fra == null) {
			throw new EntityNotFoundException("Frage id " + fraId + " not found.");
		}
		frageRepository.delete(fra);
		
		return this.getFragen(umfId);
		
	}
	
	/*************************************************************************************************************************
	 *
	 * @param UmfrageId
	 * @return
	 */
	@RequestMapping(path = "/get/fragen/{umfrageId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<List<Frage>> getFragen(@PathVariable("umfrageId") long umfId)
	{

		Umfrage umf = umfrageRepository.findOne(umfId);

		if (umf == null) {
			throw new EntityNotFoundException("Umfrage id " + umfId + " not found.");
		}

		//Lists.newArrayList(gruppen.getFragen());
		List<Frage> datasets = new ArrayList<>();
		for ( Gruppe gru : umf.getGruppen() ) {
			datasets.addAll(gru.getFragen());
		};

		return ResponseEntity.status(HttpStatus.OK).body(datasets);

	}

	/**********************************************************************************************************************
	 * 
	 * @param gruppeId
	 * @param fragen
	 * @return
	 */

	@RequestMapping(path = "/fragen/{gruppeId}", method = RequestMethod.POST, produces = "application/json; charset=utf-8",
			consumes = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Frage> addFrage(@PathVariable("gruppeId") long gruppeId,
			@RequestBody Frage neueFrage) {
		
		Gruppe gruppen = gruppeRepository.findOne(gruppeId);

		if (gruppen == null) {
			throw new EntityNotFoundException("Gruppen id " + gruppeId + " not found.");
		}

		Frage frage = new Frage( gruppen, neueFrage );
		int i = 0;
		for ( FrageOptionen neueOption : neueFrage.getOptionen() ) {
			i++;
			FrageOptionen fo = new FrageOptionen(i, neueOption.getText(), frage);
			frage.addOption(fo);
		}
		Frage saved = frageRepository.save(frage);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	/**********************************************************************************************************************
	 * 
	 * @param gruppeId
	 * @param frage
	 * @return
	 */
	@RequestMapping(path = "/fragen/{gruppeId}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8",
			consumes = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Frage> updateFrage(@PathVariable("gruppeId") long gruppeId,
			@RequestBody Frage upFra) {
		
		Gruppe gruppen = gruppeRepository.findOne(gruppeId);
		if (gruppen == null) {
			throw new EntityNotFoundException("Gruppen id " + gruppeId + " not found.");
		}

		Frage frage = frageRepository.findOne(upFra.getId());
		if (frage == null) {
			throw new EntityNotFoundException("Frage id " + upFra.getId() + " not found.");
		}
		
		frage.setGruppe(gruppen);
		frage.setInfo(upFra.getInfo());
		frage.setOptional(upFra.isOptional());
		frage.setText(upFra.getText());
		frage.setType(upFra.getType());
		
		boolean updateOptions = frage.getOptionen().size() != upFra.getOptionen().size();
		if ( !updateOptions ) {
			List<FrageOptionen> old = frage.getOptionen();
			List<FrageOptionen> upd = upFra.getOptionen();
			for ( int i = 0; i < old.size(); i++) {
				FrageOptionen oldOpt = old.get(i);
				FrageOptionen updOpt = upd.get(i);
				if ( !oldOpt.getText().equals(updOpt.getText()) ) {
					updateOptions = true;
					break;
				}
			}
		}
		
		if (updateOptions) {
			frageOptionenRepository.deleteAllForQuestion( (long) frage.getId());
			frage.clearOptions();
			int i = 0;
			for ( FrageOptionen neueOption : upFra.getOptionen() ) {
				i++;
				FrageOptionen fo = new FrageOptionen(i, neueOption.getText(), frage);
				frage.addOption(fo);
			}
		}

		Frage saved = frageRepository.save(frage);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
		
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
	public ResponseEntity<Gruppe> getGruppeById(@PathVariable long id) {
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
	public ResponseEntity<Void> deleteGruppeById(@PathVariable long id) {
		Gruppe gruppe = gruppeRepository.findOne(id);
		if (gruppe == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		gruppeRepository.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	
	@RequestMapping(path = "/update/gruppe", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Void> updateGruppe(@RequestBody Gruppe update) {
		Gruppe gruppe = gruppeRepository.findOne(update.getId());
		if (gruppe == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		gruppe.setName(update.getName());
		gruppeRepository.save(gruppe);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

// BETA
	
	@RequestMapping(path = "/getTN/{antId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Teilnehmer> getTNById(@PathVariable long antId) {
		Teilnehmer teilnehmer = teilnehmerRepository.findOne(antId);
		Frage fra = teilnehmer.getAntworten().get(0).getFrage();
		System.out.println(fra.getId());
		System.out.println(fra.getText());
		System.out.println(fra.getGroupId());
		System.out.println(fra.getGroupName());
		System.out.println(fra.getInfo());
		System.out.println(fra.getOptionen().size());
		System.out.println(fra.getType());
		return ResponseEntity.status(HttpStatus.OK).body(teilnehmer);
	}

	@RequestMapping(path = "/setTN", method = RequestMethod.POST, consumes = "application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Teilnehmer> addTeilnehmer(@RequestBody Teilnehmer newTN) {
		
		Teilnehmer tn = new Teilnehmer(newTN.getMail());
		
		for ( Antworten ans : newTN.getAntworten() ) {
			Frage newQuestion = frageRepository.findOne(ans.getFrage().getId() );
			Antworten newAns = new Antworten( tn, newQuestion, ans );
			if (ans.getMultipleChoiceAntworten() != null) {
				for ( MultipleChoiceAntworten mca : ans.getMultipleChoiceAntworten() ) {
					FrageOptionen fo = frageOptionenRepository.findOne(mca.getFrageOption().getId());
					MultipleChoiceAntworten newMCA = new MultipleChoiceAntworten( fo, newAns );
					newAns.addMultipleChoice(newMCA);
				}
			}
			tn.addAnswer(newAns);
		}
		
		Teilnehmer saved = teilnehmerRepository.save(tn);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	
}

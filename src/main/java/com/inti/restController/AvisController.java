package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Avis;
import com.inti.services.interfaces.IAvisService;

@RestController
@CrossOrigin
public class AvisController {

	@Autowired
	IAvisService avisService;

	// GET
	@RequestMapping(value = "avis", method = RequestMethod.GET)
	public List<Avis> findAll() {
		return avisService.findAll();
	}

	@RequestMapping(value = "avis/{idAvis}", method = RequestMethod.GET)
	public Avis findOne(@PathVariable("idAvis") Long id) {
		return avisService.findOne(id);
	}

	// POST
	@RequestMapping(value = "avis", method = RequestMethod.POST)
	public Avis saveEntite(@RequestBody Avis avis) {
		return avisService.save(avis);
	}

	// DELETE
	@RequestMapping(value = "avis/{idAvis}", method = RequestMethod.DELETE)
	public void deleteEntite(@PathVariable("idAvis") Long id) {
		avisService.delete(id);
	}

	// PUT
	@RequestMapping(value = "avis/{idAvis}", method = RequestMethod.PUT)
	public Avis updateEntite(@PathVariable("idAvis") Long id, @RequestBody Avis avis) {
		Avis currentAvis = avisService.findOne(id);
		currentAvis.setId(avis.getId());
		currentAvis.setTitre(avis.getTitre());
		currentAvis.setDescription(avis.getDescription());
		return avisService.save(currentAvis);
	}

}

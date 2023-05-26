package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.services.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {

	@Autowired
	IUtilisateurService utilisateurService;

	// GET
	@RequestMapping(value = "utilisateurs", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long idUtilisateur) {
		return utilisateurService.findOne(idUtilisateur);
	}

	// POST
	@RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
	public Utilisateur saveEntite(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.save(utilisateur);
	}

	// DELETE
	@RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
	public void deleteEntite(@PathVariable("idUtilisateur") Long idUtilisateur) {
		utilisateurService.delete(idUtilisateur);
	}

	// PUT
	@RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.PUT)
	public Utilisateur updateEntite(@PathVariable("idUtilisateur") Long idUtilisateur, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(idUtilisateur);
		currentUtilisateur.setIdUtilisateur(utilisateur.getIdUtilisateur());
		currentUtilisateur.setNom(utilisateur.getNom());
		currentUtilisateur.setPrenom(utilisateur.getPrenom());
		currentUtilisateur.setLogin(utilisateur.getLogin());
		currentUtilisateur.setPassword(utilisateur.getPassword());
		currentUtilisateur.setDateNaissance(utilisateur.getDateNaissance());
		return utilisateurService.save(currentUtilisateur);
	}

}

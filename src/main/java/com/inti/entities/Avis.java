package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.inti.entities.Utilisateur;

@Entity
@Table(name = "AVIS", schema = "gestion_salon_coiffure_db")
public class Avis implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	public Avis() {

	}

	public Avis(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Utilisateur getUtilisateur() { 
		return utilisateur; 
	}
	public void setUtilisateur(Utilisateur utilisateur) { 
		this.utilisateur = utilisateur; 
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", titre=" + titre + ", description=" + description + ", utilisateur=" + utilisateur + "]";
	}

}

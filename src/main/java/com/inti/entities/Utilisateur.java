package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.inti.entities.Role;
import com.inti.entities.Avis;

@Entity
@Table(name = "UTILISATEURS", schema = "gestion_salon_coiffure_db")
public class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String dateNaissance;

	@OneToMany(mappedBy = "utilisateur") 
	private List<Avis> avis = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "jointureUtilisateurRole", 
			joinColumns = @JoinColumn(name = "id_Utilisateur", referencedColumnName = "idUtilisateur"), 
			inverseJoinColumns = @JoinColumn(name = "id_Role", referencedColumnName = "idRole"))
	private Set<Role> role = new HashSet<>();
	@OneToMany(mappedBy="utilisateurRes")
	private List<Reservation> reservations = new ArrayList<>();
	
	
	public Utilisateur() {

	}

	public Utilisateur(String nom, String prenom, String login, String password, String dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.dateNaissance = dateNaissance;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
				+ ", dateNaissance=" + dateNaissance + "]";
	}


}

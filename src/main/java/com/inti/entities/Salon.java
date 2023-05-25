package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SALONS", schema = "gestion_salon_coiffure_db")
public class Salon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	@ManyToOne
	@JoinColumn(name = "id_reservation")
	private Reservation reservationSal;

	public Salon() {
	}

	public Salon(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Reservation getReservation() {
		return reservationSal;
	}

	public void setReservation(Reservation reservation) {
		this.reservationSal = reservation;
	}

	@Override
	public String toString() {
		return "Salon [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", reservation=" + reservationSal + "]";
	}

}

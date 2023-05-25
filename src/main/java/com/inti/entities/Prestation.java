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
@Table(name = "PRESTATIONS", schema = "gestion_salon_coiffure_db")
public class Prestation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@ManyToOne
	@JoinColumn(name = "id_reservation")
	private Reservation reservationPrest;

	public Prestation() {
	}

	public Prestation(String nom, Reservation reservation) {
		super();
		this.nom = nom;
		this.reservationPrest = reservation;
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

	public Reservation getReservation() {
		return reservationPrest;
	}

	public void setReservation(Reservation reservation) {
		this.reservationPrest = reservation;
	}

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", nom=" + nom + ", reservation=" + reservationPrest + "]";
	}

}

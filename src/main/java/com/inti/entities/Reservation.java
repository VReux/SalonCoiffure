package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RESERVATIONS", schema = "gestion_salon_coiffure_db")
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToMany(mappedBy = "reservationSal")
	private List<Salon> salons = new ArrayList<>();
	@OneToMany(mappedBy = "reservationPrest")
	private List<Prestation> prestations = new ArrayList<>();
	
	public Reservation() {
	}

	public Reservation(Date date, List<Salon> salons, List<Prestation> prestations) {
		super();
		this.date = date;
		this.salons = salons;
		this.prestations = prestations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Salon> getSalons() {
		return salons;
	}

	public void setSalons(List<Salon> salons) {
		this.salons = salons;
	}

	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", salons=" + salons + ", prestations=" + prestations + "]";
	}

}

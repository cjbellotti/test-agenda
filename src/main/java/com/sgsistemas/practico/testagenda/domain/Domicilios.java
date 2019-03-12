package com.sgsistemas.practico.testagenda.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table (name = "domicilios")

public class Domicilios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="persona_id")
	private Personas persona;
	
	private String calle;
	private int numero;
	private int piso;
	
	@ManyToOne
	@JoinColumn(name="localidad_id")
	private Localidades localidades;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Personas getPersona() {
		return persona;
	}

	public void setPersona(Personas personas) {
		this.persona = personas;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public Localidades getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Localidades localidades) {
		this.localidades = localidades;
	}
	
	

}

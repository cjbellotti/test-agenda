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
@Table (name = "contactos")

public class Contactos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Personas persona;
	
	private String Contacto;
	
	@ManyToOne
	@JoinColumn(name = "tipo_contacto_id")
	private TiposContacto tipocontacto;

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

	public String getContacto() {
		return Contacto;
	}

	public void setContacto(String contacto) {
		Contacto = contacto;
	}

	public TiposContacto getTipocontacto() {
		return tipocontacto;
	}

	public void setTipocontacto(TiposContacto tipocontacto) {
		this.tipocontacto = tipocontacto;
	}
	
	
	
	
	
	
	
}

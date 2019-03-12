package com.sgsistemas.practico.testagenda.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "personas")
public class Personas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	private String apellido;
	private String observaciones;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contactos> contactos;

	@JsonManagedReference
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Domicilios> domicilios;

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public List<Contactos> getContactos() {
		return contactos;
	}
	public void setContactos(List<Contactos> contactos) {
		this.contactos = contactos;
	}
	public List<Domicilios> getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(List<Domicilios> domicilios) {
		this.domicilios = domicilios;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}

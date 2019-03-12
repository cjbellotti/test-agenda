package com.sgsistemas.practico.testagenda.service;

import java.util.List;

import com.sgsistemas.practico.testagenda.domain.Personas;

public interface PersonaService {

	public List<Personas> getAll();
	
	public Personas getById(Long id);
	
	public List<Personas> getAllByPatron(String patron);
	
	public Personas save(Personas persona);
	
	public Personas delete(Long id);
	
}

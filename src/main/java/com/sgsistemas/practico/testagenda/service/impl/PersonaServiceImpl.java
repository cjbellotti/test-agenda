package com.sgsistemas.practico.testagenda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgsistemas.practico.testagenda.domain.Personas;
import com.sgsistemas.practico.testagenda.repository.PersonasRepository;
import com.sgsistemas.practico.testagenda.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonasRepository personaRepository;
	
	@Override
	public List<Personas> getAll() {
		return this.personaRepository.findAll();
	}

	@Override
	public Personas getById(Long id) {
		return this.personaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Personas> getAllByPatron(String patron) {
		List<Personas> result = null;
		if (patron != null) {
			result = this.personaRepository.findByNombreContains(patron);
		} else {
			result = this.personaRepository.findAll();
		}
		return result;
	}

	@Override
	public Personas save(Personas persona) {
		return this.personaRepository.save(persona);
	}

	@Override
	public Personas delete(Long id) {
		Personas persona = this.getById(id);
		if (persona != null) {
			this.personaRepository.delete(persona);
		}
		return persona;
	}

}

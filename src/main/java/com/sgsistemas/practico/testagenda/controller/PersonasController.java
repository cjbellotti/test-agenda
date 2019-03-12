package com.sgsistemas.practico.testagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgsistemas.practico.testagenda.domain.Personas;
import com.sgsistemas.practico.testagenda.repository.PersonasRepository;
import com.sgsistemas.practico.testagenda.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonasController {

		@Autowired
		private PersonaService personaService;
		
		@GetMapping
		public List<Personas> getall(
				@RequestParam(name = "patron", required = false) String patron
				){
			return this.personaService.getAllByPatron(patron);
		}
		
		@PostMapping
		public Personas save(@RequestBody Personas c) {
			return this.personaService.save(c);
		}
		
		@GetMapping("/{id}")
		public Personas getByid(@PathVariable("id") Long id) {
			return this.personaService.getById(id);
		}
		
	}
	
	


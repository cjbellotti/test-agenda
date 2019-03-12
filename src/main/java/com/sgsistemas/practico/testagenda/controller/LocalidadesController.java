package com.sgsistemas.practico.testagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgsistemas.practico.testagenda.domain.Localidades;
import com.sgsistemas.practico.testagenda.repository.LocalidadesRepository;

@RestController
@RequestMapping("/localidades")
public class LocalidadesController {

		@Autowired
		private LocalidadesRepository localidadesRepository;
		
		@GetMapping
		public List<Localidades> getall(){
			return this.localidadesRepository.findAll();
		}
		
		@PostMapping
		public Localidades save(@RequestBody Localidades c) {
			return this.localidadesRepository.save(c);
		}
		
		@GetMapping("/{id}")
		public Localidades getByid(@PathVariable("id") Long Id) {
			return this.localidadesRepository.findById(Id).orElse(null);
		}
		
	}
	
	


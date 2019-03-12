package com.sgsistemas.practico.testagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgsistemas.practico.testagenda.domain.Contactos;
import com.sgsistemas.practico.testagenda.repository.ContactosRepository;

@RestController
@RequestMapping("/contactos")
public class ContactosController {

		@Autowired
		private ContactosRepository contactosRepository;
		
		@GetMapping
		public List<Contactos> getall(){
			return this.contactosRepository.findAll();
		}
		
		@PostMapping
		public Contactos save(@RequestBody Contactos c) {
			return this.contactosRepository.save(c);
		}
		
		@GetMapping("/{id}")
		public Contactos getByid(@PathVariable("id") Long Id) {
			return this.contactosRepository.findById(Id).orElse(null);
		}
		
	}
	
	


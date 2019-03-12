package com.sgsistemas.practico.testagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgsistemas.practico.testagenda.domain.Domicilios;
import com.sgsistemas.practico.testagenda.repository.DomiciliosRepository;

@RestController
@RequestMapping("/domicilios")
public class DomiciliosController {

		@Autowired
		private DomiciliosRepository domiciliosRepository;
		
		@GetMapping
		public List<Domicilios> getall(){
			return this.domiciliosRepository.findAll();
		}
		
		@PostMapping
		public Domicilios save(@RequestBody Domicilios c) {
			return this.domiciliosRepository.save(c);
		}
		
		@GetMapping("/{id}")
		public Domicilios getByid(@PathVariable("id") Long Id) {
			return this.domiciliosRepository.findById(Id).orElse(null);
		}
		
	}
	
	


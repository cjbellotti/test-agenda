package com.sgsistemas.practico.testagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgsistemas.practico.testagenda.domain.TiposDomicilio;
import com.sgsistemas.practico.testagenda.repository.TiposDomicilioRepository;

@RestController
@RequestMapping("/tiposdomicilio")
public class TiposDomicilioController {

		@Autowired
		private TiposDomicilioRepository tiposdomicilioRepository;
		
		@GetMapping
		public List<TiposDomicilio> getall(){
			return this.tiposdomicilioRepository.findAll();
		}
		
		@PostMapping
		public TiposDomicilio save(@RequestBody TiposDomicilio c) {
			return this.tiposdomicilioRepository.save(c);
		}
		
		@GetMapping("/{id}")
		public TiposDomicilio getByid(@PathVariable("id") Long Id) {
			return this.tiposdomicilioRepository.findById(Id).orElse(null);
		}
		
	}
	
	



package com.sgsistemas.practico.testagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgsistemas.practico.testagenda.domain.TiposContacto;
import com.sgsistemas.practico.testagenda.repository.TiposContactoRepository;

@RestController
@RequestMapping("/tiposcontacto")
public class TiposContactoController {

		@Autowired
		private TiposContactoRepository tiposcontactoRepository;
		
		@GetMapping
		public List<TiposContacto> getall(){
			return this.tiposcontactoRepository.findAll();
		}
		
		@PostMapping
		public TiposContacto save(@RequestBody TiposContacto c) {
			return this.tiposcontactoRepository.save(c);
		}
		
		@GetMapping("/{id}")
		public TiposContacto getByid(@PathVariable("id") Long Id) {
			return this.tiposcontactoRepository.findById(Id).orElse(null);
		}
		
	}
	
	


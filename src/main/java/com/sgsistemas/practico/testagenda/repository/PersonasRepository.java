package com.sgsistemas.practico.testagenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgsistemas.practico.testagenda.domain.Personas;

public interface PersonasRepository extends JpaRepository<Personas, Long>{

	@Query("select p from Personas p where p.nombre like '%:patron%'")
	public List<Personas> getPersonasConPatron(@Param("patron") String patron);

	public List<Personas> findByNombreContains(String patron);
		
}

package com.show.business.tecnica.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.show.business.tecnica.model.Funcion;
import com.show.business.tecnica.model.Ticket;

@Repository
public interface TicketRepositorio extends JpaRepository<Ticket, Long>  {
	List<Ticket> findByFuncion(Funcion funcion);
	@Query(value = "SELECT t " 
			+ " FROM Ticket t"
			+ "	 LEFT JOIN t.funcion f "
			+ "	 LEFT JOIN f.usuario u "
			+ " WHERE "
			+ "	f.id = :id "
			+ "	and u.id = :usuarioId "
			+ " and t.dni is null ")
	List<Ticket> findDisponibilidad(Long id, Long usuarioId);
}

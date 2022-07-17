package com.show.business.tecnica.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.show.business.tecnica.model.Show;
import com.show.business.tecnica.model.Usuario;

@Repository
public interface ShowRepositorio extends JpaRepository<Show, Long>  {
	List<Show> findByUsuario(Usuario usuario);
	
	@Query(value = "SELECT DISTINCT sh " 
			+ " FROM Funcion f "
			+ "	 LEFT JOIN f.precioSeccion ps "
			+ "	 LEFT JOIN f.sala s "
			+ "	 LEFT JOIN f.show sh "
			+ "	 LEFT JOIN s.establecimiento e "
			+ "	 LEFT JOIN f.usuario u "
			+ " WHERE "
			+ " (cast(:fechaDesde as timestamp) is null  or f.fechaHora > :fechaDesde ) "
			+ "	and  (cast(:fechaHasta as timestamp) is null  or f.fechaHora < :fechaHasta ) "
			+ "	and  ( :precioDesde is null or ps.precio >= :precioDesde) "
			+ "	and  ( :precioHasta is null or ps.precio <= :precioHasta)  "
			
			+ "	and  ( :idEstablecimiento is null or e.id = :idEstablecimiento)  "
			+ "	and  ( :idShow is null or sh.id = :idShow)  "
			+ "	and  ( :idFuncion is null or f.id = :idFuncion)  "
			+ "	and sh.activo = true "
			+ "	and u.id = :usuarioId ")
	Page<Show> findAllShow(
			Date fechaDesde, Date fechaHasta, 
			Double precioDesde,Double precioHasta,
			Long idEstablecimiento, Long idFuncion, Long idShow,
			Long usuarioId, Pageable pagina
	);
}

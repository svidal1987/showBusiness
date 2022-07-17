package com.show.business.tecnica.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.show.business.tecnica.model.Establecimiento;
import com.show.business.tecnica.model.Usuario;

@Repository
public interface EstablecimientoRepositorio extends JpaRepository<Establecimiento, Long>  {
	List<Establecimiento> findByUsuario(Usuario usuario);

}

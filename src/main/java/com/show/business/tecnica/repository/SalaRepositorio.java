package com.show.business.tecnica.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.show.business.tecnica.model.Establecimiento;
import com.show.business.tecnica.model.Sala;

@Repository
public interface SalaRepositorio extends JpaRepository<Sala, Long>  {
	List<Sala> findByEstablecimiento(Establecimiento establecimiento);
}

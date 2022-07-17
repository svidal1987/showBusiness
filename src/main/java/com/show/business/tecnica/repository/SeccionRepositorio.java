package com.show.business.tecnica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.show.business.tecnica.model.Seccion;

@Repository
public interface SeccionRepositorio extends JpaRepository<Seccion, Long>  {

}

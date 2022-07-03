package com.show.business.tecnica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.show.business.tecnica.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>  {

}

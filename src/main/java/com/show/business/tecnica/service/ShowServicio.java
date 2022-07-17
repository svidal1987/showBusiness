package com.show.business.tecnica.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.show.business.tecnica.dto.ShowRq;
import com.show.business.tecnica.model.Funcion;
import com.show.business.tecnica.model.Show;
import com.show.business.tecnica.repository.ShowRepositorio;

@Service
public class ShowServicio {
	
	@Autowired
	private ShowRepositorio repositorio;
	
	@Cacheable( cacheNames = "findAllShow", keyGenerator = "showKeyGenerator")
	public Page<Show> findAllShow(ShowRq show, Long usuarioId, Pageable pagina) {
		try {
			
			
			if(show.getFechaDesde()==null) {
				show.setFechaDesde(new Date());
			}
			if(usuarioId ==null || usuarioId==0) {
				throw new InternalError("No se pudo identificar el usuario");	
			}
			return repositorio.findAllShow(
					show.getFechaDesde(), show.getFechaHasta(), 
					show.getPrecioDesde(), show.getPrecioHasta(),
					show.getIdEstablecimiento(), show.getIdFuncion(),show.getIdShow(),
					usuarioId, pagina);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new InternalError("Problemas al intentar obtener las funciones. "+e.getMessage(), e);
		}
	}

}

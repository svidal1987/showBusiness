package com.show.business.tecnica.service;

import java.util.Date;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.show.business.tecnica.dto.DisponibilidadRs;
import com.show.business.tecnica.dto.FuncionRq;
import com.show.business.tecnica.model.Funcion;
import com.show.business.tecnica.model.Ticket;
import com.show.business.tecnica.model.Usuario;
import com.show.business.tecnica.repository.FuncionRepositorio;
import com.show.business.tecnica.repository.TicketRepositorio;

@Service
public class FuncionServicio {
	
	@Autowired
	private FuncionRepositorio repositorio;

	@Autowired
	private TicketRepositorio ticketRepositorio;
	
	
	@Cacheable( cacheNames = "findAllFuncion", keyGenerator = "funcionKeyGenerator")
	public Page<Funcion> findAllFuncion(FuncionRq funcion, Long usuarioId, Pageable pagina) {
		try {
			
			
			if(funcion.getFechaDesde()==null) {
				funcion.setFechaDesde(new Date());
			}
			if(usuarioId ==null || usuarioId==0) {
				throw new InternalError("No se pudo identificar el usuario");	
			}
			return repositorio.findAllFuncion(
					funcion.getFechaDesde(), funcion.getFechaHasta(), 
					funcion.getPrecioDesde(), funcion.getPrecioHasta(),
					funcion.getIdEstablecimiento(), funcion.getIdFuncion(),funcion.getIdShow(),
					usuarioId, pagina);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new InternalError("Problemas al intentar obtener las funciones. "+e.getMessage(), e);
		}
	}
	@Cacheable( cacheNames = "findDisponibilidad", key = "{#id, #usuarioId}")
	public DisponibilidadRs findDisponibilidad(Long id, Long usuarioId) {
		try {
			if(usuarioId ==null || usuarioId==0) {
				throw new InternalError("No se pudo identificar el usuario");	
			}
			if(id ==null || id==0) {
				throw new InternalError("No se pudo identificar la Funcion");	
			}
			
			
			DisponibilidadRs disponibilidadRs = DisponibilidadRs.builder().tickets(ticketRepositorio.findDisponibilidad(id,usuarioId)).build();
			return disponibilidadRs;
		}catch(Exception e) {

			e.printStackTrace();
			throw new InternalError("Problemas al intentar obtener la disponibilidad. "+e.getMessage(), e);
		}
	}
	
	
	@CacheEvict(cacheNames = {"allUserCache"}, allEntries = true)
	public void evictCache() {
	    System.out.println("Evict all cache entries...");
	}
}

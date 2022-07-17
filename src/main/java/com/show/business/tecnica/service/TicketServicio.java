package com.show.business.tecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.show.business.tecnica.dto.ClienteRq;
import com.show.business.tecnica.dto.Respuesta;
import com.show.business.tecnica.model.Ticket;
import com.show.business.tecnica.repository.TicketRepositorio;

@Service
public class TicketServicio {
	
	@Autowired
	private TicketRepositorio repositorio;

	public Respuesta asignar(Long id, ClienteRq cliente, Long usuarioId) {
		
		try {
			validar(cliente,usuarioId);
			
			Ticket ticket = repositorio.findById(id).get();
			
			validar(ticket,usuarioId);
			
			ticket.setDni(cliente.getDni());
			ticket.setMail(cliente.getMail());
			ticket.setNombreApellido(cliente.getNombreApellido());
			if(repositorio.save(ticket)!=null) {
				return Respuesta.builder().estado("OK").mensaje("El ticket "+id+" fue asignado correctamente.").build();
    		}else {
    			return Respuesta.builder().estado("ERROR").mensaje("Por algún motivo no se pudo asignar el ticket "+id+".").build();
    		}
		}catch(InternalError e) {
			e.printStackTrace();
			return Respuesta.builder().estado("ERROR").mensaje("Ocurrio un error al asignar el ticket "+id+"."+e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Respuesta.builder().estado("ERROR").mensaje("Ocurrio un error al asignar el ticket "+id+".").build();
		}
	}

	private void validar(Ticket ticket, Long usuarioId) {
		if(ticket==null) {
			throw new InternalError("El ticket no existe");
		}else if(ticket.getFuncion().getUsuario().getId()!=usuarioId) {
			throw new InternalError("El ticket no corresponde al usuario logeado");
		}else if(ticket.getDni()!=null) {
			throw new InternalError("El ticket ya esta asignado");
		}
	}

	private void validar(ClienteRq cliente, Long usuarioId) {
		if(usuarioId ==null || usuarioId==0) {
			throw new InternalError("No se pudo identificar el usuario");	
		}else if(cliente.getDni()==null || cliente.getDni().isBlank()) {
			throw new InternalError("El DNI del cliente es obligatorio");	
		}else if(cliente.getNombreApellido()==null || cliente.getNombreApellido().isBlank()) {
			throw new InternalError("El Nombre y apellido del cliente es obligatorio");	
		}
	}

}

package com.show.business.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.business.tecnica.Utils;
import com.show.business.tecnica.dto.ClienteRq;
import com.show.business.tecnica.dto.Respuesta;
import com.show.business.tecnica.service.TicketServicio;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ticket")
@Tag(name = "Ticket")
public class TicketController {
	@Autowired
    private TicketServicio ticketServicio;


	@PutMapping(path = "/{id}/asignar")
	public Respuesta getAll(@PathVariable Long id,@RequestBody ClienteRq cliente,HttpServletRequest request ) {
		Long usuarioId = Utils.getUsuarioId(request);
		return ticketServicio.asignar(id, cliente, usuarioId);
		
	}
	
}

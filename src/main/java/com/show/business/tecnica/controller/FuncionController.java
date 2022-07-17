package com.show.business.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.business.tecnica.Utils;
import com.show.business.tecnica.dto.DisponibilidadRs;
import com.show.business.tecnica.dto.FuncionRq;
import com.show.business.tecnica.model.Funcion;
import com.show.business.tecnica.service.FuncionServicio;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/funcion")
@Tag(name = "Funciones")
public class FuncionController {
	@Autowired
    private FuncionServicio funcionServicio;


	@GetMapping
	public Page<Funcion> getAll(@RequestBody FuncionRq funcion,Pageable pagina,HttpServletRequest request ) {
		Long usuarioId = Utils.getUsuarioId(request);
		return funcionServicio.findAllFuncion(funcion, usuarioId,pagina);
	}
	
	@GetMapping(path = "/{id}/disponibilidad")
	public DisponibilidadRs getDisponibilidad(@PathVariable Long id,HttpServletRequest request ) {
		Long usuarioId = Utils.getUsuarioId(request);
		return funcionServicio.findDisponibilidad(id,usuarioId);
	}
}

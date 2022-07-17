package com.show.business.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.business.tecnica.Utils;
import com.show.business.tecnica.dto.ShowRq;
import com.show.business.tecnica.model.Show;
import com.show.business.tecnica.service.ShowServicio;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/show")
@Tag(name = "Show")
public class ShowController {
	@Autowired
    private ShowServicio funcionServicio;


	@GetMapping
	public Page<Show> getAll(@RequestBody ShowRq funcion,Pageable pagina,HttpServletRequest request ) {
		Long usuarioId = Utils.getUsuarioId(request);
		return funcionServicio.findAllShow(funcion, usuarioId,pagina);
	}
	

}

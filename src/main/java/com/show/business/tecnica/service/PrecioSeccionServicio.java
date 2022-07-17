package com.show.business.tecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.show.business.tecnica.repository.PrecioSeccionRepositorio;

@Service
public class PrecioSeccionServicio {
	
	@Autowired
	private PrecioSeccionRepositorio repositorio;

}

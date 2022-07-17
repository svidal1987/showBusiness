package com.show.business.tecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.show.business.tecnica.repository.SalaRepositorio;

@Service
public class SalaServicio {
	
	@Autowired
	private SalaRepositorio repositorio;

}

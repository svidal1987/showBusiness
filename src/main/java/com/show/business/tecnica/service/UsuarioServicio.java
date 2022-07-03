package com.show.business.tecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.show.business.tecnica.model.Usuario;
import com.show.business.tecnica.repository.UsuarioRepositorio;

@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	public boolean validar(String username) {
		try {
			Usuario usuario = new Usuario();
			usuario.setUsuario(username);
			Example<Usuario> e = Example.of(usuario);
			return repositorio.count(e)>0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean validar(String username, String pwd) {
		try {
			Usuario usuario = new Usuario();
			usuario.setUsuario(username);
			usuario.setPassword(pwd);
			Example<Usuario> e = Example.of(usuario);
			return repositorio.count(e)>0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Usuario getUsuario(String username) {
		try {
			Usuario usuario = new Usuario();
			usuario.setUsuario(username);
			Example<Usuario> e = Example.of(usuario);
			return repositorio.findAll(e).get(0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

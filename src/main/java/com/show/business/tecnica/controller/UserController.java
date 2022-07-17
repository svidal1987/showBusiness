package com.show.business.tecnica.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.show.business.tecnica.JWTAuthorizationFilter;
import com.show.business.tecnica.dto.Respuesta;
import com.show.business.tecnica.dto.UserRs;
import com.show.business.tecnica.model.Usuario;
import com.show.business.tecnica.service.UsuarioServicio;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class UserController {
	

    @Autowired
    private UsuarioServicio usuarioServicio;
    	
	@PostMapping("login")
	@CrossOrigin(origins = "*")
	@Tag(name = "Autenticacion de Usuario/Portal")
	public UserRs login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

		UserRs user = new UserRs();
		try {
			if(usuarioServicio.validar(username, pwd)) {
				Usuario u = usuarioServicio.getUsuario(username);
				
				String token = getJWTToken(u);
				user.setEstado(Respuesta.OK);
				user.setMensaje("Usuario Valido!");
				user.setUser(username);
				user.setToken(token);
				
			}else {
				user.setEstado(Respuesta.ERROR);
				user.setMensaje("Usuario no Valido!");
			}
		}catch(Exception e) {
			e.printStackTrace();
			user.setEstado(Respuesta.ERROR);
			user.setMensaje("Ocurrio un problema al validar el usuario!");
		}
		return user;
		
	}
	
	private String getJWTToken(Usuario u) {
		String secretKey = JWTAuthorizationFilter.SECRET;
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(u.getRol().toString());
		u.setPassword("");
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(u.getUsuario())
				.claim("usuarioId", u.getId())
				.claim("usuarioNombre", u.getNombre())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (60000*60*24*60))) //2 meses
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}

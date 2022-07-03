package com.show.business.tecnica.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.show.business.tecnica.JWTAuthorizationFilter;
import com.show.business.tecnica.model.Usuario;
import com.show.business.tecnica.service.UsuarioServicio;
import com.show.business.tecnica.transferobject.Respuesta;
import com.show.business.tecnica.transferobject.UserRs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
public class LogController {
	

    @Autowired
    private UsuarioServicio usuarioServicio;
    

	
	@PostMapping("login")
	@CrossOrigin(origins = "*")
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
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(u.getUsuario())
				.claim("usuario", u.getUsuario())
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

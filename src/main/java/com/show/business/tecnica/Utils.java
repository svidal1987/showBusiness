package com.show.business.tecnica;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;

public class Utils {

	public static Long getUsuarioId(HttpServletRequest request) {
		Claims claims = JWTAuthorizationFilter.validateToken(request);
		
		return Long.valueOf(""+claims.get("usuarioId"));
	}
	
}

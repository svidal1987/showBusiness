package com.show.business.tecnica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserRs extends Respuesta {
	public UserRs() {
		super(null, null);
	}
	public UserRs(String estado, String mensaje) {
		super(estado, mensaje);
	}
	String user;
	String token;
}

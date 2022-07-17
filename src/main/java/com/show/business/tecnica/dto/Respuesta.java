package com.show.business.tecnica.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Respuesta {
	public static final String OK="OK";
	public static final String ERROR="ERROR";
	
	String estado;
	String mensaje;
}

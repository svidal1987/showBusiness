package com.show.business.tecnica.transferobject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Respuesta {
	public static final String OK="OK";
	public static final String ERROR="ERROR";
	
	
	
	String estado;
	String mensaje;
}

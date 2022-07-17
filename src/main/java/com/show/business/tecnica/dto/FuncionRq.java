package com.show.business.tecnica.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FuncionRq {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Date fechaDesde;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Date fechaHasta;
	Double precioDesde;
	Double precioHasta;
	Long idFuncion;
	Long idShow;
	Long idEstablecimiento;
	
	@Override
	public String toString() {
		return "FuncionRq [fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", precioDesde=" + precioDesde
				+ ", precioHasta=" + precioHasta + ", idFuncion=" + idFuncion + ", idShow=" + idShow
				+ ", idEstablecimiento=" + idEstablecimiento + "]";
	}
	
	
}

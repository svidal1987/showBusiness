package com.show.business.tecnica.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Funcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@NonNull
	Date fechaHora;
	@ManyToOne @NonNull
	Show show;
	@ManyToOne @NonNull
	Sala sala;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) @NonNull
	List<PrecioSeccion> precioSeccion;
	@ManyToOne()
	@JsonIgnore
	Usuario usuario;
}

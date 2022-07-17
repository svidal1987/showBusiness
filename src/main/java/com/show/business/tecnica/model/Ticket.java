package com.show.business.tecnica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@JsonIgnore
	String nombreApellido;

	@JsonIgnore
	String mail;

	@JsonIgnore
	String dni;
	@ManyToOne()

	@JsonIgnore
	Funcion funcion;
	@NonNull
	Integer butaca;
	@NonNull
	Double precio;
}

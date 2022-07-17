package com.show.business.tecnica.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Seccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String nombre;
	
	@ManyToOne
	@JsonIgnore
	private Sala sala;
	@NonNull
	@JsonIgnore
	private Integer butacaInicial;
	@NonNull
	private Integer butacaFinal;
}

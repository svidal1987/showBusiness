package com.show.business.tecnica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String usuario;
	@NonNull
	private String nombre;
	@NonNull
	private String password;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean activo;
	@NonNull
	private Rol rol;
}

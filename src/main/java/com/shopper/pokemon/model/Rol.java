package com.shopper.pokemon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Rol implements Serializable{
	
	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	
	@Column(unique=true)
	@NotEmpty(message = "No puede estar vacio")
	private String nombre;
	
	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}

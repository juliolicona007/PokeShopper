package com.shopper.pokemon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pokemones")
public class Pokemon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pokemon")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPokemon;

	@NotNull(message = "no puede estar vacio")
	private Integer numeroPokedex;
	
	@NotEmpty(message = "no puede estar vacio")
	private String nombrePokedex;
	
	private String imagen;
	
	private String alias;
	
	private Boolean shiny;
	
	private String nature;
	
	private Long idUsuario;

	public Long getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(Long idPokemon) {
		this.idPokemon = idPokemon;
	}

	public Integer getNumeroPokedex() {
		return numeroPokedex;
	}

	public void setNumeroPokedex(Integer numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}

	public String getNombrePokedex() {
		return nombrePokedex;
	}

	public void setNombrePokedex(String nombrePokedex) {
		this.nombrePokedex = nombrePokedex;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Boolean getShiny() {
		return shiny;
	}

	public void setShiny(Boolean shiny) {
		this.shiny = shiny;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
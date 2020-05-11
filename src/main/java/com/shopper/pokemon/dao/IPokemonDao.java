package com.shopper.pokemon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopper.pokemon.model.Pokemon;

public interface IPokemonDao extends JpaRepository<Pokemon, Long> {

	List<Pokemon> findByIdUsuario(Long idUsuario);
	
}

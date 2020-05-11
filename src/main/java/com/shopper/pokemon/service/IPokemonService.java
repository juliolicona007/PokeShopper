package com.shopper.pokemon.service;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.shopper.pokemon.model.Pokemon;

public interface IPokemonService {

	List<Pokemon> getAllPokemones() throws IOException, ParseException;
	
	JSONObject getDetallesPokemon(Integer numeroPokedex) throws IOException, ParseException;
	
	List<Pokemon> getPokemonByUsuario(Long idUsuario);
	
	Pokemon getPokemonById(Long idPokemon);
	
	Pokemon savePokemon(Pokemon pokemon);
	
	void deletePokemon(Long idPokemon);
	
	void deleteAllPokemones(List<Pokemon> pokemones);
	
}

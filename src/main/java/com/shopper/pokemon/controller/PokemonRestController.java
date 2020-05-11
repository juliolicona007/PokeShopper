package com.shopper.pokemon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.shopper.pokemon.model.Pokemon;
import com.shopper.pokemon.service.IPokemonService;
import com.shopper.pokemon.utils.CommonsUtils;

@RestController
@RequestMapping("/pokemon")
public class PokemonRestController {

	@Autowired
	private IPokemonService pokemonService;
	
	@GetMapping("/listAll")
	public List<Pokemon> getAllPokemones(){
		List<Pokemon> listaPokemones = new ArrayList<>();
		try{
			listaPokemones = pokemonService.getAllPokemones();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listaPokemones;
	}
	
	@GetMapping("/pokedex/{numeroPokedex}")
	public ResponseEntity<?> getPokemonDetails(@PathVariable Integer numeroPokedex) {
		Map<String, Object> response = new HashMap<>();
		JSONObject pokemon = null;
		try {
			pokemon = pokemonService.getDetallesPokemon(numeroPokedex);
		} catch(Exception e) {
			return CommonsUtils.generaError("Error al realizar la consulta a la API Pokemon", response, e);
		}
		return CommonsUtils.generaRespuestaOk("Los", "detallesPokemon", pokemon, "consultado", response);
	}
	
	@GetMapping("/entrenador/{idEntrenador}")
	public List<Pokemon> getPokemonesByEntrenador(@PathVariable Long idEntrenador){
		return pokemonService.getPokemonByUsuario(idEntrenador);
	}
	
	@PostMapping("/add")
	@ResponseStatus()
	public ResponseEntity<?> addPokemon(@Valid @RequestBody Pokemon pokemon, BindingResult result) {
		Pokemon pokemonNuevo = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			return CommonsUtils.generaErrorValidaciones(result, response);
		}
		try {
			pokemon.setIdPokemon(null);
			pokemonNuevo = pokemonService.savePokemon(pokemon);
		} catch(DataAccessException e) {
			return CommonsUtils.generaErrorDataAccess("Error al realizar el insert a la base de datos", response, e);
		}
		return CommonsUtils.generaRespuestaCreacion("El", "pokemon", pokemonNuevo, "agregado", response);
	}
	
	@PostMapping("/updateAll/{idEntrenador}")
	@ResponseStatus()
	public ResponseEntity<?> updatePokemones(@Valid @RequestBody List<Pokemon> pokemones, BindingResult result, @PathVariable Long idEntrenador) {
		List<Pokemon> pokemonesActuales = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			return CommonsUtils.generaErrorValidaciones(result, response);
		}
		try {
			pokemonesActuales = pokemonService.getPokemonByUsuario(idEntrenador);
			pokemonService.deleteAllPokemones(pokemonesActuales);
		} catch(DataAccessException e) {
			return CommonsUtils.generaErrorDataAccess("Error al realizar la eliminacion a la base de datos", response, e);
		}
		try {
			for(Pokemon pokemon : pokemones) {
				pokemon.setIdPokemon(null);
				pokemon.setIdUsuario(idEntrenador);
				pokemonService.savePokemon(pokemon);
			}
		} catch(DataAccessException e) {
			return CommonsUtils.generaErrorDataAccess("Error al realizar los insert a la base de datos", response, e);
		}
		response.put("mensaje", " La lista ha sido actualizada con exito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	@ResponseStatus()
	public ResponseEntity<?> updatePokemon(@Valid @RequestBody Pokemon pokemon, BindingResult result) {
		Pokemon pokemonActual = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			return CommonsUtils.generaErrorValidaciones(result, response);
		}
		try {
			pokemonActual = pokemonService.getPokemonById(pokemon.getIdPokemon());
		} catch(DataAccessException e) {
			return CommonsUtils.generaErrorDataAccess("Error al realizar la consulta a la base de datos", response, e);
		}
		if(pokemonActual == null) {
			return CommonsUtils.generaErrorNoEncontrado("El", "pokemon", String.valueOf(pokemon.getIdPokemon()), response);
		}
		pokemonActual.setAlias(pokemon.getAlias());
		pokemonActual.setImagen(pokemon.getImagen());
		pokemonActual.setNature(pokemon.getNature());
		pokemonActual.setNombrePokedex(pokemon.getNombrePokedex());
		pokemonActual.setNumeroPokedex(pokemon.getNumeroPokedex());
		pokemonActual.setShiny(pokemon.getShiny());
		
		Pokemon pokemonActualizado = null;
		try {
			pokemonActualizado = pokemonService.savePokemon(pokemonActual);
		} catch(DataAccessException e) {
			return CommonsUtils.generaErrorDataAccess("Error al realizar la actualizacion a la base de datos", response, e);
		}
		return CommonsUtils.generaRespuestaOk("El", "pokemon", pokemonActualizado, "actualizado", response);
	}
	
	@DeleteMapping("/{idPokemon}")
	@ResponseStatus()
	public ResponseEntity<?> deletePokemon(@PathVariable Long idPokemon) {
		Pokemon pokemonActual = null;
		Map<String, Object> response = new HashMap<>();
		try {
			pokemonActual = pokemonService.getPokemonById(idPokemon);
		} catch(DataAccessException e) {
			return CommonsUtils.generaErrorDataAccess("Error al realizar la consulta a la base de datos", response, e);
		}
		if(pokemonActual == null) {
			return CommonsUtils.generaErrorNoEncontrado("El", "pokemon", String.valueOf(idPokemon), response);
		}
		try {
			pokemonService.deletePokemon(idPokemon);
		} catch(DataAccessException e) {
			return CommonsUtils.generaErrorDataAccess("Error al realizar la eliminacion a la base de datos", response, e);
		}
		return CommonsUtils.generaRespuestaOk("El", "pokemon", pokemonActual, "eliminado", response);
	}
	
}

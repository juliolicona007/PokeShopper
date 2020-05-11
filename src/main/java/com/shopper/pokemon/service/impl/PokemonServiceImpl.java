package com.shopper.pokemon.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopper.pokemon.dao.IPokemonDao;
import com.shopper.pokemon.model.Pokemon;
import com.shopper.pokemon.service.IPokemonService;

@Service
public class PokemonServiceImpl implements IPokemonService {

	@Autowired
	private IPokemonDao pokemonDao;
	
	@Override
	public List<Pokemon> getPokemonByUsuario(Long idUsuario) {
		return pokemonDao.findByIdUsuario(idUsuario);
	}

	@Override
	public Pokemon getPokemonById(Long idPokemon) {
		return pokemonDao.findById(idPokemon).orElse(null);
	}

	@Override
	public Pokemon savePokemon(Pokemon pokemon) {
		return pokemonDao.save(pokemon);
	}

	@Override
	public void deletePokemon(Long idPokemon) {
		pokemonDao.deleteById(idPokemon);
	}

	@Override
	public void deleteAllPokemones(List<Pokemon> pokemones) {
		pokemonDao.deleteAll(pokemones);
	}

	@Override
	public List<Pokemon> getAllPokemones() throws IOException, ParseException {
		List<Pokemon> listaPokemones = new ArrayList<>();
		String pokeText = getApiPokemones("https://pokeapi.co/api/v2/pokemon/?limit=1000");
		if(pokeText != null) {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(pokeText);
			JSONArray jsonResults = (JSONArray)jsonObj.get("results");
			for(int i=0; i < jsonResults.size(); i++) {
				JSONObject pokeInfo = (JSONObject) jsonResults.get(i);
				Pokemon pokemon = new Pokemon();
				pokemon.setNombrePokedex((String)pokeInfo.get("name"));
				String urlPokemon = (String)pokeInfo.get("url");
				pokemon.setNumeroPokedex(Integer.valueOf(urlPokemon.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")));
				listaPokemones.add(pokemon);
			}
		}
		return listaPokemones;
	}

	@Override
	public JSONObject getDetallesPokemon(Integer numeroPokedex) throws IOException, ParseException {
		String pokeText = getApiPokemones("https://pokeapi.co/api/v2/pokemon/" + numeroPokedex);
		if(pokeText != null) {
			JSONParser parser = new JSONParser();
			return (JSONObject)parser.parse(pokeText);
		}
		return null;
	}

	private String getApiPokemones(String urlConsultar) throws IOException {
		URL url = new URL(urlConsultar);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
		int responseCode = conn.getResponseCode();
		if(responseCode == 200) {
			InputStream stream = conn.getErrorStream();
			if (stream == null) {
		        stream = conn.getInputStream();
		        StringBuilder sb = new StringBuilder();
		        Scanner sc = new Scanner(stream);
		        while(sc.hasNext()) {
		        	sb.append(sc.nextLine());
		        }
		        sc.close();
		        return sb.toString();
			}
		}
		return null;
	}
	
}

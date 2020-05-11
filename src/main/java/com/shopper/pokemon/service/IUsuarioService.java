package com.shopper.pokemon.service;

import com.shopper.pokemon.model.Usuario;

public interface IUsuarioService {

	Usuario getUsuarioByUsername(String username);
	
}

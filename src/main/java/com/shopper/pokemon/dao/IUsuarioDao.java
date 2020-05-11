package com.shopper.pokemon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopper.pokemon.model.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
}

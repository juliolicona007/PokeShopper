package com.shopper.pokemon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopper.pokemon.dao.IUsuarioDao;
import com.shopper.pokemon.model.Usuario;
import com.shopper.pokemon.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public Usuario getUsuarioByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

}

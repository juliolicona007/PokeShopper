package com.shopper.pokemon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shopper.pokemon.dao.IUsuarioDao;
import com.shopper.pokemon.model.Usuario;

@Service
public class AuthServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);

		if (usuario == null) {
			String msg = "Error en el login: no existe el usuario '" + username + "' en el sistema!";
			throw new UsernameNotFoundException(msg);
		}

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());
		return new User(username, passwordEncoder().encode(usuario.getPassword()), usuario.getEnabled(), true, true, true, authorities);
	}
	
}

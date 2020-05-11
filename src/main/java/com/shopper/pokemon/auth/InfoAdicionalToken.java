package com.shopper.pokemon.auth;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import com.shopper.pokemon.model.Usuario;
import com.shopper.pokemon.service.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioService.getUsuarioByUsername(authentication.getName());
		Map<String, Object> mapInfo = new HashMap<>();
		mapInfo.put("idUsuario", usuario.getIdUsuario());
		mapInfo.put("nombre", usuario.getNombre());
		mapInfo.put("paterno", usuario.getPaterno());
		mapInfo.put("email", usuario.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(mapInfo);
		return accessToken;
	}

}

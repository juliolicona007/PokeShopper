package com.shopper.pokemon.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class CommonsUtils {

	public static ResponseEntity<?> generaErrorValidaciones(BindingResult result, Map<String, Object> response) {
		List<String> errores = result.getFieldErrors()
			.stream()
			.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
			.collect(Collectors.toList());
		response.put("validaciones", errores);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<?> generaErrorDataAccess(String mensaje, Map<String, Object> response, DataAccessException e) {
		response.put("mensaje", mensaje);
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<?> generaRespuestaCreacion(String prefijo, String nombreEntidad, Object entidad, String accion, Map<String, Object> response){
		response.put("mensaje", prefijo.concat(" ").concat(nombreEntidad).concat(" ha sido ").concat(accion).concat(" con exito!"));
		response.put(nombreEntidad, entidad);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	public static ResponseEntity<?> generaRespuestaOk(String prefijo, String nombreEntidad, Object entidad, String accion, Map<String, Object> response){
		response.put("mensaje", prefijo.concat(" ").concat(nombreEntidad).concat(" ha sido ").concat(accion).concat(" con exito!"));
		response.put(nombreEntidad, entidad);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	public static ResponseEntity<?> generaErrorNoEncontrado(String prefijo, String entidad, String id, Map<String, Object> response){
		response.put("mensaje",  prefijo.concat(" ").concat(entidad).concat(" con ID: ".concat(id).concat(" no existe en la base de datos!")));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}
	
	public static ResponseEntity<?> generaError(String mensaje, Map<String, Object> response, Exception e){
		response.put("mensaje", mensaje);
		String error = "";
		if(e.getMessage() != null) {
			error.concat(e.getMessage());
		}
		if(e.getCause() != null && e.getCause().getMessage() != null) {
			error.concat(": ").concat(e.getCause().getMessage());
		}
		response.put("error", error);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static String getExtension(String fileName) {
		int indiceExtension = fileName.lastIndexOf(".");
		return fileName.substring(indiceExtension);
	}
	
}

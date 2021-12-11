package com.crudcine.crudcine.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class usuariosDto {

	@NotBlank
	private String usuario;
	@NotBlank
	private String contraseña;
	@NotBlank
	private String correo;
	@Min(0)
	private Integer telefono;
	
	public usuariosDto() {
	}

	public usuariosDto( String usuario,  String contraseña, String correo, Integer telefono) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	
	
	

	
		
	
	
	
}

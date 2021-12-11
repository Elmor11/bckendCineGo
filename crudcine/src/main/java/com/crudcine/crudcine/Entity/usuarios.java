package com.crudcine.crudcine.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "usuarios")
public class usuarios {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	
	private int id;
	private String usuario;
	private String contraseña;
	private String correo;
	private int telefono;
	
	public usuarios() {
	}

	public usuarios(String usuario, String contraseña, String correo, int telefono) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	

	
	
	
}

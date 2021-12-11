package com.crudcine.crudcine.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.crudcine.crudcine.Entity.usuarios;
import com.crudcine.crudcine.Service.usuariosService;
import com.crudcine.crudcine.dto.Mensaje;
import com.crudcine.crudcine.dto.usuariosDto;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class usuariosController {
	
	@Autowired
	usuariosService UsuariosService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<usuarios>> list() {
		List<usuarios> list = UsuariosService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<usuarios> getById(@PathVariable("id") int id) {
		if(!UsuariosService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		usuarios usuarios = UsuariosService.getOne(id).get();
		return new ResponseEntity(usuarios, HttpStatus.OK);	
	}
	
	@GetMapping("/detailUsuario/{usuario}")
	public ResponseEntity<usuarios> getByPrograma(@PathVariable("usuario") String usuarios) {
		if(!UsuariosService.existsByPrograma(usuarios))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		usuarios Usuarios = UsuariosService.getByPrograma(usuarios).get();
		return new ResponseEntity(Usuarios, HttpStatus.OK);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody usuariosDto UsuariosDto) {
		if(StringUtils.isBlank(UsuariosDto.getUsuario()))
				return new ResponseEntity(new Mensaje ("El usuario es obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(UsuariosDto.getContraseña()))
			return new ResponseEntity(new Mensaje ("La contraseña es obligatoria"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(UsuariosDto.getCorreo()))
			return new ResponseEntity(new Mensaje ("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
		if ( UsuariosDto.getTelefono()==null || UsuariosDto.getTelefono()<0)
			return new ResponseEntity(new Mensaje ("Número de teléfono no válido"), HttpStatus.BAD_REQUEST);
//		if (cadiposService.existsByPrograma(CadiposDto.getPrograma()))
//			return new ResponseEntity(new Mensaje ("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		usuarios Usuarios = new usuarios(UsuariosDto.getUsuario(), UsuariosDto.getContraseña(), UsuariosDto.getCorreo(), UsuariosDto.getTelefono());
		UsuariosService.save(Usuarios);
		return new ResponseEntity(new Mensaje ("Añadido"), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody usuariosDto UsuariosDto) {
		if(!UsuariosService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
//		if (cadiposService.existsByPrograma(CadiposDto.getPrograma()) && cadiposService.getByPrograma(CadiposDto.getPrograma()).get().getId() != id)
//			return new ResponseEntity(new Mensaje ("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(UsuariosDto.getUsuario()))
				return new ResponseEntity(new Mensaje ("El usuario es obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(UsuariosDto.getContraseña()))
			return new ResponseEntity(new Mensaje ("La contraseña es obligatoria"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(UsuariosDto.getCorreo()))
			return new ResponseEntity(new Mensaje ("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
		if (UsuariosDto==null || UsuariosDto.getTelefono()<0)
			return new ResponseEntity(new Mensaje ("Número no válido"), HttpStatus.BAD_REQUEST);
//		if (cadiposService.existsByPrograma(CadiposDto.getPrograma()))
//			return new ResponseEntity(new Mensaje ("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		
		usuarios Usuarios = UsuariosService.getOne(id).get();
		Usuarios.setUsuario(UsuariosDto.getUsuario());
		Usuarios.setContraseña(UsuariosDto.getContraseña());
		Usuarios.setCorreo(UsuariosDto.getCorreo());
		Usuarios.setTelefono(UsuariosDto.getTelefono());
		UsuariosService.save(Usuarios);
		return new ResponseEntity(new Mensaje ("Actualizado"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!UsuariosService.existsById(id))
			return new ResponseEntity(new Mensaje ("No existe"), HttpStatus.NOT_FOUND);
		UsuariosService.delete(id);
		return new ResponseEntity(new Mensaje ("Eliminado"), HttpStatus.OK);
	}

}

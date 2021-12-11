package com.crudcine.crudcine.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crudcine.crudcine.Entity.usuarios;
import com.crudcine.crudcine.Repository.usuariosRepository;

@Service
@Transactional
public class usuariosService {
	@Autowired
	usuariosRepository usuariosRepository;
	
	public List<usuarios> list() {
		return usuariosRepository.findAll();
	}
	
	public Optional<usuarios> getOne(int id) {
		return usuariosRepository.findById(id);
	}
	
	public Optional<usuarios> getByPrograma(String usuario) {
		return usuariosRepository.findByUsuario(usuario);
	}
	
	public void save(usuarios cadipos) {
		usuariosRepository.save(cadipos);
	}
	
	public void delete(int id) {
		usuariosRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return usuariosRepository.existsById(id);
	}
	
	public boolean existsByPrograma(String usuario) {
		return usuariosRepository.existsByUsuario(usuario);
	}
	
	
}

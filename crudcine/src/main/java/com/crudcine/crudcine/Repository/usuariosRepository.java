package com.crudcine.crudcine.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crudcine.crudcine.Entity.usuarios;

@Repository
public interface usuariosRepository extends JpaRepository<usuarios, Integer> {
	Optional<usuarios> findByUsuario(String usuario);
	boolean existsByUsuario(String usuario);
}


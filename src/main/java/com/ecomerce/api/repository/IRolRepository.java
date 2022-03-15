package com.ecomerce.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.api.model.Rol;

public interface IRolRepository extends JpaRepository<Rol, Long>{
	
	public Optional<Rol> findByNombre(String nombre);
}

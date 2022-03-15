package com.ecomerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.api.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

}

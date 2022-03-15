package com.ecomerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.api.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

}


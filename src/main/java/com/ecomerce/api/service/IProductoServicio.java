package com.ecomerce.api.service;

import java.util.List;

import com.ecomerce.api.dto.ProductoDTO;

public interface IProductoServicio {
	
	public ProductoDTO crearProducto(long categorisId, ProductoDTO productoDTO);
	public List<ProductoDTO> obtenerTodosLosProductos();
	public ProductoDTO obtenerProducto(Long id);
	public ProductoDTO actualizarProducto(ProductoDTO productoDTO, Long id);
	public void elimiarProducto(Long id);
}

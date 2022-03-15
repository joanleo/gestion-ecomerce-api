package com.ecomerce.api.service;

import java.util.List;

import com.ecomerce.api.dto.CategoriaDTO;

public interface ICategoriaServicio {
	
	public CategoriaDTO crearCategoria(CategoriaDTO categoriaDto);
	public List<CategoriaDTO> obtenerCategorias();
	public CategoriaDTO obtenerCategoria(long id);
	public CategoriaDTO actualizarCategoria(long id, CategoriaDTO categoriaDto);
	public void eliminarCategoria(long id);

}

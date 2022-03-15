package com.ecomerce.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.api.dto.CategoriaDTO;
import com.ecomerce.api.exceptions.ResourceNotFoundException;
import com.ecomerce.api.model.Categoria;
import com.ecomerce.api.repository.ICategoriaRepository;

@Service
public class CategoriaServicioImpl implements ICategoriaServicio{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ICategoriaRepository categoriaRepo;
	
	@Override
	public CategoriaDTO crearCategoria(CategoriaDTO categoriaDto) {
		Categoria categoria = mapearModelo(categoriaDto);
		Categoria nuevaCategoria = categoriaRepo.save(categoria);

		CategoriaDTO categotiaRespuesta = mapearDTO(nuevaCategoria);

		return categotiaRespuesta;
	}
	
	@Override
	public List<CategoriaDTO> obtenerCategorias() {
		
		List<Categoria> categorias = categoriaRepo.findAll();
		
		return categorias.stream().map(producto -> mapearDTO(producto)).collect(Collectors.toList());
	}
	
	@Override
	public CategoriaDTO obtenerCategoria(long id) {
		Categoria categoria = categoriaRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", id));
		
		return mapearDTO(categoria);
	}
	
	
	@Override
	public CategoriaDTO actualizarCategoria(long id, CategoriaDTO categoriaDto) {
		Categoria categoria = categoriaRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", id));
		
		categoria.setNombre(categoriaDto.getNombre());
		
		return mapearDTO(categoria);
			
	}
	
	
	@Override
	public void eliminarCategoria(long id) {
		Categoria categoria = categoriaRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", id));
		
		categoriaRepo.delete(categoria);
				
	}
	
	// Convierte modelo a DTO
	private CategoriaDTO mapearDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
		return categoriaDTO;
	}

	// Convierte DTO a modelo
	private Categoria mapearModelo(CategoriaDTO categoriaDTO) {
		Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
		return categoria;
	}

	

	

	
	

}

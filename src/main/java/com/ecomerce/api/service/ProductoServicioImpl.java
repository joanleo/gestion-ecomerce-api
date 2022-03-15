package com.ecomerce.api.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.api.dto.ProductoDTO;
import com.ecomerce.api.exceptions.ResourceNotFoundException;
import com.ecomerce.api.model.Categoria;
import com.ecomerce.api.model.Producto;
import com.ecomerce.api.repository.ICategoriaRepository;
import com.ecomerce.api.repository.IProductoRepository;

@Service
public class ProductoServicioImpl implements IProductoServicio {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IProductoRepository productoRepo;
	
	@Autowired
	private ICategoriaRepository categoriaRepo;

	@Override
	public ProductoDTO crearProducto(long categoriaId, ProductoDTO productoDTO) {

		Producto producto = mapearModelo(productoDTO);
		Categoria categoria = categoriaRepo.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", categoriaId));
		producto.setCategoria(categoria);
		Producto nuevoProducto = productoRepo.save(producto);

		ProductoDTO productoRespuesta = mapearDTO(nuevoProducto);

		return productoRespuesta;
	}

	@Override
	public List<ProductoDTO> obtenerTodosLosProductos() {

		List<Producto> productos = productoRepo.findAll();
		return productos.stream().map(producto -> mapearDTO(producto)).collect(Collectors.toList());
	}

	@Override
	public ProductoDTO obtenerProducto(Long id) {

		Producto producto = productoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));

		return mapearDTO(producto);
	}
	
	@Override
	public ProductoDTO actualizarProducto(ProductoDTO productoDTO, Long id) {

		Producto producto = productoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
		
		producto.setNombre(productoDTO.getNombre());
		
		Producto productoActualizado = productoRepo.save(producto);
		
		return mapearDTO(productoActualizado);
	}
	
	@Override
	public void elimiarProducto(Long id) {

		Producto producto = productoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
		
		productoRepo.delete(producto);

	}

	// Convierte modelo a DTO
	private ProductoDTO mapearDTO(Producto producto) {
		ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
		return productoDTO;
	}

	// Convierte DTO a modelo
	private Producto mapearModelo(ProductoDTO productoDTO) {
		Producto producto = modelMapper.map(productoDTO, Producto.class);
		return producto;
	}

}

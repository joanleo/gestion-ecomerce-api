package com.ecomerce.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.api.dto.ProductoDTO;
import com.ecomerce.api.service.IProductoServicio;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

	@Autowired
	private IProductoServicio productoServicio;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/{idCategoria}")
	public ResponseEntity<ProductoDTO> guardarProducto(@PathVariable(value = "idCategoria") long idCategoria,
			@Valid @RequestBody ProductoDTO productoDTO) {
		return new ResponseEntity<ProductoDTO>(productoServicio.crearProducto(idCategoria, productoDTO),
				HttpStatus.CREATED);

	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping
	public List<ProductoDTO> listarProductos() {
		return productoServicio.obtenerTodosLosProductos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(productoServicio.obtenerProducto(id));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<ProductoDTO> actualizarProducto(@Valid @RequestBody ProductoDTO productoDTO,
			@PathVariable(name = "id") long id) {

		ProductoDTO productoRespuesta = productoServicio.actualizarProducto(productoDTO, id);

		return new ResponseEntity<>(productoRespuesta, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> eliminarProducto(@PathVariable(name = "id") long id) {
		productoServicio.elimiarProducto(id);

		return new ResponseEntity<>("Producto eliminado con exito", HttpStatus.OK);
	}
}

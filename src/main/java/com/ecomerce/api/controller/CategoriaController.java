package com.ecomerce.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.api.dto.CategoriaDTO;
import com.ecomerce.api.service.ICategoriaServicio;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaServicio categoriaServicio;
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> guardarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {

		return new ResponseEntity<CategoriaDTO>(categoriaServicio.crearCategoria(categoriaDTO), HttpStatus.CREATED);

	}
	
	@GetMapping
	public List<CategoriaDTO> listarCategorias(){
		return categoriaServicio.obtenerCategorias();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> obtenerCategoria(@PathVariable(value="id") long id){
		
		return new ResponseEntity<>(categoriaServicio.obtenerCategoria(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> actualizarCategoria(@Valid @PathVariable(value="id") long id, @RequestBody CategoriaDTO categotiaDTO){
		
		return new ResponseEntity<>(categoriaServicio.actualizarCategoria(id, categotiaDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarCategoria(@PathVariable(value="id") long id){
		
		return new ResponseEntity<>("Categoria eliminada Exitosamente", HttpStatus.OK);	
	}
}

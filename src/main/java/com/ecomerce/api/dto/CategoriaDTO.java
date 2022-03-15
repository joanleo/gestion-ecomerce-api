package com.ecomerce.api.dto;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ecomerce.api.model.Producto;

public class CategoriaDTO {

	private long id;
	
	@NotEmpty
	@Size(min = 3, message = "El nombre de la categoria debe tener almenos 3 caracteres")
	private String nombre;

	private Set<Producto> productos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public CategoriaDTO() {
		super();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

package com.ecomerce.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductoDTO {

	private long id;
	
	@NotEmpty(message = "El nombre no debe estar vacio")
	@Size(min = 3, message = "El nombre del producto debe tener almenos 3 caracteres")
	private String nombre;
	
	private long idCategoria;

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public ProductoDTO(long id, String nombre, long idCategoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idCategoria = idCategoria;
	}

	public ProductoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

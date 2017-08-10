package com.bookStore.model;

/**
 * @author T15263
 *
 */
public class Libro {
	
	Integer id;
	String titulo;
	Integer cantidad;
	double precio;
	String linkImagen;
	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * @return
	 */
	public String getLinkImagen() {
		return linkImagen;
	}
	/**
	 * @param linkImagen
	 */
	public void setLinkImagen(String linkImagen) {
		this.linkImagen = linkImagen;
	}
	
}

package com.bookStore.model;

import javax.faces.event.ValueChangeEvent;

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
	int cantidadAAgregar;
	double precioTotal;
	boolean agotado;

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

	/**
	 * @return
	 */
	public int getCantidadAAgregar() {
		return cantidadAAgregar;
	}

	/**
	 * @param cantidadAAgregar
	 */
	public void setCantidadAAgregar(int cantidadAAgregar) {
		this.cantidadAAgregar = cantidadAAgregar;
	}

	/**
	 * @param event
	 */
	public void setCantidadAAgregar(ValueChangeEvent event) {
		this.cantidadAAgregar = (Integer) event.getNewValue();
	}

	/**
	 * @return
	 */
	public double getPrecioTotal() {
		this.precioTotal = this.cantidadAAgregar * this.precio;
		return precioTotal;
	}

	/**
	 * @param precioTotal
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return
	 */
	public boolean isAgotado() {
		this.agotado = this.cantidad > 0 ? false : true;
		return agotado;
	}

	/**
	 * @param agotado
	 */
	public void setAgotado(boolean agotado) {
		this.agotado = agotado;
	}
	
	
}

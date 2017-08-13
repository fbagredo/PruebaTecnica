package com.bookStore.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.exception.JDBCConnectionException;

import com.bookStore.controller.ConsultaLibro;
import com.bookStore.dao.IDao;
import com.bookStore.dao.impl.LibrosDao;
import com.bookStore.exceptions.ConsultaSinDatosException;
import com.bookStore.model.Libro;

@ManagedBean
@SessionScoped
public class ConsultaLibros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -632206580760356845L;

	IDao librosDao = new LibrosDao();

	private List<Libro> libros;

	private List<Libro> librosSeleccionados;

	private ConsultaLibro consultaLibro;

	private String message;

	private double precioTotalCarrito;

	@PostConstruct
	public void init() {
		try {
			consultaLibro = new ConsultaLibro(librosDao);
			libros = consultaLibro.consultarLibro();
			librosSeleccionados = new ArrayList<Libro>();
		} catch (ConsultaSinDatosException e) {
			message = "No se han parametrizado libros: " + e.getMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
			e.printStackTrace();
		} catch (JDBCConnectionException e) {
			message = "No es posible conectarse a la base de datos en la nube: " + e.getMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
			e.printStackTrace();
		}
	}

	/**
	 * @param libro
	 */
	public void eliminar(Libro libro) {
		this.librosSeleccionados.remove(libro);
		this.libros.get(this.libros.indexOf(libro)).setCantidadAAgregar(0);
	}
	
	/**
	 * 
	 */
	public void actualizarLibro(){
		consultaLibro.actualizarLibro(this.libros);
	}

	/**
	 * @return
	 */
	public List<Libro> getLibros() {
		return libros;
	}

	/**
	 * @param libros
	 */
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	/**
	 * @return
	 */
	public ConsultaLibro getConsultaLibro() {
		return consultaLibro;
	}

	/**
	 * @param consultaLibro
	 */
	public void setConsultaLibro(ConsultaLibro consultaLibro) {
		this.consultaLibro = consultaLibro;
	}

	/**
	 * @return
	 */
	public List<Libro> getLibrosSeleccionados() {
		for (Libro l : this.libros) {
			if (l.getCantidadAAgregar() > 0) {
				this.librosSeleccionados.add(l);
			}
		}
		return librosSeleccionados;
	}

	/**
	 * @param librosSeleccionados
	 */
	public void setLibrosSeleccionados(List<Libro> librosSeleccionados) {
		this.librosSeleccionados = librosSeleccionados;
	}

	/**
	 * @return
	 */
	public double getPrecioTotalCarrito() {
		for (Libro l : this.librosSeleccionados) {
			this.precioTotalCarrito += l.getPrecioTotal();
		}
		return this.precioTotalCarrito;
	}

	/**
	 * @param precioTotalCarrito
	 */
	public void setPrecioTotalCarrito(double precioTotalCarrito) {
		this.precioTotalCarrito = precioTotalCarrito;
	}

}
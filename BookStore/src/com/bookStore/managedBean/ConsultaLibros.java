package com.bookStore.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

	private ConsultaLibro consultaLibro;

	@PostConstruct
	public void init() {
		try {
			consultaLibro = new ConsultaLibro(librosDao);
			libros = consultaLibro.consultarLibro();
		} catch (ConsultaSinDatosException e) {
			e.printStackTrace();
		}
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public ConsultaLibro getConsultaLibro() {
		return consultaLibro;
	}

	public void setConsultaLibro(ConsultaLibro consultaLibro) {
		this.consultaLibro = consultaLibro;
	}

}
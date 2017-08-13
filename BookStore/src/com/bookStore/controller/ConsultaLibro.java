package com.bookStore.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.exception.JDBCConnectionException;

import com.bookStore.dao.IDao;
import com.bookStore.exceptions.ConsultaSinDatosException;
import com.bookStore.model.Libro;


@ManagedBean(name = "consultaLibro")
@SessionScoped
public class ConsultaLibro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7059082168770524558L;
	private IDao dao;
	
	/**
	 * @param dao
	 */
	public ConsultaLibro(IDao dao) {
		super();
		this.dao = dao;
	}

	/**
	 * @return
	 * @throws ConsultaSinDatosException
	 * @throws JDBCConnectionException
	 */
	public List<Libro> consultarLibro() throws ConsultaSinDatosException, JDBCConnectionException{
		
		List<Libro> libro = dao.consultarLibro();
		
		if (libro.size() < 1){
			throw new ConsultaSinDatosException();
		}
		
		return libro;
		
	}
	
	/**
	 * @param libro
	 * @throws JDBCConnectionException
	 */
	public void actualizarLibro(List<Libro> libros) throws JDBCConnectionException{
		for (Libro l : libros){
			dao.actualizar(l);
		}
	}

}

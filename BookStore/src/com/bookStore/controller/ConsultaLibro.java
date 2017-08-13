package com.bookStore.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	
	public ConsultaLibro(IDao dao) {
		super();
		this.dao = dao;
	}

	public List<Libro> consultarLibro() throws ConsultaSinDatosException{
		
		List<Libro> libro = dao.consultarLibro();
		
		if (libro.size() < 1){
			throw new ConsultaSinDatosException();
		}
		
		return libro;
		
	}

}

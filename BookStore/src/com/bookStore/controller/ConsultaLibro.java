package com.bookStore.controller;

import java.util.List;

import com.bookStore.dao.IDao;
import com.bookStore.model.Libro;

public class ConsultaLibro {
	
	private IDao dao;
	
	public ConsultaLibro(IDao dao) {
		super();
		this.dao = dao;
	}

	public List<Libro> consultarLibro(){
		
		return dao.consultarLibro();
		
	}

}

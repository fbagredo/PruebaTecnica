package com.bookStore.managedBean;

import javax.faces.bean.ManagedBean;

import com.bookStore.controller.ConsultaLibro;
import com.bookStore.dao.IDao;
import com.bookStore.dao.impl.LibrosDao;

@ManagedBean
public class ConsultaLibros {

    String titulo;
    ConsultaLibro cl;
    IDao librosDao = new LibrosDao();
    

    public String getTitulo() {
    	cl = new ConsultaLibro(librosDao);
    	titulo = cl.consultarLibro().get(1).getTitulo();
    	return titulo;
    }
}
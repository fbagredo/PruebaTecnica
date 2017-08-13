package com.bookStore.dao;

import java.util.List;

import org.hibernate.exception.JDBCConnectionException;

import com.bookStore.model.Libro;

public interface IDao {
	/**
	 * @return
	 * @throws JDBCConnectionException
	 */
	public List<Libro> consultarLibro() throws JDBCConnectionException; 
	/**
	 * @param libro
	 * @throws JDBCConnectionException
	 */
	public void actualizar(Libro libro) throws JDBCConnectionException;

}

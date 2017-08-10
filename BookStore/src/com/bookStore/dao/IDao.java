package com.bookStore.dao;

import java.util.List;

import com.bookStore.model.Libro;

public interface IDao {
	public List<Libro> consultarLibro();

}

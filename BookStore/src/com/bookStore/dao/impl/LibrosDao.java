package com.bookStore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.bookStore.dao.IDao;
import com.bookStore.model.Libro;
import com.bookStore.persistence.HibernateUtil;

public class LibrosDao implements IDao {
	
	@SuppressWarnings("unchecked")
	public List<Libro> consultarLibro(){
        Session session = HibernateUtil.buildSessionFactory().openSession();
        
        Criteria cr = session.createCriteria(Libro.class);
        return cr.list();
	}
	

}

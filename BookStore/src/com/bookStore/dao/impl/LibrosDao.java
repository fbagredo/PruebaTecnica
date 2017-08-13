package com.bookStore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.exception.JDBCConnectionException;

import com.bookStore.dao.IDao;
import com.bookStore.model.Libro;
import com.bookStore.persistence.HibernateUtil;

public class LibrosDao implements IDao {

	/* (non-Javadoc)
	 * @see com.bookStore.dao.IDao#consultarLibro()
	 */
	@SuppressWarnings("unchecked")
	public List<Libro> consultarLibro() throws JDBCConnectionException {
		List<Libro> resultado;
		
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Criteria cr = session.createCriteria(Libro.class);
		resultado = cr.list();
		session.close();
		return resultado; 

	}

	/**
	 * @param libro
	 * @throws JDBCConnectionException
	 */
	public void actualizar(Libro libro) throws JDBCConnectionException {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		String hql = "update Libro set cantidad = :cantidadLibro  where id= :libroId";
		
		session.beginTransaction();

		session.createQuery(hql).setInteger("cantidadLibro", libro.getCantidad() - libro.getCantidadAAgregar())
				.setInteger("libroId", libro.getId()).executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

}

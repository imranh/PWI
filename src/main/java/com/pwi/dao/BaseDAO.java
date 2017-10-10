/**
 * 
 */
package com.pwi.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author imran
 *
 */
public abstract class BaseDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6263246357135947837L;

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * This method is used to get current active session
	 * 
	 * @return current active session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * This method is used to save an entity in database
	 * 
	 * @param entity
	 */
	public void save(Object entity) {
		try {
			getSession().save(entity);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * This method is used to save or update an entity in database
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		try {
			getSession().saveOrUpdate(entity);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param entity
	 */
	public void delete(Object entity) {
		try {
			getSession().delete(entity);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}

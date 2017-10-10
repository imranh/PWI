/**
 * 
 */
package com.pwi.dao.impl;

import java.io.Serializable;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pwi.dao.BaseDAO;
import com.pwi.dao.CountryDAO;
import com.pwi.model.Country;

/**
 * @author imran
 *
 */
@Repository
public class CountryDAOImpl extends BaseDAO implements CountryDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8042534515099162709L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCountry(Country country) {
		save(country);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCountry(Country country) {
		saveOrUpdate(country);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCountry(Country country) {
		delete(country);
	}

	@Override
	public Country getCountryByName(String name) {
		return (Country) getSession().createCriteria(Country.class).add(Restrictions.eq("name", name)).uniqueResult();
	}


}

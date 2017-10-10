/**
 * 
 */
package com.pwi.dao.impl;

import java.io.Serializable;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pwi.dao.BaseDAO;
import com.pwi.dao.CompanyDAO;
import com.pwi.model.Company;

/**
 * @author imran
 *
 */
@Repository
public class CompanyDAOImpl extends BaseDAO implements CompanyDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6653477523513723323L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCompany(Company company) {
		save(company);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCompany(Company company) {
		saveOrUpdate(company);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCompany(Company company) {
		delete(company);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Company getCompanyByName(String name) {
		return (Company) getSession().createCriteria(Company.class).add(Restrictions.eq("companyName", name)).uniqueResult();
	}

}

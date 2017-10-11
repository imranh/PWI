/**
 * 
 */
package com.pwi.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pwi.dao.BaseDAO;
import com.pwi.dao.WarehouseDAO;
import com.pwi.model.Warehouse;

/**
 * @author imran
 *
 */
@Repository
public class WarehouseDAOImpl extends BaseDAO implements WarehouseDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4189187642724932406L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addWarehouse(Warehouse warehouse) {
		save(warehouse);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateWarehouse(Warehouse warehouse) {
		saveOrUpdate(warehouse);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteWarehouse(Warehouse warehouse) {
		delete(warehouse);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Warehouse> getAllWarehousesByCompanyId(Integer companyId) {
		return getSession().createCriteria(Warehouse.class).add(Restrictions.eq("company.companyId", companyId)).list();
	}

}

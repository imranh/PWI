/**
 * 
 */
package com.pwi.dao.impl;

import java.io.Serializable;

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

}

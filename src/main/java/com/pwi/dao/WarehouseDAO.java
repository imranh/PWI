/**
 * 
 */
package com.pwi.dao;

import java.io.Serializable;

import com.pwi.model.Warehouse;


/**
 * @author imran
 *
 */
public interface WarehouseDAO extends Serializable {
	
	/**
	 * This method is used to create a new warehouse in database
	 * 
	 * @param warehouse information to be stored
	 */
	void addWarehouse(Warehouse warehouse);
	
	/**
	 * This method is used to update a warehouse's information
	 * 
	 * @param warehouse information to be updated
	 */
	void updateWarehouse(Warehouse warehouse);
	
	/**
	 * This method is used to delete a warehouse from database
	 * 
	 * @param warehouse object needs to be deleted
	 */
	void deleteWarehouse(Warehouse warehouse);

}

/**
 * 
 */
package com.pwi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pwi.model.Warehouse;

/**
 * @author imran
 *
 */
public interface WarehouseService extends Serializable {

	/**
	 * This method is used to store a new warehouse in database
	 * 
	 * @param warehouse information to be stored
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> addWarehouse(Warehouse warehouse);

	/**
	 * This method is used to update an existing warehouse in database
	 * 
	 * @param warehouse updated information object
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> updateWarehouse(Warehouse warehouse);

	/**
	 * This method is used to delete a warehouse from database
	 * 
	 * @param warehouse object to be deleted
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> deleteWarehouse(Warehouse warehouse);
	
	/**
	 * This method is used to get all warehouses of a company
	 * 
	 * @param companyId to restrict result to a single company
	 * @return list of warehouses
	 */
	List<Warehouse> getAllWarehousesByCompanyId(Integer companyId);
}

/**
 * 
 */
package com.pwi.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pwi.model.Warehouse;
import com.pwi.services.WarehouseService;

/**
 * @author imran
 *
 */
@RestController
public class WarehouseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994193840428638489L;
	
	@Autowired
	private WarehouseService warehouseService;
	
	/**
	 * This method is used to store a new warehouse in the database
	 * 
	 * @param warehouse information to be stored
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/addWarehouse", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> addWarehouse(@RequestBody Warehouse warehouse) {
		return warehouseService.addWarehouse(warehouse);
	}

	/**
	 * This method is used to store a update an existing warehouse information
	 * 
	 * @param warehouse information to be updated
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/updateWarehouse", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> updateWarehouse(@RequestBody Warehouse warehouse) {
		return warehouseService.updateWarehouse(warehouse);
	}

	/**
	 * This method is used to delete a warehouse from database
	 * 
	 * @param warehouse information to be delete
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/deleteWarehouse", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> deleteWarehouse(@RequestBody Warehouse warehouse) {
		return warehouseService.deleteWarehouse(warehouse);
	}

}

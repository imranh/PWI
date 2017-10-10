/**
 * 
 */
package com.pwi.services.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.WarehouseDAO;
import com.pwi.model.Warehouse;
import com.pwi.services.WarehouseService;

/**
 * @author imran
 *
 */
@Service("warehouseService")
@Transactional
public class WarehouseServiceImpl implements Serializable, WarehouseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6232461689325369679L;

	@Autowired
	private WarehouseDAO warehouseDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> addWarehouse(Warehouse warehouse) {
		try {
			warehouseDAO.addWarehouse(warehouse);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> updateWarehouse(Warehouse warehouse) {
		try {
			warehouseDAO.updateWarehouse(warehouse);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> deleteWarehouse(Warehouse warehouse) {
		try {
			warehouseDAO.deleteWarehouse(warehouse);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

}

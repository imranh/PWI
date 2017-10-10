/**
 * 
 */
package com.pwi.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.ItemsDAO;
import com.pwi.model.Inventory;
import com.pwi.model.Product;
import com.pwi.services.ItemsService;

/**
 * @author imran
 *
 */
@Service("itemsService")
@Transactional
public class ItemsServiceImpl implements Serializable, ItemsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7192712874909866928L;
	
	@Autowired
	private ItemsDAO itemsDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> addNewProduct(Product product) {
		try {
			itemsDAO.addItem(product);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> updateProduct(Product product) {
		try {
			itemsDAO.updateItem(product);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while updating data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> deleteProduct(Product product) {
		try {
			itemsDAO.deleteItem(product);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while deleting products.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> addInventory(Inventory inventory) {
		try {
			itemsDAO.addItem(inventory);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> updateInventory(Inventory inventory) {
		try {
			itemsDAO.updateItem(inventory);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while updating data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> setItemQuantityForWarehouses(Integer productId, Integer quantity, List<Integer> warehousesIds) {
		try {
			itemsDAO.setItemQuantity(null,null, warehousesIds);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while updating data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> setItemQuantityForOffices(List<Integer> officesIds, Product product) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> viewItemQuantityForWarehouses(Integer productId) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> viewItemQuantityForOffices(Integer productId) {
		return null;
	}

}

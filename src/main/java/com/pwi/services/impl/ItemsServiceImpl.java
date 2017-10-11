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
import com.pwi.model.Product;
import com.pwi.model.ProductSKU;
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
	@Transactional
	public ResponseEntity<Object> addItem(Object object) {
		try {
			itemsDAO.addItem(object);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> updateItem(Object object) {
		try {
			itemsDAO.updateItem(object);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while updating data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> deleteItem(Object object) {
		try {
			itemsDAO.deleteItem(object);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while deleting products.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product getProductByName(String name) {
		try {
			return itemsDAO.getProductByName(name);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductSKU getProductSKUByCode(String code) {
		try {
			return itemsDAO.getProductSKUByCode(code);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> setItemQuantityForWarehouses(Integer inventoryId, Integer quantity, List<Integer> warehousesIds) {
		try {
			itemsDAO.setItemQuantity(inventoryId, quantity, warehousesIds);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while updating data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> setItemQuantityForOffices(Integer inventoryId, List<Integer> officesIds) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Object[]> viewItemQuantityForWarehouses(Integer inventoryId, List<Integer>  warehousesIds) {
		try {
			return itemsDAO.viewItemQuantity(inventoryId, warehousesIds);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer viewItemQuantityForOffices(Integer productId, List<Integer> officesIds) {
		return null;
	}

}

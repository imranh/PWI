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

import com.pwi.model.Inventory;
import com.pwi.model.Product;
import com.pwi.services.ItemsService;

/**
 * @author imran
 *
 */
@RestController
public class ItemsController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8135076976702279591L;
	
	@Autowired
	private ItemsService itemsService;
	
	/**
	 * This method is used to store a new product in the database
	 * 
	 * @param product information to be stored
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/addNewProduct", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> addNewProduct(@RequestBody Product product) {
		return itemsService.addItem(product);
	}

	/**
	 * This method is used to store a update an existing product information
	 * 
	 * @param product information to be updated
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
		return itemsService.updateItem(product);
	}

	/**
	 * This method is used to delete a product from database
	 * 
	 * @param product information to be delete
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> deleteProduct(@RequestBody Product product) {
		return itemsService.deleteItem(product);
	}
	
	/**
	 * This method is used to store inventory of a product
	 * 
	 * @param inventory information to be stored
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/addInventory", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> addInventory(@RequestBody Inventory inventory) {
		return itemsService.addItem(inventory);
	}

	/**
	 * This method is used to store a update an existing product's inventory
	 * 
	 * @param inventory information to be updated
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/updateInventory", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> updateInventory(@RequestBody Inventory inventory) {
		return itemsService.updateItem(inventory);
	}

}

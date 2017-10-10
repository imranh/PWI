/**
 * 
 */
package com.pwi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pwi.model.Inventory;
import com.pwi.model.Product;

/**
 * @author imran
 *
 */
public interface ItemsService extends Serializable {

	/**
	 * This method is used to store a new product in database
	 * 
	 * @param product item to be stored
	 */
	ResponseEntity<Object> addNewProduct(Product product);

	/**
	 * This method is used to update an existing product
	 * 
	 * @param product item that needs to be update
	 */
	ResponseEntity<Object> updateProduct(Product product);

	/**
	 * This method is used to delete a product from database
	 * 
	 * @param product item needs to be delete
	 */
	ResponseEntity<Object> deleteProduct(Product product);

	/**
	 * This method is used to store a new product inventory in database
	 * 
	 * @param inventory  information to be stored
	 */
	ResponseEntity<Object> addInventory(Inventory inventory);

	/**
	 * This method is used to update existing inventory item
	 * 
	 * @param inventory item to be updated
	 */
	ResponseEntity<Object> updateInventory(Inventory inventory);
	
	/**
	 * This method is used to set item quantity for warehouse(s)
	 * 
	 * @param productId product for which we need to update quantity
	 * @param quantity amount that needs to be updated
	 * @param warehousesIds to restrict setting quantity for specified warehouse(s)
	 */
	ResponseEntity<Object> setItemQuantityForWarehouses(Integer productId, Integer quantity, List<Integer> warehousesIds);

	/**
	 * This method is used to set item quantity for office(s)
	 * 
	 * @param warehousesIds to restrict setting quantity for specified office(s)
	 * @param product for which quantity needs to be set
	 */
	ResponseEntity<Object> setItemQuantityForOffices(List<Integer> officesIds, Product product);

	/**
	 * This method is used to view item quantity for warehouse(s)
	 * 
	 * @param warehousesIds to restrict item quantity for specified warehouse(s)
	 * @param inventory to view specified item quantity
	 */
	List<Product> viewItemQuantityForWarehouses(Integer productId);

	/**
	 * This method is used to view item quantity for office(s)
	 * 
	 * @param warehousesIds to restrict item quantity for specified office(s)
	 * @param inventory to view specified item quantity
	 */
	List<Product> viewItemQuantityForOffices(Integer productId);
	
	
}

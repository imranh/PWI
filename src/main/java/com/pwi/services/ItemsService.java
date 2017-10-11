/**
 * 
 */
package com.pwi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pwi.model.Product;
import com.pwi.model.ProductSKU;

/**
 * @author imran
 *
 */
public interface ItemsService extends Serializable {

	/**
	 * This method is used to store a new item in database
	 * 
	 * @param object item to be stored
	 */
	ResponseEntity<Object> addItem(Object object);

	/**
	 * This method is used to update an existing item
	 * 
	 * @param object item that needs to be update
	 */
	ResponseEntity<Object> updateItem(Object object);

	/**
	 * This method is used to delete an item from database
	 * 
	 * @param object item needs to be delete
	 */
	ResponseEntity<Object> deleteItem(Object object);
	
	/**
	 * This method is used to get product by name from database
	 * 
	 * @param name product name
	 * @return product
	 */
	Product getProductByName(String name);
	
	/**
	 * This method is used to get productSKU by code from database
	 * 
	 * @param code product-sku code
	 * @return productSKU
	 */
	ProductSKU getProductSKUByCode(String code);
	
	/**
	 * This method is used to set item quantity for warehouse(s)
	 * 
	 * @param inventoryId product for which we need to update quantity
	 * @param quantity amount that needs to be updated
	 * @param warehousesIds to restrict setting quantity for specified warehouse(s)
	 */
	ResponseEntity<Object> setItemQuantityForWarehouses(Integer inventoryId, Integer quantity, List<Integer> warehousesIds);

	/**
	 * This method is used to set item quantity for office(s)
	 * 
	 * @param inventoryId for which quantity needs to be set
	 * @param officesIds to restrict setting quantity for specified office(s)
	 */
	ResponseEntity<Object> setItemQuantityForOffices(Integer inventoryId, List<Integer> officesIds);

	/**
	 * This method is used to view item quantity for warehouse(s)
	 * 
	 * @param inventoryId to view specified item quantity
	 * @param warehousesIds to restrict item quantity for specified warehouse(s)
	 */
	List<Object[]> viewItemQuantityForWarehouses(Integer inventoryId, List<Integer>  warehousesIds);

	/**
	 * This method is used to view item quantity for office(s)
	 * 
	 * @param inventoryId to view specified item quantity
	 * @param officesIds to restrict item quantity for specified office(s)
	 */
	Integer viewItemQuantityForOffices(Integer inventoryId, List<Integer> officesIds);
	
	
}

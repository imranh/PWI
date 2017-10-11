/**
 * 
 */
package com.pwi.dao;

import java.io.Serializable;
import java.util.List;

import com.pwi.model.Product;
import com.pwi.model.ProductSKU;

/**
 * @author imran
 *
 */
public interface ItemsDAO extends Serializable {
	
	/**
	 * This method is used to add new item in database
	 * 
	 * @param item (product/component/inventory) to be stored
	 */
	void addItem(Object item);
	
	/**
	 * This method is used to update a item's information
	 * 
	 * @param item (product/component/inventory) to be updated
	 */
	void updateItem(Object item);
	
	/**
	 * This method is used to delete an item from database
	 * 
	 * @param item (product/component/inventory) to be deleted
	 */
	void deleteItem(Object item);
	
	/**
	 * This method is used to get product by its name
	 * 
	 * @param name product name
	 * @return Product
	 */
	Product getProductByName(String name);
	
	/**
	 * This method is used to get ProductSKU by its code
	 * 
	 * @param code SKU code
	 * @return ProductSKU
	 */
	ProductSKU getProductSKUByCode(String code);
	
	/**
	 * This method is used to update Quantity of an item for single/multiple warehouses
	 * 
	 * @param productId product for which we need to update quantity
	 * @param quantity amount that needs to be updated
	 * @param warehousesIds to update for single/multiple warehouses
	 * @return TRUE/FALSE
	 */
	boolean setItemQuantity(Integer productId, Integer quantity, List<Integer> warehousesIds);
	
	/**
	 * This method is used to view an item's quantity for a single/multiple warehouses
	 * 
	 * @param productId to restrict results to a specific item
	 * @param warehousesIds to restrict results to single/multiple warehouses
	 * @return item's quantity
	 */
	List<Object[]> viewItemQuantity(Integer productId, List<Integer> warehousesIds);
	
	/**
	 * This method is used to get all available sizes of an item
	 * 
	 * @param productId to restrict results to a single item
	 * @return Available sizes
	 */
	String getAvailableSizesOfItem(Integer productId);

}

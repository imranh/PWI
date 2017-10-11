/**
 * 
 */
package com.pwi.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pwi.dao.BaseDAO;
import com.pwi.dao.ItemsDAO;
import com.pwi.model.Inventory;
import com.pwi.model.Product;
import com.pwi.model.ProductSKU;

/**
 * @author imran
 *
 */
@Repository
public class ItemsDAOImpl extends BaseDAO implements Serializable, ItemsDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 242247120560712254L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItem(Object item) {
		save(item);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItem(Object item) {
		saveOrUpdate(item);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteItem(Object item) {
		delete(item);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product getProductByName(String name) {
		return (Product) getSession().createCriteria(Product.class).add(Restrictions.eq("productName", name)).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductSKU getProductSKUByCode(String code) {
		return (ProductSKU) getSession().createCriteria(ProductSKU.class).add(Restrictions.eq("skuCode", code)).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean setItemQuantity(Integer inventoryId, Integer quantity, List<Integer> warehousesIds) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT inv FROM Inventory AS inv ")
		  		   .append("JOIN inv.warehouses AS warehouse ")
		  		   .append("WHERE inv.inventoryId = :inventoryId ")
		  		   .append("AND warehouse.warehouseId IN (:warehousesIds) ");
		Query query = getSession().createQuery(queryString.toString());
        query.setParameter("inventoryId", inventoryId);
        query.setParameterList("warehousesIds", warehousesIds);
        List<Inventory> inventories = query.list();
        if(inventories == null) { return false; }
        // update quantity
        inventories.forEach(inventory -> {
        	inventory.setInStockQuantity(quantity);
        	inventory.setEditDate(new Date());
        	saveOrUpdate(inventory);
        });
        return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> viewItemQuantity(Integer inventoryId, List<Integer> warehousesIds) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("FROM Inventory AS inv ")
		  		   .append("JOIN inv.warehouses AS warehouse ")
		  		   .append("JOIN inv.products AS product ")
		  		   .append("WHERE inv.inventoryId = :inventoryId ")
		  		   .append("AND warehouse.warehouseId IN (:warehousesIds) ");
		Query query = getSession().createQuery(queryString.toString());
        query.setParameter("inventoryId", inventoryId);
        query.setParameterList("warehousesIds", warehousesIds);
		return query.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAvailableSizesOfItem(Integer productId) {
		Criteria criteria = getSession().createCriteria(Product.class)
				.add(Restrictions.eq("product.productId", productId))
				.setProjection(Projections.property("product.productSKU.size"));
		return criteria.uniqueResult().toString();
	}

}

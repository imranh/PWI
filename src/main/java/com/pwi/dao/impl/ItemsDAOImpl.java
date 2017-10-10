/**
 * 
 */
package com.pwi.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pwi.dao.BaseDAO;
import com.pwi.dao.ItemsDAO;
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
	public boolean setItemQuantity(Integer productId, Integer quantity, List<Integer> warehousesIds) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("FROM ProductSKU AS pSKU ")
		  		   .append("JOIN FETCH pSKU.product.warehouses AS warehouse ")
		  .append("WHERE pSKU.product.productId = :productId ")
		  .append("AND warehouse.warehouseId IN (:warehousesIds) ");
		Query query = getSession().createQuery(queryString.toString());
        query.setParameter("productId", productId);
        query.setParameter("warehousesIds", warehousesIds);
        ProductSKU productSKU = (ProductSKU) query.uniqueResult();
        if(productSKU == null) { return false; }
        productSKU.setQuantity(quantity);
        productSKU.setEditDate(new Date());
        saveOrUpdate(productSKU);
        return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer viewItemQuantity(Integer productId, List<Integer> warehousesIds) {
		Criteria criteria = getSession().createCriteria(ProductSKU.class)
				.setFetchMode("product.warehouses", FetchMode.JOIN)
				.createAlias("product.warehouses", "warehouse")
				.add(Restrictions.eq("product.productId", productId))
				.add(Restrictions.in("warehouse.warehouseId", warehousesIds));
		
		return criteria.uniqueResult() == null ? 0 : (Integer) criteria.uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAvailableSizesOfItem(Integer productId) {
		Criteria criteria = getSession().createCriteria(ProductSKU.class)
				.add(Restrictions.eq("product.productId", productId))
				.setProjection(Projections.property("size"));
		return criteria.uniqueResult().toString();
	}

}

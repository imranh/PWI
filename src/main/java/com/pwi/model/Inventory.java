/**
 * 
 */
package com.pwi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 * @author imran
 *
 */
@Entity
@Audited
@Table(name = "Inventory")
public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4851624716058458982L;

	private Integer inventoryId;
	private List<Product> products;
	private Integer inStockQuantity;
	private Integer inTransitQuantity;
	private Date addDate;
	private Date editDate;
	private List<Warehouse> warehouses;

	@Id
	@Column(name = "inventory_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Column(name = "in_stock_qty", length = 11)
	public Integer getInStockQuantity() {
		return inStockQuantity;
	}

	public void setInStockQuantity(Integer inStockQuantity) {
		this.inStockQuantity = inStockQuantity;
	}

	@Column(name = "in_transit_qty", length = 11)
	public Integer getInTransitQuantity() {
		return inTransitQuantity;
	}

	public void setInTransitQuantity(Integer inTransitQuantity) {
		this.inTransitQuantity = inTransitQuantity;
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ADD_Date", nullable = false)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EDIT_Date", nullable = false)
	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}
	
	
}

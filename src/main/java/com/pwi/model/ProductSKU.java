/**
 * 
 */
package com.pwi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

/**
 * @author imran
 *
 */
@Entity
@Audited
@Table(name = "Product_SKU")
public class ProductSKU implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8232635311427319341L;

	private Integer skuId;
	private String skuCode;
	private float price;
	private Integer quantityPerBox;
	private Integer minOrderQuantity;
	private Integer reOrderPoint;
	private Date addDate;
	private Date editDate;
	private Integer size;
	
	@Id
	@Column(name = "sku_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	@Column(name = "sku_code", length = 64)
	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	@Column(name = "size", length = 11)
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "qty_per_box")
	public Integer getQuantityPerBox() {
		return quantityPerBox;
	}

	public void setQuantityPerBox(Integer quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}

	@Column(name = "min_order_qty")
	public Integer getMinOrderQuantity() {
		return minOrderQuantity;
	}

	public void setMinOrderQuantity(Integer minOrderQuantity) {
		this.minOrderQuantity = minOrderQuantity;
	}

	@Column(name = "reorder_point")
	public Integer getReOrderPoint() {
		return reOrderPoint;
	}

	public void setReOrderPoint(Integer reOrderPoint) {
		this.reOrderPoint = reOrderPoint;
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

}

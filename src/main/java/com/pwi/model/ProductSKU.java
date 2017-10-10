/**
 * 
 */
package com.pwi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "Product_SKU")
public class ProductSKU implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8232635311427319341L;

	private Integer skuId;
	private Product product;
	private String skuCode;
	private float price;
	private Integer quantityPerBox;
	private Integer minOrderQuantity;
	private Integer reOrderPoint;
	private Integer Quantity;
	private Date addDate;
	private Date editDate;

	@Column(name = "size", columnDefinition = "enum('small', 'medium', 'large', extra_large)", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private String size;
	
	
	public enum Size {
        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large"),
        EXTRA_LARGE("extra_large");

        private final String displayName;

        Size(String displayName) {
            this.displayName = displayName;
        }

        public String getName() {
            return this.name();
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }
	
	@Id
	@Column(name = "sku_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "sku_code", length = 64)
	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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
	
	@Column(name = "quantity")
	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
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

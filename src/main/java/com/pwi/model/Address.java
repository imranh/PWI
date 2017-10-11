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
@Table(name = "Address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2450758939423213239L;

	private Integer addressId;
	private String email;
	private Integer phoneNo;
	private Integer cellNo;
	private Integer faxNo;
	private String url;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private Date addDate;
	private Date editDate;
	
	@Column(name = "address_type", columnDefinition = "enum('physical', 'mailing')", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private String addressType;
	
	public enum AddressType {
        MAILING("mailing"),
        PHYSICAL("Physical");

        private final String displayName;

        AddressType(String displayName) {
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
	@Column(name = "address_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "email", length = 128)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone_number", length = 11)
	public Integer getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "cell_number", length = 11)
	public Integer getCellNo() {
		return cellNo;
	}

	public void setCellNo(Integer cellNo) {
		this.cellNo = cellNo;
	}

	@Column(name = "fax_number", length = 11)
	public Integer getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(Integer faxNo) {
		this.faxNo = faxNo;
	}

	@Column(name = "url", length = 128)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "address_line_1", length = 254)
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line_2", length = 254)
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "city", length = 128)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 128)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country", length = 128)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
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

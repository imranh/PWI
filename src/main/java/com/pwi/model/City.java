/**
 * 
 */
package com.pwi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author imran
 *
 */
@Entity
@Table(name = "City")
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4824666449256281338L;
	
	private Integer cityId;
	private String name;
	private String code;
	
	@Id
	@Column(name = "city_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	@Column(name = "name", length = 128)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "code", length = 128)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}

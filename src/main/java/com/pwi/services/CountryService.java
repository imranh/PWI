/**
 * 
 */
package com.pwi.services;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;

import com.pwi.model.Country;

/**
 * @author imran
 *
 */
public interface CountryService extends Serializable {

	/**
	 * This method is used to store a new country in database
	 * 
	 * @param country information to be stored
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> addCountry(Country country);

	/**
	 * This method is used to update an existing country in database
	 * 
	 * @param country updated information object
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> updateCountry(Country country);

	/**
	 * This method is used to delete a country from database
	 * 
	 * @param country object to be deleted
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> deleteCountry(Country country);
	
	/**
	 * This method is used to get a Country by its name from database
	 * 
	 * @param name of country
	 * @return Country Object in Response
	 */
	Country getCountryByName(String name);
	
}

/**
 * 
 */
package com.pwi.dao;

import java.io.Serializable;

import com.pwi.model.Country;

/**
 * @author imran
 *
 */
public interface CountryDAO extends Serializable {

	/**
	 * This method is used to create a new country in database
	 * 
	 * @param country information to be stored
	 */
	void addCountry(Country country);
	
	/**
	 * This method is used to update a country's information
	 * 
	 * @param country information to be updated
	 */
	void updateCountry(Country country);
	
	/**
	 * This method is used to delete a country from database
	 * 
	 * @param country object needs to be deleted
	 */
	void deleteCountry(Country country);
	
	/**
	 * This method is used to get a Country by its name from database
	 * 
	 * @param name of country
	 * @return Country Object in Response
	 */
	Country getCountryByName(String name);
	
}

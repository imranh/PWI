/**
 * 
 */
package com.pwi.dao;

import java.io.Serializable;

import com.pwi.model.Company;

/**
 * @author imran
 *
 */
public interface CompanyDAO extends Serializable {

	/**
	 * This method is used to create a new company in database
	 * 
	 * @param company information to be stored
	 */
	void addCompany(Company company);
	
	/**
	 * This method is used to update a company's information
	 * 
	 * @param company information to be updated
	 */
	void updateCompany(Company company);
	
	/**
	 * This method is used to delete a company from database
	 * 
	 * @param company objects needs to be deleted
	 */
	void deleteCompany(Company company);
	
	/**
	 * This method is used to get a Company by its name from database
	 * 
	 * @param name of company
	 * @return Country Object in Response
	 */
	Company getCompanyByName(String name);
}

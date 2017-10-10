/**
 * 
 */
package com.pwi.services;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;

import com.pwi.model.Company;

/**
 * @author imran
 *
 */
public interface CompanyService extends Serializable {

	/**
	 * This method is used to store a new company in database
	 * 
	 * @param company information to be stored
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> addCompany(Company company);

	/**
	 * This method is used to update an existing company in database
	 * 
	 * @param company updated information object
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> updateCompany(Company company);

	/**
	 * This method is used to delete a company from database
	 * 
	 * @param company object to be deleted
	 * @return SUCCESS/FAILURE
	 */
	ResponseEntity<Object> deleteCompany(Company company);
	
	/**
	 * This method is used to get a company by its name from database
	 * 
	 * @param name of company
	 * @return Country Object in Response
	 */
	Company getCompanyByName(String name);
}

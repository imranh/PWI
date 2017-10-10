/**
 * 
 */
package com.pwi.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pwi.model.Company;
import com.pwi.services.CompanyService;

/**
 * @author imran
 *
 */
@RestController
public class CompanyController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3753358914142003280L;

	@Autowired
	private CompanyService companyService;

	/**
	 * This method is used to store a new company in the database
	 * 
	 * @param company information to be stored
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> addCompany(@RequestBody Company company) {
		return companyService.addCompany(company);
	}

	/**
	 * This method is used to update an existing company information
	 * 
	 * @param company information to be updated
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> updateCompany(@RequestBody Company company) {
		return companyService.updateCompany(company);
	}

	/**
	 * This method is used to delete a company from database
	 * 
	 * @param company information to be delete
	 * @return SUCCESS/FAILURE status
	 */
	@RequestMapping(value = "/deleteCompany", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> deleteCompany(@RequestBody Company company) {
		return companyService.deleteCompany(company);
	}
}

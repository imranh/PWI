/**
 * 
 */
package com.pwi.services.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.CompanyDAO;
import com.pwi.model.Company;
import com.pwi.services.CompanyService;

/**
 * @author imran
 *
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements Serializable, CompanyService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7192712874909866928L;
	

	@Autowired
	private CompanyDAO companyDAO;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> addCompany(Company company) {
		try {
			companyDAO.addCompany(company);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> updateCompany(Company company) {
		try {
			companyDAO.updateCompany(company);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while updating data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> deleteCompany(Company company) {
		try {
			companyDAO.deleteCompany(company);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while deleting data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	public Company getCompanyByName(String name) {
		try {
			return companyDAO.getCompanyByName(name);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}

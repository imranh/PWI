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

import com.pwi.dao.CountryDAO;
import com.pwi.model.Country;
import com.pwi.services.CountryService;

/**
 * @author imran
 *
 */

@Service("countryService")
@Transactional
public class CountryServiceImpl implements Serializable, CountryService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -982682590751653863L;

	@Autowired
	private CountryDAO countryDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> addCountry(Country country) {
		try {
			countryDAO.addCountry(country);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> updateCountry(Country country) {
		try {
			countryDAO.updateCountry(country);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity<Object> deleteCountry(Country country) {
		try {
			countryDAO.deleteCountry(country);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("FAILURE: Error occurred while saving data.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	public Country getCountryByName(String name) {
		try {
			return countryDAO.getCountryByName(name);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}

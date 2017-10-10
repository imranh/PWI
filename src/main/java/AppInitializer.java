import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.pwi.configurations.AppConfig;
import com.pwi.model.Company;
import com.pwi.model.Country;
import com.pwi.model.Warehouse;
import com.pwi.services.CompanyService;
import com.pwi.services.CountryService;
import com.pwi.services.WarehouseService;

/**
 * 
 */

/**
 * @author imran
 *
 */
public class AppInitializer {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Save some countries
		CountryService countryService = (CountryService) context.getBean("countryService");
		
		Country country = new Country();
		country.setName("United States");
		country.setCode("USA");
		countryService.addCountry(country);
		
		country = new Country();
		country.setName("Ireland");
		country.setCode("IRL");
		countryService.addCountry(country);
		
		country = new Country();
		country.setName("Netherlands");
		country.setCode("NLD");
		countryService.addCountry(country);
		
		country = new Country();
		country.setName("Dubai");
		country.setCode("UAE");
		countryService.addCountry(country);
		
		country = new Country();
		country.setName("Australia");
		country.setCode("AUS");
		countryService.addCountry(country);
		
		country = new Country();
		country.setName("Italy");
		country.setCode("ITA");
		countryService.addCountry(country);
		
		country = new Country();
		country.setName("Pakistan");
		country.setCode("PAK");
		countryService.addCountry(country);
		
		country = new Country();
		country.setName("Mexico");
		country.setCode("MEX");
		countryService.addCountry(country);
		
		// Add a Company
		CompanyService companyService = (CompanyService) context.getBean("companyService");
		
		Company company = new Company();
		company.setCompanyName("ABC");
		company.setAddDate(new Date());
		company.setEditDate(new Date());
		companyService.addCompany(company); // Can also return Company object from save method to move further with same company
		
		country = countryService.getCountryByName("Pakistan");
		company = companyService.getCompanyByName("ABC");
		WarehouseService warehouseService = (WarehouseService) context.getBean("warehouseService");
		
		Warehouse warehouse = new Warehouse();
		warehouse.setCountry(country);
		warehouse.setCompany(company);
		warehouse.setAddDate(new Date());
		warehouse.setEditDate(new Date());
		warehouse.setWarehouseName("Warehouse 1");
		
		warehouseService.addWarehouse(warehouse);
		
		warehouse = new Warehouse();
		warehouse.setCountry(country);
		warehouse.setCompany(company);
		warehouse.setAddDate(new Date());
		warehouse.setEditDate(new Date());
		warehouse.setWarehouseName("Warehouse 2");
		
		warehouseService.addWarehouse(warehouse);
		
		warehouse = new Warehouse();
		warehouse.setCountry(country);
		warehouse.setCompany(company);
		warehouse.setAddDate(new Date());
		warehouse.setEditDate(new Date());
		warehouse.setWarehouseName("Warehouse 3");
		
		warehouseService.addWarehouse(warehouse);
		
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.pwi.configurations.AppConfig;
import com.pwi.model.Company;
import com.pwi.model.Country;
import com.pwi.model.Inventory;
import com.pwi.model.Product;
import com.pwi.model.ProductSKU;
import com.pwi.model.Warehouse;
import com.pwi.services.CompanyService;
import com.pwi.services.CountryService;
import com.pwi.services.ItemsService;
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
		
		// add countries
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
		companyService.addCompany(company);
		
		country = countryService.getCountryByName("Pakistan");
		
		// Add warehouses
		WarehouseService warehouseService = (WarehouseService) context.getBean("warehouseService");
		List<Warehouse> warehouses = new ArrayList<>();
		Warehouse warehouse = new Warehouse();
		warehouse.setCountry(country);
		warehouse.setCompany(company);
		warehouse.setAddDate(new Date());
		warehouse.setEditDate(new Date());
		warehouse.setWarehouseName("Warehouse 1");
		warehouseService.addWarehouse(warehouse);
		warehouses.add(warehouse);
		
		warehouse = new Warehouse();
		warehouse.setCountry(country);
		warehouse.setCompany(company);
		warehouse.setAddDate(new Date());
		warehouse.setEditDate(new Date());
		warehouse.setWarehouseName("Warehouse 2");
		warehouseService.addWarehouse(warehouse);
		warehouses.add(warehouse);
		
		warehouse = new Warehouse();
		warehouse.setCountry(country);
		warehouse.setCompany(company);
		warehouse.setAddDate(new Date());
		warehouse.setEditDate(new Date());
		warehouse.setWarehouseName("Warehouse 3");
		warehouseService.addWarehouse(warehouse);
		warehouses.add(warehouse);
		
		// Add Inventory
		ItemsService itemsService = (ItemsService) context.getBean("itemsService");
		Inventory inventory  = new  Inventory();
		ProductSKU productSKU = new ProductSKU();
		productSKU.setAddDate(new Date());
		productSKU.setEditDate(new Date());
		productSKU.setQuantityPerBox(5);
		productSKU.setReOrderPoint(10);
		productSKU.setSize(10);
		productSKU.setSkuCode("PRO1");
		productSKU.setPrice(100);
		itemsService.addItem(productSKU);
		Product product = new Product();
		product.setActive(true);
		product.setProductName("Product A");
		product.setAddDate(new Date());
		product.setEditDate(new Date());
		product.setProductSKU(productSKU);
		itemsService.addItem(product);
		inventory.setInStockQuantity(50);
		inventory.setInTransitQuantity(20);
		inventory.setProducts(new ArrayList<>(Arrays.asList(product)));
		inventory.setAddDate(new Date());
		inventory.setEditDate(new Date());
		inventory.setWarehouses(warehouses);
		itemsService.addItem(inventory);
		
		List<Integer> warehouseIds = warehouses.stream().map(Warehouse::getWarehouseId).collect(Collectors.toList());
		// set quantity for all warehouses
		itemsService.setItemQuantityForWarehouses(inventory.getInventoryId(), 100 , warehouseIds);
		
		// get quantity for all warehouses
		List<Object[]> itemsList = itemsService.viewItemQuantityForWarehouses(inventory.getInventoryId(), warehouseIds);
		for(Object[] obj : itemsList) {
			Inventory inv = (Inventory) obj[0];
			Warehouse wh = (Warehouse) obj[1];
			Product pro = (Product) obj[2];
			// These data is against all warehouses of a country "PAKISTAN"
			// Can be done in a single query
			// Can print all detail here.
		}
		
	}
}

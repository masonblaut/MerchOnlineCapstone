package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

/**
 * RESTful API Service for Merch Online products.
 * @author Mason Blaut
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/service/products")
public class ProductRestService {
	
	@Autowired
	ProductBusinessInterface service;
	
	/**
	 * Returns JSON Data for all Products by calling getProducts() from the ProductBusinessService.
	 * @return List of ProductModel objects in JSON value format. 
	 */
	@GetMapping(path="/", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getProductsAsJson()
	{
		return service.getProducts();
	}
	/**
	 * Returns XML Data for all Products by calling getProducts() from the ProductBusinessService.
	 * @return List of ProductModel objects in XML value format.
	 */
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ProductList getProductsAsXml()
	{
		ProductList list = new ProductList();
		list.setOrders(service.getProducts());
		return list;
	}
	/**
	 * Returns a ResponseEntity for a single product in JSON value format by calling findByProductId() from the ProductBusinessService with the id String parameter.
	 * @param id used to findProductById()
	 * @return ResponseEntity Generic.
	 */
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") String id)
	{
		try
		{
			ProductModel order = service.findProductById(id);
			if(order == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(order, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * Returns a ResponseEntity for a single product in JSON value format by calling findByProductId() from the ProductBusinessService with the id String parameter.
	 * @param id used to findProductById()
	 * @return ResponseEntity Generic.
	 */
	@GetMapping(path="/search/productName/{phrase}")
	public ResponseEntity<?> getProductByName(@PathVariable("phrase") String phrase)
	{
		try
		{
			List<ProductModel> order = service.findProductByProductName(phrase);
			if(order.isEmpty())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(order, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

package com.cjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.model.Customer;
import com.cjc.model.Product;
import com.cjc.repository.ProductRepository;
import com.cjc.service.CustomerService;

@RestController
@RequestMapping("/api")
public class HomeController {
 
	   @Autowired
	  private CustomerService service;
	  
	   @Autowired
	   private ProductRepository repo;
	   
	@GetMapping("/")
	 public ResponseEntity<String> checkApp() {
		
		return new ResponseEntity<String>("Welcome to App",HttpStatus.OK);
	}

	 @PostMapping("/saveCustomer")
	 public ResponseEntity<String>  saveCustomer(@RequestBody Customer customer) {

		     String status = service.saveCustomer(customer);
		   return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	 
	 @PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		
		 repo.save(product);
		 
		 return new ResponseEntity<String>("Saved ",HttpStatus.CREATED);
		 
	} 
	 
}

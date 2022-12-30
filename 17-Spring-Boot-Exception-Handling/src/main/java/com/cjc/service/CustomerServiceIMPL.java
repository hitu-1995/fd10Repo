package com.cjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.exceptions.NameInvalidException;
import com.cjc.model.Customer;
import com.cjc.repository.CustomerRepo;
@Service
public class CustomerServiceIMPL implements CustomerService{

	@Autowired
	 private CustomerRepo repo;
	
	@Override
	public String saveCustomer(Customer customer) {
		
		 if(customer.getCid()!=0) {

			   if(customer.getCname()!=null&&!customer.getCname().isEmpty()) {
				repo.save(customer);
				 return "Customer Saved";
			   }
			   else throw new NameInvalidException();
		 }
		 else throw new ArithmeticException();
	}

	
}

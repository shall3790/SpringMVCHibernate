package com.journaldev.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.model.Customer;
import com.journaldev.spring.model.Order;
import com.journaldev.spring.service.CustomerService;

@RestController()
@RequestMapping("/api/*")
public class ApiController {
	
	private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService cs){
		this.customerService = cs;
	}
	
	
	@RequestMapping("test")
	public String test() {
		return "Hello World";
	}
	
	@RequestMapping("orders")
	public List<Order> getOrders() {
		//List<Order> list = or
		return null;
	}
	
	@RequestMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {//REST Endpoint.
		Customer c = customerService.getCustomerById(Integer.parseInt(customerId));
		return c;
	}
	
	@RequestMapping("customers")
	//@ResponseBody
	public List<Customer> getCustomers() {
		List<Customer> customerList = customerService.listCustomers();
		return customerList;
	}
}

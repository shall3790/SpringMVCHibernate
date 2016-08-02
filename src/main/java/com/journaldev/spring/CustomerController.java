package com.journaldev.spring;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Customer;
import com.journaldev.spring.model.Order;
import com.journaldev.spring.service.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService cs){
		this.customerService = cs;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		
		List<Customer> custList = this.customerService.listCustomers();
		model.addAttribute("listCustomers", custList);
		
		return "customer";
	}
	
	//For add and update customer both
	@RequestMapping(value= "add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("customer") Customer c){
		Date today = new Date();
		
		if(c.getCustomerId() == 0){
			//new person, add it
			Customer c1 = c;
			
			Order o1 = new Order();
//			Date orderDate = new Date();
//			Date shipDate = new Date();
			o1.setOrderDate("2016-01-01");
			o1.setShipDate("2016-03-01");
			
			c1.addOrder(o1);
			
			this.customerService.addCustomer(c);
		} else {
			//existing person, call update
			this.customerService.updateCustomer(c);
		}
		
		return "redirect:/customer/list";
		
	}
	
	@RequestMapping("remove/{id}")
    public String removeCustomer(@PathVariable("id") int id){
		
        this.customerService.removeCustomer(id);
        return "redirect:/customer/list";
    }
 
    @RequestMapping("edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }
	
}

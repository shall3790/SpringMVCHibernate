package com.journaldev.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Customer", catalog = "testdb")
public class Customer {

	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("CustomerId")
	private int customerId;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="customer") 
	private List<Order> orders = new ArrayList<Order>();
	
	@JsonProperty("LastName")
	private String lastName;
	
	@JsonProperty("FirstName")
	private String firstName;
	
	@JsonProperty("Address")
	private String address;
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("State")
	private String state;
	
	@JsonProperty("Zip")
	private String zip;
	
	public Customer() {
		
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Customer [id=" + this.customerId + ", lastName=" + lastName + ", firstsName=" + firstName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
//	
	public void addOrder(Order order) {
		order.setCustomer(this);
		
		orders.add(order);
	}
	
}

package com.journaldev.spring.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order", catalog = "testdb")
public class Order {
	
	@Id
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	private String orderDate;
	
	private String shipDate;
	
    @ManyToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="CUSTOMER_ID", nullable=false)
	private Customer customer;
	
    
	public Order() {
		
	}
	
	
	public int getOrderId() {
		return this.orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}

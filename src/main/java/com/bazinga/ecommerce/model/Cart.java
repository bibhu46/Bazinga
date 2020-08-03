package com.bazinga.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemNo;
	@Column
	private String productName;
	@Column
	private int productId;
	@Column
	private int quantity;
	@Column
	private double price;
	
	public Cart(int itemNo, String productName, int productId, int quantity, double price) {
		super();
		this.itemNo = itemNo;
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		
	}
	public int getItemNo() {
		return itemNo;
	}
	public String getProductName() {
		return productName;
	}
	public int getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	
	
	
}

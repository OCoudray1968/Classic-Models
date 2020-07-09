package com.classicModels.beans;

public class CartBean {

	private String productCode;
	private String designation;
	private int quantity;
	private Double price;

	
	public CartBean (String productCode,String designation,int quantity,double price) {
		
		this.productCode=productCode;
		this.designation=designation;
		this.quantity=quantity;
		this.price=price;
	
	}
	
	public CartBean() {}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	
}

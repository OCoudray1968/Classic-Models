package com.classicModels.beans;

public class OrderDetailsBean {

	//Numero de commande
	private int OrderNumber =0;
	//Code produit
	private String ProductCode="";
	//Quantit� command�
	private int QuantityOrdered=0;
	//Prix Unitaire
	private Double PriceEach;
	//Numero ligne de commande
	private int OrderLineNumber=0;
	
	public OrderDetailsBean(int OrderNumber, String productCode, int QuantityOrdered, Double PriceEach,int OrderLineNumber) {
		
		this.OrderNumber=OrderNumber;
		this.ProductCode=productCode;
		this.QuantityOrdered=QuantityOrdered;
		this.PriceEach=PriceEach;
		this.OrderLineNumber=OrderLineNumber;
	}

	public OrderDetailsBean() {}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.OrderNumber = orderNumber;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		this.ProductCode = productCode;
	}

	public int getQuantityOrdered() {
		return QuantityOrdered;
	}

	public void setQuantityOrdered(int quantityOdered) {
		this.QuantityOrdered = quantityOdered;
	}

	public Double getPriceEach() {
		return PriceEach;
	}

	public void setPriceEach(Double priceEach) {
		this.PriceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return OrderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.OrderLineNumber = orderLineNumber;
	}
	
	
}


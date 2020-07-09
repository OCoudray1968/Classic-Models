package com.classicModels.beans;


import java.util.Date;


public class OrdersBean {

	//Numero commande
	private int OrderNumber =0;
	//Date commande
	private Date OrderDate;
	//Date demand�e
	private Date RequiredDate;
	//Date livraison
	private Date ShippedDate;
	//Etat de la commande
	private String Status ="";
	//commentaires
	private String Comments ="";
	//Numero de client reli� a Customers
	private long CustomerNumber = 0;
	
	public OrdersBean(int OrderNumber, Date OrderDate, Date RequiredDate,Date ShippeDate,String Status,String Comments, long CustomerNumber ) {
		
		this.OrderNumber=OrderNumber;
		this.OrderDate=OrderDate;
		this.RequiredDate=RequiredDate;
		this.ShippedDate=ShippeDate;
		this.Status=Status;
		this.CustomerNumber=CustomerNumber;
	}
	
	public OrdersBean() {}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.OrderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.OrderDate = orderDate;
	}

	public Date getRequiredDate() {
		return RequiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.RequiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return ShippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.ShippedDate = shippedDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String statusOrder) {
		this.Status = statusOrder;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		this.Comments = comments;
	}

	public long getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(long l) {
		this.CustomerNumber = l;
	}
	
	
}

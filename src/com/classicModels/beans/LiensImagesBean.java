package com.classicModels.beans;

public class LiensImagesBean {

	// numero de client lie a la table customer
	private Integer CustomerNumber = 0;
	//Numero du salarie lie a la table employee
	private Integer EmployeeNumber = 0;
	//Code produit li� a la table products
	private String ProductCode ="";
	// Numero image li� a la table Image
	private Integer IDImage = 0 ;
	
	public LiensImagesBean(Integer CustomerNumber, Integer EmployeeNumber, String ProductCode, Integer IDImage) {
		
		this.CustomerNumber=CustomerNumber;
		this.EmployeeNumber=EmployeeNumber;
		this.ProductCode=ProductCode;
		this.IDImage=IDImage;
	}
	
	public LiensImagesBean() {}

	public Integer getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.CustomerNumber = customerNumber;
	}

	public Integer getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.EmployeeNumber = employeeNumber;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		this.ProductCode = productCode;
	}

	public Integer getIDImage() {
		return IDImage;
	}

	public void setIDImage(Integer iDImage) {
		this.IDImage = iDImage;
	}
	
	
}

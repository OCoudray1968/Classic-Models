package com.classicModels.beans;


public class CustomersBean {
	
	// ID Client
	private long CustomerNumber;
	// Nom client
	private String CustomerName;
	// Nom contact
	private String ContactLastName;
	// Prenom Contact
	private String ContactFirstName;
	// Telephone
	private String Phone;
	//Ligne adresse 1
	private String AddressLine1 ;
	//Ligne adresse 2
	private String AddressLine2 ;
	//Ville
	private String City;
	// etat
	private String State;
	//Code Postal
	private String PostalCode;
	//Pays
	private String Country ;
	//Representant
	private long SalesRepEmployeeNumber ;
	//Credit limite
	private double CreditLimit;
	
	public CustomersBean(long CustomerNumber, String CustomerName, String ContactLastName, String ContactfirstName, String Phone, String AddressLine1,
			
				String AddressLine2, String City, String State,String PostalCode, String Country, long SalesRepEmployeeNumber, double CreditLimit) {
		
		this.CustomerNumber=CustomerNumber;
		this.CustomerName=CustomerName;
		this.ContactLastName=ContactLastName;
		this.ContactFirstName=ContactfirstName;
		this.Phone=Phone;
		this.AddressLine1=AddressLine1;
		this.AddressLine2=AddressLine2;
		this.City=City;
		this.State=State;
		this.PostalCode=PostalCode;
		this.Country=Country;
		this.SalesRepEmployeeNumber=SalesRepEmployeeNumber;
		this.CreditLimit=CreditLimit;
			
		
	}
	
	public CustomersBean() {	}

	public long getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.CustomerNumber = customerNumber;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		this.CustomerName = customerName;
	}

	public String getContactLastName() {
		return ContactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.ContactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return ContactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.ContactFirstName = contactFirstName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.AddressLine2 = addressLine2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		this.PostalCode = postalCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		this.Country = country;
	}

	public long getSalesRepEmployeeNumber() {
		return SalesRepEmployeeNumber;
	}

	public void setSalesRepEmployeeNumber(long salesRep) {
		this.SalesRepEmployeeNumber = salesRep;
	}

	public double getCreditLimit() {
		return CreditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.CreditLimit = creditLimit;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	
	
		
	
	
	
	
	
}

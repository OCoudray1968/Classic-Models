package com.classicModels.DTO;

import com.classicModels.beans.RegistrationBean;



public class RegistrationDTO extends AbstractDTO {
	// Correspondent en tous point aux champs de la table classicmodels.Registration
	private long customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String login;
	private String pwd;

	
	/*
	 * Initialisation
	 */
	public RegistrationDTO() {
		clear();
	}
	
	/*
	 * Initialisation à partir d'un Bean
	 */
	public RegistrationDTO (RegistrationBean bean) {
		this.addressLine1 = bean.getAddressLine1();
		this.addressLine2 = bean.getAddressLine2();
		this.city = bean.getCity();
		this.contactLastName = bean.getContactLastName();
		this.contactFirstName = bean.getContactFirstName();
		this.country = bean.getCountry();
		this.customerNumber = bean.getCustomerNumber();
		this.customerName = bean.getCustomerName();
		this.phone = bean.getPhone();
		this.postalCode = bean.getPostalCode();
		this.state = bean.getState();
		this.login=bean.getLogin();
		this.pwd=bean.getPwd();
	}
	
	/*
	 * Retourne un Bean
	 */
	public RegistrationBean getBean() {
		RegistrationBean b = new RegistrationBean();
		b.setAddressLine1(this.getAddressLine1());
		b.setAddressLine2(this.getAddressLine2());
		b.setCity(this.getCity());
		b.setContactFirstName(this.getContactFirstName());
		b.setContactLastName(this.getContactLastName());
		b.setCountry(this.getCountry());
		b.setCustomerName(this.getCustomerName());
		b.setCustomerNumber(this.getCustomerNumber());
		b.setPhone(this.getPhone());
		b.setPostalCode(this.getPostalCode());
		b.setState(this.getState());
		b.setLogin(this.getLogin());
		
		return b;
	}
	
	/*
	 * Edition
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[RegistrationDTO]\n")
		  .append("customerNumber : ").append(this.getCustomerNumber()).append(", ")
		  .append("customerName : ").append(this.getCustomerName()).append(", \n")
		  .append("addressLine1 : ").append(this.getAddressLine1()).append(", ")
		  .append("addressLine2 : ").append(this.getAddressLine2()).append(", \n")
		  .append("postalCode : ").append(this.getPostalCode()).append(", ")
		  .append("city : ").append(this.getCity()).append(", \n")
		  .append("state : ").append(this.getState()).append(", \n")
		  .append("country : ").append(this.getCountry()).append(", \n")
		  .append("contactLastName : ").append(this.getContactLastName()).append(", ")
		  .append("contactFirstName : ").append(this.getContactFirstName()).append(",")
		  .append("login :").append(this.getLogin()).append(",")
		  .append("password :").append(this.getPwd()).append(";\n");
		  
		return sb.toString();
	}
	
	private void clear() {
		this.customerNumber = 0L;
		this.customerName = "";
		this.contactLastName = 	"";
		this.contactFirstName = "";
		this.phone = "";
		this.addressLine1 = "";
		this.addressLine2 = "";
		this.city = "";
		this.state = "";
		this.postalCode = "";
		this.country = "";
		this.login="";
		this.pwd="";
	
	}

	/*
	 * ACCESSEURS
	 */
	public long getCustomerNumber() { return customerNumber;}
	public void setCustomerNumber(long customerNumber) { this.customerNumber = customerNumber;}
	
	public String getCustomerName() { return customerName;}
	public void setCustomerName(String customerName) { this.customerName = customerName;}
	
	public String getContactLastName() { return contactLastName;}
	public void setContactLastName(String contactLastName) { this.contactLastName = contactLastName;}
	
	public String getContactFirstName() { return contactFirstName;}
	public void setContactFirstName(String contactFirstName) { this.contactFirstName = contactFirstName;}
	
	public String getPhone() { return phone;}
	public void setPhone(String phone) { this.phone = phone;}
	
	public String getAddressLine1() { return addressLine1;}
	public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1;}
	
	public String getAddressLine2() { return addressLine2;}
	public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2;}
	
	public String getCity() { return city;}
	public void setCity(String city) { this.city = city;}
	
	public String getState() { return state;}
	public void setState(String state) { this.state = state;}
	
	public String getPostalCode() { return postalCode;}
	public void setPostalCode(String postalCode) { this.postalCode = postalCode;}
	
	public String getCountry() { return country;}
	public void setCountry(String country) {this.country = country;}
	
	public String getLogin() { return login;}
	public void setLogin(String login) {this.login= login;}
	
	public String getPwd() { return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	
}

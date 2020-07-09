package com.classicModels.beans;

public class OfficesBean {

	// code du bureau
	private int OfficeCode =0;
	//ville 
	private String City ="";
	//telephone
	private String PhoneOffice ="";
	//ligne adresse 1 et 2
	private String AddressLine1 = "";
	private String AddressLine2 = "";
	//Etat
	private String StateOffice = "";
	//pays
	private String CountryOffice = "";
	//Code postal
	private String PostalCode = "";
	//Territoire
	private String Territory ="";
	
	public OfficesBean(int OfficeCode, String City, String PhoneOffice, String Addressline1, String AddressLine2,String StateOffice, 
			String CountryOffice, String PostalCode, String Territory) {
		
		this.OfficeCode=OfficeCode;
		this.City=City;
		this.PhoneOffice=PhoneOffice;
		this.AddressLine1=Addressline1;
		this.AddressLine2=AddressLine2;
		this.StateOffice=StateOffice;
		this.CountryOffice=CountryOffice;
		this.PostalCode=PostalCode;
		this.Territory=Territory;
	}

	
	public OfficesBean() {}


	public int getOfficeCode() {
		return OfficeCode;
	}


	public void setOfficeCode(int officeCode) {
		OfficeCode = officeCode;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getPhoneOffice() {
		return PhoneOffice;
	}


	public void setPhoneOffice(String phoneOffice) {
		PhoneOffice = phoneOffice;
	}


	public String getAddressLine1() {
		return AddressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return AddressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}


	public String getStateOffice() {
		return StateOffice;
	}


	public void setStateOffice(String stateOffice) {
		StateOffice = stateOffice;
	}


	public String getCountryOffice() {
		return CountryOffice;
	}


	public void setCountryOffice(String countryOffice) {
		CountryOffice = countryOffice;
	}


	public String getPostalCode() {
		return PostalCode;
	}


	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}


	public String getTerritory() {
		return Territory;
	}


	public void setTerritory(String territory) {
		Territory = territory;
	}
	
	
}

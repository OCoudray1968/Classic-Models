package com.classicModels.DTO;

import com.classicModels.beans.OfficesBean;

public class OfficesDTO extends AbstractDTO{
	
	private int OfficeCode;
	private String City;
	private String PhoneOffice;
	private String AddressLine1;
	private String AddressLine2;
	private String StateOffice;
	private String CountryOffice;
	private String PostalCode;
	private String Territory;
	
	
	public  OfficesDTO() {clear();}
	
	public OfficesDTO(OfficesBean bean) {
		
			this.OfficeCode=bean.getOfficeCode();
			this.City=bean.getCity();
			this.PhoneOffice=bean.getPhoneOffice();
			this.AddressLine1=bean.getAddressLine1();
			this.AddressLine2=bean.getAddressLine2();
			this.StateOffice=bean.getStateOffice();
			this.CountryOffice=bean.getCountryOffice();
			this.PostalCode=bean.getPostalCode();
			this.Territory=bean.getTerritory();
			
		}
		
	public void clear() {
			
			this.OfficeCode=0;
			this.City="";
			this.PhoneOffice="";
			this.AddressLine1="";
			this.AddressLine2="";
			this.StateOffice="";
			this.CountryOffice="";
			this.PostalCode="";
			this.Territory="";
			
		}
		
	public OfficesBean getBean() {
		
			OfficesBean bean = new OfficesBean();
			
			bean.setOfficeCode(getOfficeCode());
			bean.setCity(getCity());
			bean.setPhoneOffice(getPhoneOffice());
			bean.setAddressLine1(getAddressLine1());
			bean.setAddressLine2(getAddressLine2());
			bean.setStateOffice(getStateOffice());
			bean.setCountryOffice(getCountryOffice());
			bean.setPostalCode(getPostalCode());
			bean.setTerritory(getTerritory());
					
			return bean;
			
		}
	
	public String toString() {
		StringBuilder sb =new StringBuilder();
			sb.append("[officesDTO]\n")
				.append("office_code : ").append(this.getOfficeCode()).append(", \n")
				.append("city: ").append(this.getCity()).append(", \n")
				.append("phone_office : ").append(this.getPhoneOffice()).append(", \n")
				.append("address_line1 : ").append(this.getAddressLine1()).append(", \n")
				.append("address_line2 : ").append(this.getAddressLine2()).append(", \n")
				.append("state_office : ").append(this.getStateOffice()).append(", \n")
				.append("country_office :").append(this.getCountryOffice()).append(", \n")
				.append("postal_code : ").append(this.getPostalCode()).append(", \n")
				.append("territory :").append(this.getTerritory()).append(", \n");
				
				
			return sb.toString();
						
						
	}

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

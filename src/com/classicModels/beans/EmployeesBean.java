package com.classicModels.beans;



public class EmployeesBean {

	//Numero Employee
	private long EmployeeNumber = 0;
	// Nom Employee
	private  String LastName ="";
	// Prenom
	private  String FirstName="";
	//Phone Extension
	private String Extension ="";
	//email
	private String Email="";
	//Bureau ou il est localis� li� a table office
	private int OfficeCode =0;
	//A qui il reporte li� a table employees
	private int ReportsTo =0;
	//Denomination du poste
	private String JobTitle ="";
	
	public EmployeesBean( long EmployeeNumber, String LastName, String FirstName, String Extension, String Email, int OfficeCode,
			int ReportsTo, String JobTitle) {
		
		this.EmployeeNumber=EmployeeNumber;
		this.LastName=LastName;
		this.FirstName=FirstName;
		this.Extension=Extension;
		this.Email=Email;
		this.OfficeCode=OfficeCode;
		this.ReportsTo=ReportsTo;
		this.JobTitle=JobTitle;
	}
	
	public EmployeesBean() {}

	public long getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		EmployeeNumber = employeeNumber;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public  String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getExtension() {
		return Extension;
	}

	public void setExtension(String extension) {
		Extension = extension;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Integer getOfficeCode() {
		return OfficeCode;
	}

	public void setOfficeCode(int officeCode) {
		OfficeCode = officeCode;
	}

	public Integer getReportsTo() {
		return ReportsTo;
	}

	public void setReportsTo(int reportsTo) {
		ReportsTo = reportsTo;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	
	
	
}

package com.classicModels.beans;

import java.util.Date;

public class LoginsBean {

	// Numero client lie a table la Customers
	private Long CustomerNumber = 0L;
	// Numero employee li� a la table Employees
	private Integer EmployeeNumber = 0;
	// Login de connection
	private String Login = "";
	// Password de connection
	private String PwdLogin = "";
	// profil de connection
	private Integer profil = 0;
	// date création
	private Date dateCrea;
	// date modification
	private Date dateMAJ;

	public LoginsBean(Long CustomerNumber, Integer EmployeeNumber, String Login, String PwdLogin, Integer Profil,
			Date dateCrea, Date dateMAJ) {

		this.CustomerNumber = CustomerNumber;
		this.EmployeeNumber = EmployeeNumber;
		this.Login = Login;
		this.PwdLogin = PwdLogin;
		this.profil = Profil;
		this.dateCrea = dateCrea;
		this.dateMAJ = dateMAJ;
	}

	public LoginsBean() {
	}

	public Long getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.CustomerNumber = customerNumber;
	}

	public Integer getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.EmployeeNumber = employeeNumber;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		this.Login = login;
	}

	public String getPwdLogin() {
		return PwdLogin;
	}

	public void setPwdLogin(String PwdLogin) {
		this.PwdLogin = PwdLogin;
	}

	public Integer getProfil() {
		return profil;
	}

	public void setProfil(Integer profil) {
		this.profil = profil;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Date getDateMAJ() {
		return dateMAJ;
	}

	public void setDateMAJ(Date dateMAJ) {
		this.dateMAJ = dateMAJ;
	}

}

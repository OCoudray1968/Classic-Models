package com.classicModels.DTO;

import java.util.Date;

import com.classicModels.beans.LoginsBean;

public class LoginsDTO extends AbstractDTO {

	private long CustomerNumber;
	private int EmployeeNumber;
	private String Login;
	private String PasswordLogin;
	private int Profil;
	private Date dateCrea;
	private Date dateMAJ;

	public LoginsDTO() {
		clear();
	}

	public LoginsDTO(LoginsBean bean) {

		this.CustomerNumber = bean.getCustomerNumber();
		this.EmployeeNumber = bean.getEmployeeNumber();
		this.Login = bean.getLogin();
		this.PasswordLogin = bean.getPwdLogin();
		this.Profil = bean.getProfil();
		this.dateCrea = bean.getDateCrea();
		this.dateMAJ = bean.getDateMAJ();

	}

	public void clear() {

		this.CustomerNumber = 0;
		this.EmployeeNumber = 0;
		this.Login = "";
		this.PasswordLogin = "";
		this.Profil = 0;
		this.dateCrea = new Date(0);
		this.dateMAJ = new Date(0);

	}

	public LoginsBean getBean() {

		LoginsBean bean = new LoginsBean();

		bean.setCustomerNumber(getCustomerNumber());
		bean.setEmployeeNumber(getEmployeeNumber());
		bean.setLogin(getLogin());
		bean.setPwdLogin(getPasswordLogin());
		bean.setProfil(getProfil());
		bean.setDateCrea(getDateCrea());
		bean.setDateMAJ(getDateMAJ());

		return bean;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[LoginsDTO]\n").append("customer_number : ").append(this.getCustomerNumber()).append(", \n")
				.append("employee_number : ").append(this.getEmployeeNumber()).append(", \n").append("login : ")
				.append(this.getLogin()).append(", \n").append("password_login : ").append(this.getPasswordLogin())
				.append(", \n").append("Profil_login :").append(this.getProfil()).append(", \n")
				.append("Date de création :").append(this.getDateCrea()).append(", \n").append("Date de MAJ :")
				.append(this.getDateMAJ());

		return sb.toString();

	}

	public long getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		CustomerNumber = customerNumber;
	}

	public int getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		EmployeeNumber = employeeNumber;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPasswordLogin() {
		return PasswordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		PasswordLogin = passwordLogin;
	}

	public void setProfil(int profil) {
		Profil = profil;
	}

	public int getProfil() {
		// TODO Auto-generated method stub
		return Profil;
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

package com.classicModels.DTO;



import com.classicModels.beans.LoginsBean;

public class LoginsDTO extends AbstractDTO{
	
	// Correspondent en tous point aux champs de la table classicmodels.Logins

	private long CustomerNumber ;
	private int EmployeeNumber;
	private String Login;
	private String PasswordLogin;
	private int Profil;
	
	public  LoginsDTO() {clear();}
	
	public LoginsDTO(LoginsBean bean) {
		
			this.CustomerNumber=bean.getCustomerNumber();
			this.EmployeeNumber=bean.getEmployeeNumber();
			this.Login=bean.getLogin();
			this.PasswordLogin=bean.getPwdLogin();
			this.Profil=bean.getProfil();
			
		}
		
	public void clear() {
			
			this.CustomerNumber=0;
			this.EmployeeNumber=0;
			this.Login="";
			this.PasswordLogin="";
			this.Profil=0;
			
		}
		
	public LoginsBean getBean() {
		
			LoginsBean bean = new LoginsBean();
			
			bean.setCustomerNumber(getCustomerNumber());
			bean.setEmployeeNumber(getEmployeeNumber());
			bean.setLogin(getLogin());
			bean.setPwdLogin(getPasswordLogin());
			bean.setProfil(getProfil());
					
			return bean;
			
		}
	
	public String toString() {
		StringBuilder sb =new StringBuilder();
			sb.append("[LoginsDTO]\n")
				.append("customer_number : ").append(this.getCustomerNumber()).append(", \n")
				.append("employee_number : ").append(this.getEmployeeNumber()).append(", \n")
				.append("login : ").append(this.getLogin()).append(", \n")
				.append("password_login : ").append(this.getPasswordLogin()).append(", \n")
				.append("Profil_login :").append(this.getProfil());
				
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
		Profil=profil;
	}

	public int getProfil() {
		// TODO Auto-generated method stub
		return Profil;
	}	
	
}

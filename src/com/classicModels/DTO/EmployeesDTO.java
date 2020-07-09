package com.classicModels.DTO;

import com.classicModels.beans.EmployeesBean;

public class EmployeesDTO extends AbstractDTO{
	
	// Correspondent en tous point aux champs de la table classicmodels.employees
	
		private long EmployeeNumber;
		private String LastName;
		private String FirstName;
		private String Extension;
		private String Email;
		private int OfficeCode;
		private int ReportsTo ;
		private String JobTitle;
		
public EmployeesDTO() {clear();}
		
public EmployeesDTO(EmployeesBean bean) {
		
			this.EmployeeNumber=bean.getEmployeeNumber();
			this.LastName=bean.getLastName();
			this.FirstName=bean.getFirstName();
			this.Extension=bean.getExtension();
			this.Email=bean.getEmail();
			this.OfficeCode=bean.getOfficeCode();
			this.ReportsTo=bean.getReportsTo();
			this.JobTitle=bean.getJobTitle();
		}
		
public void clear() {
			
			this.EmployeeNumber=0;
			this.LastName="";
			this.FirstName="";
			this.Extension="";
			this.Email="";
			this.OfficeCode=0;
			this.ReportsTo=0;
			this.JobTitle="";
		}
		
public EmployeesBean getBean() {
		
			EmployeesBean bean = new EmployeesBean();
		
			bean.setEmployeeNumber(getEmployeeNumber());
			bean.setLastName(getLastName());
			bean.setFirstName(getFirstName());
			bean.setExtension(getExtension());
			bean.setEmail(getEmail());
			bean.setOfficeCode(getOfficeCode());
			bean.setReportsTo(getReportsTo());
			bean.setJobTitle(getJobTitle());
			
			return bean;
			
		}

public String toString() {
	StringBuilder sb =new StringBuilder();
		sb.append("[EmployeesDTO]\n")
			.append("employeeNumber : ").append(this.getEmployeeNumber()).append(", \n")
			.append("lastName : ").append(this.getLastName()).append(", ")
			.append("firstName : ").append(this.getFirstName()).append(", \n")
			.append("extension : ").append(this.getExtension()).append(", \n")
			.append("eMail : ").append(this.getEmail()).append(", \n")
			.append("officeCode : ").append(this.getOfficeCode()).append(", \n")
			.append("reportsTo : ").append(this.getReportsTo()).append(", \n")
			.append("jobTitle: ").append(this.getJobTitle()).append(", \n");
			
		return sb.toString();
					
					
}

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

public String getFirstName() {
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

public int getOfficeCode() {
	return OfficeCode;
}

public void setOfficeCode(int officeCode) {
	OfficeCode = officeCode;
}

public int getReportsTo() {
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

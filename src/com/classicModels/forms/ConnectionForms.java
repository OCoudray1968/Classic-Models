package com.classicModels.forms;

import javax.servlet.http.HttpServletRequest;


import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;

public class ConnectionForms {
	private String resultat ;
	private long number;
	private Integer profil;
	
	@SuppressWarnings("unused")
	public void verificationLogin (HttpServletRequest request) {
		
		String login =request.getParameter("utilisateur");
		String pwd = request.getParameter("password");
			 
    	LoginsDTO user = ManagerFactory.getlogins();
    	user.setLogin(login);
    	user.setPasswordLogin(pwd);
    	user=(LoginsDTO) LoginsManager.getRecord(user);
    	
    	System.out.println("le profil est :"+user);
     if (user != null) {
    	 profil=user.getProfil();
                        
            if(user.getCustomerNumber()!=0) {
            	number=user.getCustomerNumber();
            	
            	resultat="customer";
            }
            else {
            	 if(user.getEmployeeNumber()!=0) {
            		
            		number=user.getEmployeeNumber(); 
            		switch (profil) {
            		case 1:
            			resultat="admin";
            		case 2:
            			resultat="employee";	
            		}
            	 }	
            	}
            }
     
     	else
           	{
     		resultat="Identifiants incorrects !!";}
           	}
		
		            	
	   

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	public Integer getProfil() {
		return profil;
	}

	public void setProfil(Integer profil) {
		this.profil = profil;
	}
	
}
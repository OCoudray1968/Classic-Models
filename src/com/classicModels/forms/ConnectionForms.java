package com.classicModels.forms;

import javax.servlet.http.HttpServletRequest;

import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.tools.HasherPassword;

public class ConnectionForms {
	private String resultat = "";
	private long number = 0;
	private Integer profil = 0;
	private String salt = "19680626";

	@SuppressWarnings("unused")
	public void verificationLogin(HttpServletRequest request) {

		String login = request.getParameter("utilisateur");
		String pwd = request.getParameter("password");
		System.out.println("Le login est:" + login);
		System.out.println("Le password est :" + pwd);

		LoginsDTO user = ManagerFactory.getlogins();
		// hashage du password
		HasherPassword hasher = new HasherPassword();
		hasher.getEncodedHash(pwd, salt, 16);
		String resultHash = hasher.encode(pwd, salt);
		user.setLogin(login);
		user.setPasswordLogin(resultHash);

		user = (LoginsDTO) LoginsManager.getRecord(user);
		if (user != null) {
			// test securité passsword
			if (hasher.checkPassword(pwd, user.getPasswordLogin())) {
				// user.setPasswordLogin(pwd);

				System.out.println("le profil est :" + user);

				if (user != null) {
					profil = user.getProfil();

					if (user.getCustomerNumber() != 0) {
						number = user.getCustomerNumber();

						resultat = "customer";
					} else {
						if (user.getEmployeeNumber() != 0) {

							number = user.getEmployeeNumber();
							switch (profil) {
							case 1:
								resultat = "admin";
							case 2:
								resultat = "employee";
							}
						}
					}
				}
			}
		} else {
			resultat = "Identifiants incorrects !!";
			System.out.println(resultat);
		}
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

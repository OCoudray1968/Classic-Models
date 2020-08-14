package com.classicModels.tests.testsUnitaires;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.tools.HasherPassword;

class LoginDAOTest {
	private String salt = "19680626";

	@Test
	void connectionTest() {
		// Test de connecction d'un utilisateur
		LoginsDTO user = ManagerFactory.getlogins();
		user.setLogin("OLIVIER");
		String pwd = "livi1968";

		HasherPassword hasher = new HasherPassword();
		hasher.getEncodedHash(pwd, salt, 16);
		String resultHash = hasher.encode(pwd, salt);
		user.setPasswordLogin(resultHash);
		user = (LoginsDTO) LoginsManager.getRecord(user);

		Assert.assertEquals(1, user.getProfil());
	}

	@Test
	public void createLoginTest() {

		LoginsDTO c = ManagerFactory.getlogins();

		// Creation d'un login
		c.setEmployeeNumber(1714);
		c.setCustomerNumber(0);
		c.setLogin("NATHALIE");
		String pwd = "MILLO";

		HasherPassword hasher = new HasherPassword();
		hasher.getEncodedHash(pwd, salt, 16);
		String resultHash = hasher.encode(pwd, salt);
		c.setPasswordLogin(resultHash);
		c.setProfil(1);
		c.setDateCrea(new Date());
		c.setDateMAJ(new Date());

		LoginsManager.setRecord(c);

		// Recherche d'un login
		long id = c.getEmployeeNumber();
		Assert.assertNotNull(id);
		LoginsDTO logins = (LoginsDTO) LoginsManager.getRecord(c);

		Assert.assertEquals(1714, logins.getEmployeeNumber());
		Assert.assertEquals("NATHALIE", logins.getLogin());
		return;
	}

	@Test
	public void updateLoginTest() {

		// MAJ d'un login
		LoginsDTO c = ManagerFactory.getlogins();

		c.setLogin("OLIVIER");
		String pwd = "livi1968";

		HasherPassword hasher = new HasherPassword();
		hasher.getEncodedHash(pwd, salt, 16);
		String resultHash = hasher.encode(pwd, salt);
		c.setPasswordLogin(resultHash);
		LoginsDTO login = (LoginsDTO) LoginsManager.getRecord(c);
		LoginsDTO c2 = ManagerFactory.getlogins();
		c2.setProfil(1);
		LoginsManager.update(login, c2);
		LoginsDTO logins = (LoginsDTO) LoginsManager.getRecord(c);
		Assert.assertEquals(1713, logins.getEmployeeNumber());

		return;
	}

	@Test
	public void deleteTest() {

		LoginsDTO c = ManagerFactory.getlogins();
		c.setEmployeeNumber(1714);
		LoginsManager.delRecord(c);

		return;

	}

}

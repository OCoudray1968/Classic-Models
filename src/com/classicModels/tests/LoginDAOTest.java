package com.classicModels.tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;

class LoginDAOTest {

	@Test
	void connectionTest() {

		LoginsDTO user = ManagerFactory.getlogins();
		user.setLogin("OLIVIER");
		user.setPasswordLogin("livi1968");
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
		c.setPasswordLogin("MILLO");
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
		c.setPasswordLogin("livi1968");
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

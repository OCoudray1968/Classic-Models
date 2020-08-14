package com.classicModels.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.RegistrationDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.RegistrationManager;

class RegistrationDAOTest {

	@Test
	public void createTest() {

		RegistrationDTO c = ManagerFactory.getRegistration();

		// Creation d'un client
		c.setCustomerNumber(498);
		c.setCustomerName("Castorama");
		c.setContactLastName("Leroy");
		c.setContactFirstName("Merlin");
		c.setPhone("0401010101");
		c.setAddressLine1("244 route de Turin");
		c.setCity("Nice");
		c.setPostalCode("06300");
		c.setCountry("France");
		c.setEmail("MLeroy@Castorama.fr");
		c.setLogin("MERLIN");
		c.setPwd("LEROY");
		RegistrationManager.setRecord(c);
		long id = c.getCustomerNumber();
		Assert.assertNotNull(id);
		RegistrationDTO c2 = ManagerFactory.getRegistration();
		c2.setCustomerNumber(498);
		RegistrationDTO clients = (RegistrationDTO) RegistrationManager.getRecord(c2);
		// Recherche d'un prospect

		Assert.assertEquals("Leroy", clients.getContactLastName());
		Assert.assertEquals("Merlin", clients.getContactFirstName());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un client
		RegistrationDTO c = ManagerFactory.getRegistration();
		c.setCustomerNumber(497);
		RegistrationDTO client = (RegistrationDTO) RegistrationManager.getRecord(c);
		System.out.println(client);
		RegistrationDTO c2 = ManagerFactory.getRegistration();
		c2.setEmail("Mleroy@castorama.fr");
		c2.setLogin("MERLIN");
		c2.setPwd("LEROY");
		RegistrationManager.update(client, c2);
		RegistrationDTO clients = (RegistrationDTO) RegistrationManager.getRecord(c);
		Assert.assertEquals("MERLIN", clients.getLogin());
		Assert.assertEquals("LEROY", clients.getPwd());

	}

	@Test
	public void deleteTest() {

		RegistrationDTO c = ManagerFactory.getRegistration();
		c.setCustomerNumber(498);
		RegistrationManager.delRecord(c);

		return;

	}

}

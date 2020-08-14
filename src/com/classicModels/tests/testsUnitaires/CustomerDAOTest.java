package com.classicModels.tests;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;

class CustomerDAOTest {
	@Tag("CRUD")
	@DisplayName("Test du CRUD de Customer")
	@Test
	public void createTest() {

		CustomersDTO c = ManagerFactory.getCustomers();

		// Creation d'un client
		c.setCustomerNumber(11);
		c.setCustomerName("Mc Queen");
		c.setContactLastName("Dupond");
		c.setContactFirstName("Marc");
		c.setPhone("0401010101");
		c.setAddressLine1("244 route de Turin");
		c.setCity("Nice");
		c.setPostalCode("06300");
		c.setCountry("France");
		c.setSalesRepEmployeeNumber(1705);
		c.setCreditLimit(21000.00);
		c.setEmail("MDupont@MCQueen.fr");
		CustomersManager.setRecord(c);
		long id = c.getCustomerNumber();
		Assert.assertNotNull(id);
		CustomersDTO clients = (CustomersDTO) CustomersManager.getRecord(c);
		// Recherche d'un client

		Assert.assertEquals(11, clients.getCustomerNumber());
		Assert.assertEquals("Dupond", clients.getContactLastName());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un client
		CustomersDTO c = ManagerFactory.getCustomers();
		c.setCustomerNumber(103);
		CustomersDTO client = (CustomersDTO) CustomersManager.getRecord(c);
		System.out.println(client);
		CustomersDTO c2 = ManagerFactory.getCustomers();
		c2.setCreditLimit(42000.00);
		c2.setEmail("CSchmitt@atelierGraphique.fr");
		CustomersManager.update(client, c2);
		CustomersDTO clients = (CustomersDTO) CustomersManager.getRecord(c);
		Assert.assertEquals(103, clients.getCustomerNumber());
		Assert.assertEquals(42000.00, clients.getCreditLimit(), 0);

	}

	@Test
	public void deleteTest() {

		CustomersDTO c = ManagerFactory.getCustomers();
		c.setCustomerNumber(11);
		CustomersManager.delRecord(c);

		return;

	}

}

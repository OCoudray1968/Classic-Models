package com.classicModels.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;

class iDAOTest {
	/**
	 * @Test public void testgenerateINSERTquery() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testgenerateUPDATEquery() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testgenerateLASTquery() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testgenerateDeletequery() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testgenerateUnionQuery() { fail("Not yet implemented"); }
	 * 
	 * 
	 * @Test public void testmakeListOrdersInProcess() { fail("Not yet
	 *       implemented"); }
	 * 
	 **/
	@Test
	public void testsetRecord() {
		/**
		 * CustomersDTO client = new CustomersDTO(); client.setCustomerNumber(103);
		 * client.setCustomerName("Atelier graphique");
		 * client.setContactLastName("Schmitt"); client.setContactFirstName("Carine");
		 * client.setPhone("40.32.2555"); client.setAddressLine1("54, rue Royale");
		 * client.setAddressLine2(""); client.setCity("Nantes"); client.setState("");
		 * client.setPostalCode("44000"); client.setCountry("France");
		 * client.setSalesRepEmployeeNumber(1370); client.setCreditLimit(21000.00);
		 * 
		 * CustomersDTO clientTest = new CustomersDTO();
		 **/
		CustomersDTO c = ManagerFactory.getCustomers();

		/**
		 * Affichage de tous les clients List<AbstractDTO> l =
		 * CustomersManager.listAll();
		 * System.out.println("-------------------------------" + l.size()); for
		 * (AbstractDTO dto : l) System.out.println(dto.toString());
		 **/
		// Creation d'un client
		c.setCustomerNumber(11);
		c.setCustomerName("Mc Queen");
		c.setContactLastName("Dupont");
		c.setContactFirstName("Marc");
		c.setPhone("0401010101");
		c.setAddressLine1("244 route de Turin");
		c.setCity("Nice");
		c.setPostalCode("06300");
		c.setCountry("France");
		c.setSalesRepEmployeeNumber(1705);
		c.setCreditLimit(100.0);
		c.setEmail("DMcQueen@classicModels.fr");
		CustomersManager.setRecord(c);
		long id = c.getCustomerNumber();
		Assert.assertNotNull(id);
		CustomersDTO clients = (CustomersDTO) CustomersManager.getRecord(c);
		// Recherche d'un client

		Assert.assertEquals(11, clients.getCustomerNumber());
		Assert.assertEquals("Dupont", clients.getContactLastName());
		return;
	}

}

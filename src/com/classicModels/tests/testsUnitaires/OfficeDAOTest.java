package com.classicModels.tests.testsUnitaires;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.OfficesDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OfficesManager;

class OfficeDAOTest {

	@Test
	public void createTest() {

		OfficesDTO c = ManagerFactory.getOffices();

		// Creation d'un client
		c.setOfficeCode(9);
		;
		c.setCity("Nice");
		c.setPhoneOffice("+33 4 90 12 27 68");
		c.setAddressLine1("244 route de turin");
		c.setAddressLine2("");
		c.setStateOffice("");
		c.setCountryOffice("France");
		c.setPostalCode("06160");
		c.setTerritory("EMEA");
		OfficesManager.setRecord(c);
		long id = c.getOfficeCode();
		Assert.assertNotNull(id);
		OfficesDTO office = (OfficesDTO) OfficesManager.getRecord(c);
		// Recherche d'un client

		Assert.assertEquals(9, office.getOfficeCode());
		Assert.assertEquals("Nice", office.getCity());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un client
		OfficesDTO c = ManagerFactory.getOffices();
		c.setOfficeCode(0);
		;
		OfficesDTO office = (OfficesDTO) OfficesManager.getRecord(c);
		System.out.println(office);
		OfficesDTO c2 = ManagerFactory.getOffices();
		c2.setAddressLine2("bat A");
		c2.setStateOffice("Alpes Maritime");
		OfficesManager.update(office, c2);
		OfficesDTO offices = (OfficesDTO) OfficesManager.getRecord(c);
		Assert.assertEquals("bat A", offices.getAddressLine2());
		Assert.assertEquals("Alpes Maritime", offices.getStateOffice());

		return;
	}

	@Test
	public void deleteTest() {

		OfficesDTO c = ManagerFactory.getOffices();
		c.setOfficeCode(9);
		OfficesManager.delRecord(c);

		return;

	}

}

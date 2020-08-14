package com.classicModels.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.managers.EmployeesManager;
import com.classicModels.managers.ManagerFactory;

class EmployeeDAOTest {

	@Test
	public void createTest() {

		EmployeesDTO c = ManagerFactory.GetEmployees();

		// Creation d'un client
		c.setEmployeeNumber(1000);
		c.setFirstName("Nathalie");
		c.setLastName("Millo");
		c.setExtension("X2509");
		c.setEmail("nmillo@classicModelcars.com");
		c.setOfficeCode(0);
		c.setReportsTo(1713);
		c.setJobTitle("IS Assistant");

		EmployeesManager.setRecord(c);
		long id = c.getEmployeeNumber();
		Assert.assertNotNull(id);
		EmployeesDTO employes = (EmployeesDTO) EmployeesManager.getRecord(c);
		// Recherche d'un client

		Assert.assertEquals(1000, employes.getEmployeeNumber());
		Assert.assertEquals("Millo", employes.getLastName());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un client
		EmployeesDTO c = ManagerFactory.GetEmployees();
		c.setEmployeeNumber(1713);
		EmployeesDTO employe = (EmployeesDTO) EmployeesManager.getRecord(c);
		System.out.println(employe);
		EmployeesDTO c2 = ManagerFactory.GetEmployees();
		c2.setExtension("X2606");
		c2.setEmail("ocoudray@classicmodelscars.com");
		EmployeesManager.update(employe, c2);
		EmployeesDTO employes = (EmployeesDTO) EmployeesManager.getRecord(c);
		Assert.assertEquals(1713, employes.getEmployeeNumber());
		Assert.assertEquals("X2606", employes.getExtension());

		return;
	}

	@Test
	public void deleteTest() {

		EmployeesDTO c = ManagerFactory.GetEmployees();
		c.setEmployeeNumber(1000);
		EmployeesManager.delRecord(c);

		return;

	}

}

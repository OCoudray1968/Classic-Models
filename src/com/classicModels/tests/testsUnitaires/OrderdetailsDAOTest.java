package com.classicModels.tests.testsUnitaires;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OrderDetailsManager;

class OrderdetailsDAOTest {

	@Test
	public void createTest() {

		OrderDetailsDTO c = ManagerFactory.getOrderDetails();

		// Creation d'un client
		c.setOrderNumber(10430);
		c.setProductCode("S10_1949");
		c.setQuantityOrdered(5);
		c.setPriceEach(214.30);
		c.setOrderLineNumber(1);

		OrderDetailsManager.setRecord(c);
		long id = c.getOrderNumber();
		Assert.assertNotNull(id);
		OrderDetailsDTO orderdetail = (OrderDetailsDTO) OrderDetailsManager.getRecord(c);
		// Recherche d'un client

		Assert.assertEquals(214.30, orderdetail.getPriceEach(), 0);
		Assert.assertEquals("S10_1949", orderdetail.getProductCode());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un client
		OrderDetailsDTO c = ManagerFactory.getOrderDetails();
		c.setOrderNumber(10429);
		c.setOrderLineNumber(1);
		OrderDetailsDTO commande = (OrderDetailsDTO) OrderDetailsManager.getRecord(c);
		System.out.println(commande);
		OrderDetailsDTO c2 = ManagerFactory.getOrderDetails();
		c2.setProductCode("S24_3969");
		c2.setPriceEach(35.29);
		OrderDetailsManager.update(commande, c2);
		OrderDetailsDTO commandes = (OrderDetailsDTO) OrderDetailsManager.getRecord(c);
		Assert.assertEquals("S24_3969", commandes.getProductCode());
		Assert.assertEquals(35.29, commandes.getPriceEach(), 0);

	}

	@Test
	public void deleteTest() {

		OrderDetailsDTO c = ManagerFactory.getOrderDetails();
		c.setOrderNumber(10430);
		c.setOrderLineNumber(1);
		OrderDetailsManager.delRecord(c);

		return;

	}

}

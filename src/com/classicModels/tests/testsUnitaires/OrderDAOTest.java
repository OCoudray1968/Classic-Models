package com.classicModels.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.OrdersDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OrdersManager;
import com.classicModels.tools.DateUtils;

class OrderDAOTest {

	@SuppressWarnings("static-access")
	@Test
	public void createTest() throws ParseException {

		Date dateCommande;
		Date dateDemande = new Date();

		OrdersDTO c = ManagerFactory.getOrders();

		DateUtils dateUtils = new DateUtils();
		dateCommande = dateUtils.toSQLDate(LocalDate.now());
		String dateDem = "2020-07-25";

		if (dateDem != null) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			dateDemande = sdf.parse(dateDem);
			dateDemande = dateUtils.toSQLDate(dateDemande);

		}

		// Creation d'un client
		c.setOrderNumber(10431);
		c.setOrderDate(dateCommande);
		c.setRequiredDate(dateDemande);
		c.setShippedDate(dateDemande);
		c.setStatusOrder("In process");
		c.setComments("Test commande");
		c.setCustomerNumber(121);
		OrdersManager.setRecord(c);
		long id = c.getOrderNumber();
		Assert.assertNotNull(id);
		OrdersDTO commande = (OrdersDTO) OrdersManager.getRecord(c);
		// Recherche d'une commande

		Assert.assertEquals(10431, commande.getOrderNumber());
		Assert.assertEquals(121, commande.getCustomerNumber());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'une commande
		OrdersDTO c = ManagerFactory.getOrders();
		c.setOrderNumber(10426);
		OrdersDTO commande = (OrdersDTO) OrdersManager.getRecord(c);
		System.out.println(commande);
		OrdersDTO c2 = ManagerFactory.getOrders();
		c2.setOrderDate(commande.getOrderDate());
		c2.setRequiredDate(commande.getRequiredDate());
		c2.setShippedDate(commande.getShippedDate());
		c2.setCustomerNumber(121);
		c2.setStatusOrder("In process");
		c2.setComments("Problème de transport");
		System.out.println(c2);
		OrdersManager.update(commande, c2);
		OrdersDTO commandes = (OrdersDTO) OrdersManager.getRecord(c);
		Assert.assertEquals("In process", commandes.getStatusOrder());
		Assert.assertEquals("Problème de transport", commandes.getComments());

	}

	@Test
	public void deleteTest() {

		OrdersDTO c = ManagerFactory.getOrders();
		c.setOrderNumber(10431);
		OrdersManager.delRecord(c);

		return;

	}

}

package com.classicModels.tests;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.PaymentsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.PaymentsManager;
import com.classicModels.tools.DateUtils;

class PaymentsDAOTest {

	@Test
	public void createTest() {
		Date datePayment;

		datePayment = DateUtils.toSQLDate(LocalDate.now());

		PaymentsDTO c = ManagerFactory.getPayments();

		// Creation d'un paiement

		c.setCustomerNumber(496);
		c.setCheckNumber("ZH260668");
		c.setPaymentDate(datePayment);
		c.setAmountPayment(2333.45);

		PaymentsManager.setRecord(c);
		long id = c.getCustomerNumber();
		Assert.assertNotNull(id);
		PaymentsDTO office = (PaymentsDTO) PaymentsManager.getRecord(c);
		// Recherche d'un paiement

		Assert.assertEquals("ZH260668", office.getCheckNumber());
		Assert.assertEquals(2333.45, office.getAmountPayment(), 0);
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un payment

		Date dateMAJPayment;

		dateMAJPayment = DateUtils.toSQLDate(LocalDate.now());

		PaymentsDTO c = ManagerFactory.getPayments();
		c.setCustomerNumber(496);
		c.setCheckNumber("OC260668");

		PaymentsDTO payment = (PaymentsDTO) PaymentsManager.getRecord(c);
		System.out.println(payment);
		PaymentsDTO c2 = ManagerFactory.getPayments();
		c2.setAmountPayment(6833.45);
		c2.setPaymentDate(dateMAJPayment);
		PaymentsManager.update(payment, c2);
		PaymentsDTO payments = (PaymentsDTO) PaymentsManager.getRecord(c);
		Assert.assertEquals(6833.45, payments.getAmountPayment(), 0);

		return;
	}

	@Test
	public void deleteTest() {

		PaymentsDTO c = ManagerFactory.getPayments();
		c.setCustomerNumber(496);
		c.setCheckNumber("ZH260668");
		PaymentsManager.delRecord(c);

		return;

	}

}

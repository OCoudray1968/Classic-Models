package com.classicModels.bdd;

import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.CustomersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;

public class BDTest {

	public static void main(String[] args) {

		CustomersDTO c = ManagerFactory.getCustomers();

		// Affichage de tous les clients
		List<AbstractDTO> l = CustomersManager.listAll();
		System.out.println("-------------------------------" + l.size());
		for (AbstractDTO dto : l)
			System.out.println(dto.toString());

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

		// Recherche d'un client
		c.setCustomerNumber(11);
		System.out.println(CustomersManager.getRecord(c).toString());

		// MAJ d'un client
		CustomersDTO c2 = ManagerFactory.getCustomers();
		c2.setCreditLimit(0);
		CustomersManager.update(c2, c);

		// Recherche d'un client
		c.setCustomerNumber(11);
		System.out.println(CustomersManager.getRecord(c).toString());

		Connexion.closeConnection();
	}

}

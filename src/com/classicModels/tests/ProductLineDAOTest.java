package com.classicModels.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.ProductLinesDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductLinesManager;

class ProductLineDAOTest {

	@Test
	public void createTest() {

		ProductLinesDTO c = ManagerFactory.getproductsline();

		// Creation d'une ligne de produit
		c.setProductLine("Boat");
		c.setTextDescription("ligne fictive pour les tests");
		;
		c.setHtmlDescription("");
		c.setImage("");

		ProductLinesManager.setRecord(c);
		String id = c.getProductLine();
		Assert.assertNotNull(id);
		ProductLinesDTO ligne = (ProductLinesDTO) ProductLinesManager.getRecord(c);
		// Recherche d'un client

		Assert.assertEquals("Boat", ligne.getProductLine());
		Assert.assertEquals("ligne fictive pour les tests", ligne.getTextDescription());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un client
		ProductLinesDTO c = ManagerFactory.getproductsline();
		c.setProductLine("Planes");
		ProductLinesDTO ligne = (ProductLinesDTO) ProductLinesManager.getRecord(c);
		System.out.println(ligne);
		ProductLinesDTO c2 = ManagerFactory.getproductsline();
		c2.setTextDescription("Unique, diecast airplane and helicopter replicas suitable for collections");
		ProductLinesManager.update(ligne, c2);
		ProductLinesDTO lignes = (ProductLinesDTO) ProductLinesManager.getRecord(c);
		Assert.assertEquals("Unique, diecast airplane and helicopter replicas suitable for collections",
				lignes.getTextDescription());

		return;
	}

	@Test
	public void deleteTest() {

		ProductLinesDTO c = ManagerFactory.getproductsline();
		c.setProductLine("Boat");
		ProductLinesManager.delRecord(c);

		return;

	}

}

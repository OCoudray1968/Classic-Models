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
		Assert.assertEquals("Aligne fictive pour les tests", ligne.getTextDescription());
		return;
	}

//	@Test
//	public void updateTest() {
//
//		// MAJ d'un client
//		ProductsDTO c = ManagerFactory.getProducts();
//		c.setProductCode("S10_1678");
//		ProductsDTO produit = (ProductsDTO) ProductsManager.getRecord(c);
//		System.out.println(produit);
//		ProductsDTO c2 = ManagerFactory.getProducts();
//		c2.setProductScale("1:10");
//		c2.setQuantityInStock(550);
//		ProductsManager.update(produit, c2);
//		ProductsDTO produits = (ProductsDTO) ProductsManager.getRecord(c);
//		Assert.assertEquals(550, produits.getQuantityInStock());
//		Assert.assertEquals("1:10", produits.getProductScale());
//
//		return;
//	}
//
//	@Test
//	public void deleteTest() {
//
//		ProductsDTO c = ManagerFactory.getProducts();
//		c.setProductCode("S73_3313");
//		ProductsManager.delRecord(c);
//
//		return;
//
//	}

}

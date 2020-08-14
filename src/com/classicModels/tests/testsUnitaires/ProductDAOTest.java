package com.classicModels.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductsManager;

class ProductDAOTest {

	@Test
	public void createTest() {

		ProductsDTO c = ManagerFactory.getProducts();

		// Creation d'un produit
		c.setProductCode("S73_3313");
		c.setProductName("Aston Martin 1955");
		c.setProductLine("Classic Cars");
		c.setProductScale("1:50");
		c.setProductVendor("Classic Metal Creations");
		c.setProductDescription("belle voiture très soignée et détaillée");
		c.setQuantityInStock(500);
		c.setBuyPrice(72.99);
		c.setMsrp(115.75);

		ProductsManager.setRecord(c);
		String id = c.getProductCode();
		Assert.assertNotNull(id);
		ProductsDTO produits = (ProductsDTO) ProductsManager.getRecord(c);
		// Recherche d'un produit

		Assert.assertEquals("S73_3313", produits.getProductCode());
		Assert.assertEquals("Aston Martin 1955", produits.getProductName());
		return;
	}

	@Test
	public void updateTest() {

		// MAJ d'un produit
		ProductsDTO c = ManagerFactory.getProducts();
		c.setProductCode("S10_1678");
		ProductsDTO produit = (ProductsDTO) ProductsManager.getRecord(c);
		System.out.println(produit);
		ProductsDTO c2 = ManagerFactory.getProducts();
		c2.setProductScale("1:10");
		c2.setQuantityInStock(550);
		ProductsManager.update(produit, c2);
		ProductsDTO produits = (ProductsDTO) ProductsManager.getRecord(c);
		Assert.assertEquals(550, produits.getQuantityInStock());
		Assert.assertEquals("1:10", produits.getProductScale());

		return;
	}

	@Test
	public void deleteTest() {
		// suppression d'un produit
		ProductsDTO c = ManagerFactory.getProducts();
		c.setProductCode("S73_3313");
		ProductsManager.delRecord(c);

		return;

	}

}

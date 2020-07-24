package com.classicModels.managers;

import java.util.List;

import com.classicModels.DAO.ProductlinesDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.ProductLinesDTO;

public class ProductLinesManager {

	public static void update(AbstractDTO source, AbstractDTO cible) {

		ProductLinesDTO dtoSource = (ProductLinesDTO) source;
		ProductLinesDTO dtoCible = (ProductLinesDTO) cible;

		dtoCible.setProductLine(dtoSource.getProductLine());

		if (dtoCible.getTextDescription().isEmpty())
			dtoCible.setTextDescription(dtoSource.getTextDescription());

		if (dtoCible.getHtmlDescription().isEmpty())
			dtoCible.setHtmlDescription(dtoSource.getHtmlDescription());

		if (dtoCible.getImage().isEmpty())
			dtoCible.setImage(dtoSource.getImage());

		ProductlinesDAO product = new ProductlinesDAO();

		product.update(dtoCible);
	}

	/**
	 * Retourne une liste de DTOs correspondant à la liste des enregistrements
	 * présent dans la table <code>classicmodels.Customers</code>.
	 * 
	 */
	public static List<AbstractDTO> listAll() {
		ProductlinesDAO product = new ProductlinesDAO();
		return product.listAll(new ProductLinesDTO());
	}

	/**
	 * Retourne un seul enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public static AbstractDTO getRecord(AbstractDTO bean) {
		ProductlinesDAO product = new ProductlinesDAO();
		List<AbstractDTO> l = product.listAll(bean);
		return l.get(0);
	}

	/**
	 * Insère un enregistrement
	 * 
	 * @param bean
	 */
	public static void setRecord(AbstractDTO bean) {
		ProductlinesDAO product = new ProductlinesDAO();
		product.create(bean);
	}

	/**
	 * supprime un enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public static void delRecord(AbstractDTO bean) {
		ProductlinesDAO produit = new ProductlinesDAO();
		produit.delete(bean);

	}

}

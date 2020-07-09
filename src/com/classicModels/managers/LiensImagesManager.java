package com.classicModels.managers;


import java.util.List;

import com.classicModels.DAO.LiensImagesDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.LiensImageDTO;

public class LiensImagesManager  {
	 public void update(AbstractDTO source, AbstractDTO cible) {
	LiensImageDTO dtoSource = (LiensImageDTO)source;
	LiensImageDTO dtoCible = (LiensImageDTO)cible;

	dtoCible.setCustomerNumber(dtoSource.getCustomerNumber());
	
	
	
	if (dtoCible.getEmployeeNumber()==0)
	    dtoCible.setEmployeeNumber(dtoSource.getEmployeeNumber());

	if (dtoCible.getProductCode().isEmpty())
	    dtoCible.setProductCode(dtoSource.getProductCode());

	if (dtoCible.getIdImage()==0)
	    dtoCible.setIdImage(dtoSource.getIdImage());

	

	LiensImagesDAO liensImage = new LiensImagesDAO();	
	liensImage.update(dtoCible);
}
	 /**
	     * Retourne une liste de DTOs correspondant à la liste des enregistrements présent dans la table <code>classicmodels.Customers</code>.
	     * 
	     */
	    public static List<AbstractDTO> listAll() {
	    	LiensImagesDAO liensImage = new LiensImagesDAO();
	    	return liensImage.listAll(new LiensImageDTO());
	    }


		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			LiensImagesDAO lienImage = new LiensImagesDAO(); 
			List <AbstractDTO>l = lienImage.listAll(bean);
			return l.get(0);
		}
		
		/*
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			LiensImagesDAO lienImage = new LiensImagesDAO();
			lienImage.create(bean);
		}	
}

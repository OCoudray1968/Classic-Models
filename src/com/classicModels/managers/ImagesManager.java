package com.classicModels.managers;

import java.util.List;

import com.classicModels.DAO.ImageDAO;
import com.classicModels.DTO.AbstractDTO;

import com.classicModels.DTO.ImagesDTO;


public class ImagesManager  {
	 public void update(AbstractDTO source, AbstractDTO cible) {

	    	ImagesDTO dtoSource = (ImagesDTO)source;
	    	ImagesDTO dtoCible = (ImagesDTO)cible;

			dtoCible.setIdImage(dtoSource.getIdImage());
			
			
			
			if (dtoCible.getNomImage().isEmpty())
			    dtoCible.setNomImage(dtoSource.getNomImage());
		
			if (dtoCible.getLabelImage().isEmpty())
			    dtoCible.setLabelImage(dtoSource.getLabelImage());
		
			if (dtoCible.getTagsImage().isEmpty())
			    dtoCible.setTagsImage(dtoSource.getTagsImage());
		
			

			ImageDAO image = new ImageDAO();	
			image.update(dtoCible);
	    }

	   

	    /**
	     * Retourne une liste de DTOs correspondant � la liste des enregistrements pr�sent dans la table <code>classicmodels.image</code>.
	     * @see com.bd.manager.InterfaceManager#listAll(Object bean)
	     */
	 public static List<AbstractDTO> listAll() {
	    	ImageDAO image = new ImageDAO();
	    	return image.listAll(new ImagesDTO());
	    }


		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			ImageDAO image = new ImageDAO(); 
			List <AbstractDTO>l = image.listAll(bean);
			return l.get(0);
		}
		
		/**
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			ImageDAO image = new ImageDAO();
			image.create(bean);
		}
		



}

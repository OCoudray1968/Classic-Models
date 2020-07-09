package com.classicModels.managers;


import java.util.List;
import com.classicModels.DAO.OfficesDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.OfficesDTO;


public class OfficesManager  {
	
	 public static void update(AbstractDTO source, AbstractDTO cible) {

	    	OfficesDTO dtoSource = (OfficesDTO)source;
	    	OfficesDTO dtoCible = (OfficesDTO)cible;

			dtoCible.setOfficeCode(dtoSource.getOfficeCode());
			
			
			
			if (dtoCible.getCity().isEmpty())
			    dtoCible.setCity(dtoSource.getCity());
		
			if (dtoCible.getPhoneOffice().isEmpty())
			    dtoCible.setPhoneOffice(dtoSource.getPhoneOffice());
		
			if (dtoCible.getAddressLine1().isEmpty())
			    dtoCible.setAddressLine1(dtoSource.getAddressLine1());
			
			if (dtoCible.getAddressLine2().isEmpty())
			    dtoCible.setAddressLine2(dtoSource.getAddressLine2());
		
			if (dtoCible.getStateOffice().isEmpty())
			    dtoCible.setStateOffice(dtoSource.getStateOffice());
		
			if (dtoCible.getCountryOffice().isEmpty())
			    dtoCible.setCountryOffice(dtoSource.getCountryOffice());
			
			if (dtoCible.getTerritory().isEmpty())
				dtoCible.setTerritory(dtoSource.getTerritory());
					
			OfficesDAO office = new OfficesDAO();	
			office.update(dtoCible);

	    }
	 /**
	     * Retourne une liste de DTOs correspondant à la liste des enregistrements présent dans la table <code>classicmodels.Customers</code>.
	     * 
	     */
	    public static List<AbstractDTO> listAll() {
	    	OfficesDAO office = new OfficesDAO();
	    	return office.listAll(new OfficesDTO());
	    }


		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			OfficesDAO office = new OfficesDAO(); 
			List <AbstractDTO>l = office.listAll(bean);
			return l.get(0);
		}
		/**
		 * Retourne le dernier enregistrement
		 * 		 * @param bean
		 * @return
		 */
		
		 public static AbstractDTO getLast(AbstractDTO bean) {
				OfficesDAO office = new OfficesDAO(); 
				List <AbstractDTO>l = office.listLast(bean);
				return l.get(0);
			}
		
		/*
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			OfficesDAO office = new OfficesDAO();
			office.create(bean);
		}	
		/**
		 * supprime un enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO delRecord(AbstractDTO bean) {
			OfficesDAO office = new OfficesDAO(); 
			List <AbstractDTO>l = office.delete(bean);
			return l.get(0);
		}
		
}

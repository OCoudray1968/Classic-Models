package com.classicModels.managers;


import java.util.List;


import com.classicModels.DAO.EmployeesDAO;
import com.classicModels.DTO.AbstractDTO;

import com.classicModels.DTO.EmployeesDTO;


public class EmployeesManager {
	 public static void update(AbstractDTO source, AbstractDTO cible) {

	    	EmployeesDTO dtoSource = (EmployeesDTO)source;
	    	EmployeesDTO dtoCible = (EmployeesDTO)cible;

			dtoCible.setEmployeeNumber(dtoSource.getEmployeeNumber());
					
			if (dtoCible.getLastName().isEmpty())
			    dtoCible.setLastName(dtoSource.getLastName());
		
			if (dtoCible.getFirstName().isEmpty())
			    dtoCible.setFirstName(dtoSource.getFirstName());
		
			if (dtoCible.getLastName().isEmpty())
			    dtoCible.setLastName(dtoSource.getLastName());
		
			if (dtoCible.getExtension().isEmpty())
			    dtoCible.setExtension(dtoSource.getExtension());
		
			if (dtoCible.getEmail().isEmpty())
			    dtoCible.setEmail(dtoSource.getEmail());
		
			if (dtoCible.getOfficeCode() == 0)
			    dtoCible.setOfficeCode(dtoSource.getOfficeCode());
		
			if (dtoCible.getReportsTo() == 0)
			    dtoCible.setReportsTo(dtoSource.getReportsTo());
				
			if (dtoCible.getJobTitle().isEmpty())
			    dtoCible.setJobTitle(dtoSource.getJobTitle());
		
			EmployeesDAO employee = new EmployeesDAO();	
			employee.update(dtoCible);
	    }

	    /**
	     * Retourne une liste de DTOs correspondant � la liste des enregistrements pr�sent dans la table <code>classicmodels.employees</code>.
	     * @see com.bd.manager.InterfaceManager#listAll(Object bean)
	     */
	 public static List<AbstractDTO> listAll() {
	    	EmployeesDAO employee = new EmployeesDAO();
	    	return employee.listAll(new EmployeesDTO());
	    }


		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			EmployeesDAO employee = new EmployeesDAO(); 
			List <AbstractDTO>l = employee.listAll(bean);
			return l.get(0);
		}
		
		 public static AbstractDTO getLast(AbstractDTO bean) {
				EmployeesDAO employee = new EmployeesDAO(); 
				List <AbstractDTO>l = employee.listLast(bean);
				return l.get(0);
			}
		 
		 /**
			 * supprime un enregistrement
			 * @param bean
			 * @return
			 */
			public static void delRecord(AbstractDTO bean) {
				EmployeesDAO employee = new EmployeesDAO(); 
				 employee.delete(bean);
				
			}
		
		/**
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			EmployeesDAO employee = new EmployeesDAO();
			employee.create(bean);
		}
		


}

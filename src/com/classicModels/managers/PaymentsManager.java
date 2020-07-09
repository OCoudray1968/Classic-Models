package com.classicModels.managers;


import java.util.List;


import com.classicModels.DAO.PaymentsDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.PaymentsDTO;


public class PaymentsManager{

	 public void update(AbstractDTO source, AbstractDTO cible) {

	    	PaymentsDTO dtoSource = (PaymentsDTO)source;
	    	PaymentsDTO dtoCible = (PaymentsDTO)cible;

			dtoCible.setCustomerNumber(dtoSource.getCustomerNumber());
			
			if (dtoCible.getCheckNumber().isEmpty())
			    dtoCible.setCheckNumber(dtoSource.getCheckNumber());
			
			if (dtoCible.getPaymentDate().equals(null))
			    dtoCible.setPaymentDate(dtoSource.getPaymentDate());
		
			if (dtoCible.getAmountPayment()==0.0)
			    dtoCible.setAmountPayment(dtoSource.getAmountPayment());
			
		
			PaymentsDAO payments = new PaymentsDAO();	
			payments.update(dtoCible);
	    }
	 /**
	     * Retourne une liste de DTOs correspondant à la liste des enregistrements présent dans la table <code>classicmodels.Customers</code>.
	     * 
	     */
	    public static List<AbstractDTO> listAll() {
	    	PaymentsDAO payments = new PaymentsDAO();
	    	return payments.listAll(new PaymentsDTO());
	    }


		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			PaymentsDAO payments = new PaymentsDAO(); 
			List <AbstractDTO>l = payments.listAll(bean);
			return l.get(0);
		}
		
		/*
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			PaymentsDAO payments = new PaymentsDAO();
			payments.create(bean);
		}	
}

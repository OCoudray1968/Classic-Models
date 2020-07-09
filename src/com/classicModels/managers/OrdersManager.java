package com.classicModels.managers;


import java.util.List;

import com.classicModels.DAO.OrdersDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.OrdersDTO;



public class OrdersManager  {

	 public static void update(AbstractDTO source, AbstractDTO cible) {

	    	OrdersDTO dtoSource = (OrdersDTO)source;
	    	OrdersDTO dtoCible = (OrdersDTO)cible;

			dtoCible.setOrderNumber(dtoSource.getOrderNumber());
			
			if (dtoCible.getOrderDate().equals(null))
			    dtoCible.setOrderDate(dtoSource.getOrderDate());
			
			if (dtoCible.getShippedDate().equals(null))
			    dtoCible.setShippedDate(dtoSource.getShippedDate());
		
			if (dtoCible.getStatusOrder().isEmpty())
			    dtoCible.setStatusOrder(dtoSource.getStatusOrder());
			
			if (dtoCible.getComments().isEmpty())
				dtoCible.setComments(dtoSource.getComments());
		
			


	    	OrdersDAO order = new OrdersDAO();	
			order.update(dtoCible);
	    }

	    /**
	     * Retourne une liste de DTOs correspondant à la liste des enregistrements présent dans la table <code>classicmodels.Orders</code>.
	     * 
	     */
	    public static List<AbstractDTO> listAll() {
	    	OrdersDAO order = new OrdersDAO();
	    	return order.listAll(new OrdersDTO());
	    }
	    /**
	     * retourne le dernier enregistrement de la liste
	     * @param bean
	     * @return
	     */
	    public static AbstractDTO getLast(AbstractDTO bean) {
			OrdersDAO order = new OrdersDAO(); 
			List <AbstractDTO>l = order.listLast(bean);
		
			return l.get(0);
		}

		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			OrdersDAO order = new OrdersDAO(); 
			List <AbstractDTO>l = order.listAll(bean);
			return l.get(0);
		}
		
		/**
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			OrdersDAO order = new OrdersDAO();
			order.create(bean);
		}

		public static List<AbstractDTO> listAll(OrdersDTO bean) {
			OrdersDAO order = new OrdersDAO(); 
			List <AbstractDTO>l = order.listAll(bean);
			return l;
		}

//		public static List<AbstractDTO> listAll(ProductsDTO produit) {
//			// TODO Auto-generated method stub
//			return null;
//		}

		

		
		


}

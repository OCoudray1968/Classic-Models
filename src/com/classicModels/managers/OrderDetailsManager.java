package com.classicModels.managers;

import java.util.List;

import com.classicModels.DAO.OrderDetailsDAO;
import com.classicModels.DAO.OrdersDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.OrdersDTO;



public class OrderDetailsManager {

	 public static void update(AbstractDTO source, AbstractDTO cible) {

	    	OrderDetailsDTO dtoSource = (OrderDetailsDTO)source;
	    	OrderDetailsDTO dtoCible = (OrderDetailsDTO)cible;

			dtoCible.setOrderNumber(dtoSource.getOrderNumber());
			
			if (dtoCible.getProductCode().isEmpty())
			    dtoCible.setProductCode(dtoSource.getProductCode());
			
			if (dtoCible.getQuantityOrdered()==0)
			    dtoCible.setQuantityOrdered(dtoSource.getQuantityOrdered());
		
			if (dtoCible.getPriceEach()==0.0)
			    dtoCible.setPriceEach(dtoSource.getPriceEach());
			
			if (dtoCible.getOrderLineNumber()==0)
				dtoCible.setOrderLineNumber(dtoSource.getOrderLineNumber());
		
			OrderDetailsDAO order = new OrderDetailsDAO();	
			order.update(dtoCible);

	    }

	 /**
	     * Retourne une liste de DTOs correspondant à la liste des enregistrements présent dans la table <code>classicmodels.Customers</code>.
	     * 
	     */
	    public static List<AbstractDTO> listAll() {
	    	OrdersDAO order = new OrdersDAO();
	    	return order.listAll(new OrdersDTO());
	    }


		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			OrderDetailsDAO order = new OrderDetailsDAO(); 
			List <AbstractDTO>l = order.listAll(bean);
			return l.get(0);
		}
		
		/*
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			OrderDetailsDAO order = new OrderDetailsDAO();
			order.create(bean);
		}
		public static List<AbstractDTO> listAll(OrderDetailsDTO bean) {
			OrderDetailsDAO orderdetail = new OrderDetailsDAO(); 
			List <AbstractDTO>l = orderdetail.listAll(bean);
			
			return l;
		
		}	
		public static List<AbstractDTO> listOrderdetail(OrderDetailsDTO bean){
		
			OrderDetailsDAO orderDetail = new OrderDetailsDAO();
			
			List <AbstractDTO> l=orderDetail.listOrderDetail(bean);
			return l;
			
		}
}

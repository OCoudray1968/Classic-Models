package com.classicModels.forms;

import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.CustomersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;


public class CommandeEncoursForm {
	
	private List<AbstractDTO> commandes;
	public void CommandeATraiter(Long salesRep) {
		
		
		CustomersDTO client = ManagerFactory.getCustomers();
		//OrdersDTO commande = ManagerFactory.getOrders();
		client.setSalesRepEmployeeNumber(salesRep);
		commandes = CustomersManager.commandesATraiter(client);
		
		
		System.out.println("commandes:"+commandes);
		}
	public List<AbstractDTO> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<AbstractDTO> commandes) {
		this.commandes = commandes;
	}
	

}

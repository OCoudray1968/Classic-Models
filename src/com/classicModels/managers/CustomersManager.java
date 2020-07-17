package com.classicModels.managers;

import java.util.List;

import com.classicModels.DAO.CustomersDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.CustomersDTO;

public class CustomersManager {
	/*
	 * Met à jour un enregistrement dans la table
	 * <code>classicmodels.Customers</code>.<br/> Appel de
	 * <code>CustomersDAO.update(dto.getBean())</code>.
	 */
	public static void update(AbstractDTO source, AbstractDTO cible) {

		CustomersDTO dtoSource = (CustomersDTO) source;
		CustomersDTO dtoCible = (CustomersDTO) cible;
		System.out.println("Source :" + dtoSource);
		System.out.println("Cible :" + dtoCible);
		dtoCible.setCustomerNumber(dtoSource.getCustomerNumber());

		if (dtoCible.getCustomerName().isEmpty())
			dtoCible.setCustomerName(dtoSource.getCustomerName());

		if (dtoCible.getContactLastName().isEmpty())
			dtoCible.setContactLastName(dtoSource.getContactLastName());

		if (dtoCible.getContactFirstName().isEmpty())
			dtoCible.setContactFirstName(dtoSource.getContactFirstName());

		if (dtoCible.getPhone().isEmpty())
			dtoCible.setPhone(dtoSource.getPhone());

		if (dtoCible.getAddressLine1().isEmpty())
			dtoCible.setAddressLine1(dtoSource.getAddressLine1());

		if (dtoCible.getAddressLine2().isEmpty())
			dtoCible.setAddressLine2(dtoSource.getAddressLine2());

		if (dtoCible.getCity().isEmpty())
			dtoCible.setCity(dtoSource.getCity());

		if (dtoCible.getState().isEmpty())
			dtoCible.setState(dtoSource.getState());

		if (dtoCible.getPostalCode().isEmpty())
			dtoCible.setPostalCode(dtoSource.getPostalCode());

		if (dtoCible.getCountry().isEmpty())
			dtoCible.setCountry(dtoSource.getCountry());

		if (dtoCible.getSalesRepEmployeeNumber() == 0)
			dtoCible.setSalesRepEmployeeNumber(dtoSource.getSalesRepEmployeeNumber());

		if (dtoCible.getCreditLimit() == 0.0)
			dtoCible.setCreditLimit(dtoSource.getCreditLimit());

		if (dtoCible.getEmail().isEmpty())
			dtoCible.setEmail(dtoSource.getEmail());

		CustomersDAO client = new CustomersDAO();

		client.update(dtoCible);
	}

	/**
	 * Retourne une liste de DTOs correspondant à la liste des enregistrements
	 * présent dans la table <code>classicmodels.Customers</code>.
	 * 
	 */
	public static List<AbstractDTO> listAll() {
		CustomersDAO client = new CustomersDAO();
		return client.listAll(new CustomersDTO());
	}

	/**
	 * Retourne un seul enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public static AbstractDTO getRecord(AbstractDTO bean) {
		CustomersDAO client = new CustomersDAO();
		List<AbstractDTO> l = client.listAll(bean);
		return l.get(0);
	}

	public static AbstractDTO getLast(AbstractDTO bean) {
		CustomersDAO client = new CustomersDAO();
		List<AbstractDTO> l = client.listLast(bean);
		return l.get(0);
	}

	/**
	 * supprime un enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public static void delRecord(AbstractDTO bean) {
		CustomersDAO client = new CustomersDAO();
		client.delete(bean);

	}

	/**
	 * Insère un enregistrement
	 * 
	 * @param bean
	 */
	public static void setRecord(AbstractDTO bean) {
		CustomersDAO client = new CustomersDAO();
		client.create(bean);
	}

	public static List<AbstractDTO> listAll(CustomersDTO client) {

		CustomersDAO clients = new CustomersDAO();
		List<AbstractDTO> l = clients.listAll(client);
		return l;
	}

	public static List<AbstractDTO> commandesATraiter(CustomersDTO client) {
		CustomersDAO clients = new CustomersDAO();
		List<AbstractDTO> l = clients.commandeATraiter(client);
		return l;
	}

}

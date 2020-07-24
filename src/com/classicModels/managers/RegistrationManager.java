package com.classicModels.managers;

import java.util.List;

import com.classicModels.DAO.RegistrationDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.RegistrationDTO;

public class RegistrationManager {
	/*
	 * Met à jour un enregistrement dans la table
	 * <code>classicmodels.Customers</code>.<br/> Appel de
	 * <code>CustomersDAO.update(dto.getBean())</code>.
	 */
	public static void update(AbstractDTO source, AbstractDTO cible) {

		RegistrationDTO dtoSource = (RegistrationDTO) source;
		RegistrationDTO dtoCible = (RegistrationDTO) cible;

		dtoCible.setCustomerNumber(dtoSource.getCustomerNumber());

		if (dtoCible.getCustomerName().isEmpty())
			dtoCible.setCustomerName(dtoSource.getCustomerName());

		if (dtoCible.getAddressLine1().isEmpty())
			dtoCible.setAddressLine1(dtoSource.getAddressLine1());

		if (dtoCible.getAddressLine2().isEmpty())
			dtoCible.setAddressLine2(dtoSource.getAddressLine2());

		if (dtoCible.getPostalCode().isEmpty())
			dtoCible.setPostalCode(dtoSource.getPostalCode());

		if (dtoCible.getCity().isEmpty())
			dtoCible.setCity(dtoSource.getCity());

		if (dtoCible.getState().isEmpty())
			dtoCible.setState(dtoSource.getState());

		if (dtoCible.getCountry().isEmpty())
			dtoCible.setCountry(dtoSource.getCountry());

		if (dtoCible.getEmail().isEmpty())
			dtoCible.setEmail(dtoSource.getEmail());

		if (dtoCible.getContactLastName().isEmpty())
			dtoCible.setContactLastName(dtoSource.getContactLastName());

		if (dtoCible.getContactFirstName().isEmpty())
			dtoCible.setContactFirstName(dtoSource.getContactFirstName());

		RegistrationDAO client = new RegistrationDAO();
		client.update(dtoCible);
	}

	/**
	 * Retourne une liste de DTOs correspondant à la liste des enregistrements
	 * présent dans la table <code>classicmodels.Customers</code>.
	 * 
	 */
	public static List<AbstractDTO> listAll() {
		RegistrationDAO client = new RegistrationDAO();
		return client.listAll(new RegistrationDTO());
	}

	/**
	 * Retourne un seul enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public static AbstractDTO getRecord(AbstractDTO bean) {
		RegistrationDAO client = new RegistrationDAO();
		List<AbstractDTO> l = client.listAll(bean);
		return l.get(0);
	}

	public static AbstractDTO getLast(AbstractDTO bean) {
		RegistrationDAO client = new RegistrationDAO();
		List<AbstractDTO> l = client.listLast(bean);
		if (l.get(0) == null) {
			return null;
		} else {
			return l.get(0);
		}
	}

	/**
	 * supprime un enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public static void delRecord(AbstractDTO bean) {
		RegistrationDAO client = new RegistrationDAO();
		client.delete(bean);

	}

	/**
	 * Insère un enregistrement
	 * 
	 * @param bean
	 */
	public static void setRecord(AbstractDTO bean) {
		RegistrationDAO client = new RegistrationDAO();
		client.create(bean);
	}

	public static List<AbstractDTO> listAll(RegistrationDTO client) {

		RegistrationDAO clients = new RegistrationDAO();
		List<AbstractDTO> l = clients.listAll(client);
		return l;
	}

	public static List<AbstractDTO> commandesATraiter(RegistrationDTO client) {
		RegistrationDAO clients = new RegistrationDAO();
		List<AbstractDTO> l = clients.commandeATraiter(client);
		return l;
	}

}

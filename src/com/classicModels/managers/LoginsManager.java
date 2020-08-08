package com.classicModels.managers;

import java.util.List;

import com.classicModels.DAO.LoginsDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.LoginsDTO;

public class LoginsManager {

	public static void update(AbstractDTO source, AbstractDTO cible) {

		LoginsDTO dtoSource = (LoginsDTO) source;
		LoginsDTO dtoCible = (LoginsDTO) cible;

		System.out.println("source :" + dtoSource);
		System.out.println("cible :" + dtoCible);

		if (dtoCible.getCustomerNumber() == 0)
			dtoCible.setCustomerNumber(dtoSource.getCustomerNumber());

		if (dtoCible.getEmployeeNumber() == 0)
			dtoCible.setEmployeeNumber(dtoSource.getEmployeeNumber());

		if (dtoCible.getLogin().isEmpty())
			dtoCible.setLogin(dtoSource.getLogin());

		if (dtoCible.getPasswordLogin().isEmpty())
			dtoCible.setPasswordLogin(dtoSource.getPasswordLogin());

		if (dtoCible.getProfil() == 0)
			dtoCible.setProfil(dtoSource.getProfil());

		LoginsDAO login = new LoginsDAO();
		login.update(dtoCible);
	}

	/**
	 * Retourne une liste de DTOs correspondant � la liste des enregistrements
	 * pr�sent dans la table <code>classicmodels.Customers</code>.
	 * 
	 * @see com.bd.manager.InterfaceManager#listAll(Object bean)
	 */
	/**
	 * Retourne une liste de DTOs correspondant à la liste des enregistrements
	 * présent dans la table <code>classicmodels.Customers</code>.
	 * 
	 */
	public static List<AbstractDTO> listAll() {
		LoginsDAO login = new LoginsDAO();
		return login.listAll(new LoginsDTO());
	}

	/**
	 * Retourne un seul enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public static AbstractDTO getRecord(AbstractDTO bean) {
		LoginsDAO login = new LoginsDAO();
		List<AbstractDTO> l = login.listAll(bean);
		System.out.println("liste des enregistrements :" + l);
		try {
			return l.get(0);
		} catch (Exception e) {

			return null;
		}

	}

	/**
	 * Insère un enregistrement
	 * 
	 * @param bean
	 */
	public static void setRecord(AbstractDTO bean) {
		LoginsDAO login = new LoginsDAO();
		login.create(bean);
	}

	public static void delRecord(AbstractDTO bean) {
		LoginsDAO login = new LoginsDAO();
		login.delete(bean);

	}

}

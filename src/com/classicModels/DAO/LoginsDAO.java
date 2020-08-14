package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.LoginsDTO;
import com.classicModels.beans.LoginsBean;

public class LoginsDAO extends AbstractDAO {

	/*
	 * Retourne une liste de logins à partir d'un ResultSet
	 */
	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();

		try {
			while (rs.next()) {
				LoginsDTO login = new LoginsDTO();

				login.setCustomerNumber(rs.getInt("customerNumber"));
				login.setEmployeeNumber(rs.getInt("employeeNumber"));
				login.setLogin(rs.getString("login"));
				login.setPasswordLogin(rs.getString("pwd"));
				login.setProfil(rs.getInt("profil"));
				login.setDateCrea(rs.getDate("dateCrea"));
				login.setDateMAJ(rs.getDate("dateMAJ"));

				l.add(login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

	/**
	 * Génère la clause where de la requête pour la table customers
	 * 
	 * @param cb
	 * @return
	 */
	public String generateWHEREquery(AbstractDTO cb) {
		// Marqueur permettant de savoir si la clause Where à déjà commencée

		StringBuilder sb = new StringBuilder();
		LoginsDTO bean = (LoginsDTO) cb;
		if (bean.getClass() != null) {
			if (bean.getLogin() != "") {

				sb.append(" WHERE login LIKE ").append("'").append(bean.getLogin()).append("'").append(" AND pwd LIKE ")
						.append("'").append(bean.getPasswordLogin()).append("'").append(";");
			}
		}

		return sb.toString();
	}

	/*
	 * Génère la seconde partie d'une requête INSERT* VALUES ( 'valeur 1', 'valeur
	 * 2', ... )
	 * 
	 * * seulement la liste des valeurs (2 lg)
	 */
	public String generateINSERTquery(AbstractDTO ab) {
		LoginsDTO bean = (LoginsDTO) ab;
		StringBuilder sb = new StringBuilder();

		// Le code client
		if (bean.getCustomerNumber() != 0) {
			sb.append("'").append(bean.getCustomerNumber()).append("', ");
		} else {
			sb.append("null,");
		}
		// Le code employee
		if (bean.getEmployeeNumber() != 0) {
			sb.append("'").append(bean.getEmployeeNumber()).append("', ");
		} else {
			sb.append("null,");
		}
		// le login
		sb.append("'").append(bean.getLogin()).append("', ");

		// le password
		sb.append("'").append(bean.getPasswordLogin()).append("', ");

		sb.append("'").append(bean.getProfil()).append("',");

		sb.append("NOW(),NOW()");

		return sb.toString();
	}

	/**
	 * La requête sql est UPDATE table SET colonne_1 = 'valeur 1', colonne_2 =
	 * 'valeur 2', colonne_3 = 'valeur 3' WHERE condition
	 * 
	 * Nous nous occupons juste du SET
	 * 
	 * @param bean
	 */
	public String generateUPDATEquery(AbstractDTO ab) {
		LoginsDTO bean = (LoginsDTO) ab;
		StringBuilder sb = new StringBuilder();
		// Le login
		sb.append("login = '").append(bean.getLogin()).append("', ");

		// Le password
		sb.append("pwd = '").append(bean.getPasswordLogin()).append("', ");

		// Le profil
		sb.append("profil = '").append(bean.getProfil()).append("', ");

		// date Créa
		sb.append("dateCrea = ").append("NOW()").append(",");
		// date Modification
		sb.append("dateMAJ = ").append("NOW()");
		// Clause WHERE
		sb.append(" WHERE customerNumber = '").append(bean.getCustomerNumber()).append("'");

		sb.append(" OR EmployeeNumber = '").append(bean.getEmployeeNumber()).append("' ;");

		return sb.toString();
	}

	public LoginsBean trouver(String login, String pwd) {

		return null;
	}

	@Override
	public String generateLASTquery(AbstractDTO bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateUnionQuery(AbstractDTO bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractDTO> makeListOrdersInProcess(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateDeletequery(AbstractDTO ab) {
		LoginsDTO bean = (LoginsDTO) ab;
		StringBuilder sb = new StringBuilder();
		if (bean.getEmployeeNumber() != 0) {
			sb.append("WHERE employeeNumber='").append(bean.getEmployeeNumber()).append("';");
		} else if (bean.getCustomerNumber() != 0) {
			sb.append("WHERE customerNumber='").append(bean.getCustomerNumber()).append("';");
		}
		return sb.toString();
	}

}
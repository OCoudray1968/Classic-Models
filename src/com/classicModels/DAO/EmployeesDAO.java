package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.EmployeesDTO;

public class EmployeesDAO extends AbstractDAO {
	/*
	 * Retourne une liste d'employées a partir d'un Resultset
	 */

	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();

		try {
			while (rs.next()) {
				EmployeesDTO client = new EmployeesDTO();
				client.setEmployeeNumber(rs.getInt("employeeNumber"));
				client.setLastName(rs.getString("lastName"));
				client.setFirstName(rs.getString("firstName"));
				client.setExtension(rs.getString("extension"));
				client.setEmail(rs.getString("email"));
				client.setOfficeCode(rs.getInt("officeCode"));
				client.setReportsTo(rs.getInt("reportsTo"));
				client.setJobTitle(rs.getString("jobTitle"));

				l.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

	/*
	 * Génère la clause Where de la requête pour la table employee
	 * 
	 * @param eb
	 * 
	 * @return
	 */

	public String generateWHEREquery(AbstractDTO eb) {
		// Marqueur permettant de savoir si la clause Where à déjà commencé
		boolean isWhereClause = false;

		StringBuilder sb = new StringBuilder();
		EmployeesDTO bean = (EmployeesDTO) eb;

		// Le numéro de l'employee
		if (bean.getEmployeeNumber() != 0) {
			isWhereClause = true;
			sb.append(" WHERE EmployeeNumber = ").append(bean.getEmployeeNumber());
		}

		// Last name
		if (bean.getLastName() != null && !bean.getLastName().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("LastName LIKE '").append(bean.getLastName()).append("'");
		}

		// First name
		if (bean.getFirstName() != null && !bean.getFirstName().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("FirstName LIKE '").append(bean.getFirstName()).append("'");
		}

		// extension
		if (bean.getExtension() != null && !bean.getExtension().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("extension LIKE '").append(bean.getExtension()).append("'");
		}

		// Email
		if (bean.getEmail() != null && !bean.getEmail().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("email LIKE '").append(bean.getEmail()).append("'");
		}

		// Office Code
		if (bean.getOfficeCode() != 0) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("OfficeCode LIKE '").append(bean.getOfficeCode()).append("'");
		}

		// report to
		if (bean.getReportsTo() != 0) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("reportsTo LIKE '").append(bean.getReportsTo()).append("'");
		}

		// Etat
		if (bean.getJobTitle() != null && !bean.getJobTitle().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("jobTitle LIKE '").append(bean.getJobTitle()).append("'");
		}
		System.out.println("requete pour employee " + sb);
		return sb.toString();
	}

	/*
	 * Génère la deuxième partie de la requete Insert VALUES ( 'valeur 1', 'valeur
	 * 2', ... )
	 * 
	 * * seulement la liste des valeurs (2 lg)
	 */
	public String generateINSERTquery(AbstractDTO eb) {
		StringBuilder sb = new StringBuilder();
		EmployeesDTO bean = (EmployeesDTO) eb;

// Le numéro d'employée
		sb.append(bean.getEmployeeNumber()).append(", ");

// Last name
		sb.append("'").append(bean.getLastName()).append("', ");

// First name
		sb.append("'").append(bean.getFirstName()).append("', ");

// extension
		sb.append("'").append(bean.getExtension()).append("', ");

// Email
		sb.append("'").append(bean.getEmail()).append("', ");

// Office code
		sb.append("'").append(bean.getOfficeCode()).append("', ");

// reports to
		sb.append("'").append(bean.getReportsTo()).append("', ");

// job title
		sb.append("'").append(bean.getJobTitle()).append("' ");

		return sb.toString();
	}

	/**
	 * La requète sql est UPDATE table SET colonne_1 = 'valeur 1', colonne_2 =
	 * 'valeur 2', colonne_3 = 'valeur 3' WHERE condition
	 * 
	 * @param bean
	 */
	public String generateUPDATEquery(AbstractDTO eb) {
		StringBuilder sb = new StringBuilder();
		EmployeesDTO bean = (EmployeesDTO) eb;

// Last name
		sb.append("LastName = '").append(bean.getLastName()).append("', ");

// first name
		sb.append("FirstName = '").append(bean.getFirstName()).append("', ");

// Extension
		sb.append("extension = '").append(bean.getExtension()).append("', ");

// Email
		sb.append("email = '").append(bean.getEmail()).append("', ");

// office code
		sb.append("officeCode = '").append(bean.getOfficeCode()).append("', ");

// Reports to
		sb.append("reportsTo = '").append(bean.getReportsTo()).append("', ");

// jobtitle
		sb.append("jobTitle = '").append(bean.getJobTitle());

// Clause WHERE
		sb.append("' WHERE employeeNumber = ").append(bean.getEmployeeNumber());

		return sb.toString();
	}

	@Override
	public String generateLASTquery(AbstractDTO bean) {
		StringBuilder sb = new StringBuilder();

		sb.append(" ORDER BY employeeNumber DESC; ");

		return sb.toString();
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
		EmployeesDTO bean = (EmployeesDTO) ab;
		StringBuilder sb = new StringBuilder();

		sb.append("WHERE employeeNumber='").append(bean.getEmployeeNumber()).append("';");

		return sb.toString();
	}

}

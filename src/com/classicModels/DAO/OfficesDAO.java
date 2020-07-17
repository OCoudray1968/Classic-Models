package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.OfficesDTO;

public class OfficesDAO extends AbstractDAO {

	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();

		try {
			while (rs.next()) {
				OfficesDTO office = new OfficesDTO();

				office.setOfficeCode(rs.getInt("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhoneOffice(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setStateOffice(rs.getString("state"));
				office.setCountryOffice(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));

				l.add(office);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

	public String generateWHEREquery(AbstractDTO ob) {
		// Marqueur permettant de savoir si la clause Where a deja commencée
		boolean isWhereClause = false;

		StringBuilder sb = new StringBuilder();
		OfficesDTO bean = (OfficesDTO) ob;

		// Le code de l'office
		if (bean.getOfficeCode() != 0) {
			isWhereClause = true;
			sb.append(" WHERE officeCode LIKE ").append(bean.getOfficeCode());
		}

		// La ville
		if (bean.getCity() != null && !bean.getCity().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("city LIKE '").append(bean.getCity()).append("'");
		}

		// telephone
		if (bean.getPhoneOffice() != null && !bean.getPhoneOffice().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("phone LIKE '").append(bean.getPhoneOffice()).append("'");
		}

		// address 1
		if (bean.getAddressLine1() != null && !bean.getAddressLine1().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("addressLine1 LIKE '").append(bean.getAddressLine1()).append("'");
		}

		// address 2

		if (bean.getAddressLine2() != null && !bean.getAddressLine2().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("addressLine2 LIKE '").append(bean.getAddressLine2()).append("'");
		}

		// State office
		if (bean.getStateOffice() != null && !bean.getStateOffice().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("state LIKE '").append(bean.getStateOffice()).append("'");
		}

		// country office

		if (bean.getCountryOffice() != null && !bean.getCountryOffice().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("country LIKE '").append(bean.getCountryOffice()).append("'");
		}

		// code postal

		if (bean.getPostalCode() != null && !bean.getPostalCode().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("postalCode LIKE '").append(bean.getPostalCode()).append("'");
		}

		// territoire

		if (bean.getTerritory() != null && !bean.getTerritory().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("territory LIKE '").append(bean.getTerritory()).append("'");
		}

		return sb.toString();
	}

	/*
	 * G�n�re la seconde partie d'une requ�te INSERT* VALUES ( 'valeur 1', 'valeur
	 * 2', ... )
	 * 
	 * * seulement la liste des valeurs (2 lg)
	 */
	public String generateINSERTquery(AbstractDTO ob) {
		StringBuilder sb = new StringBuilder();
		OfficesDTO bean = (OfficesDTO) ob;

// code office
		sb.append("'").append(bean.getOfficeCode()).append("', ");

// ville
		sb.append("'").append(bean.getCity()).append("', ");

// vtelephone
		sb.append("'").append(bean.getPhoneOffice()).append("', ");

// addresse 1
		sb.append("'").append(bean.getAddressLine1()).append("', ");

//addresse 2
		sb.append("'").append(bean.getAddressLine2()).append("', ");

//etat
		sb.append("'").append(bean.getStateOffice()).append("', ");

//pays
		sb.append("'").append(bean.getCountryOffice()).append("', ");

//code postal
		sb.append("'").append(bean.getPostalCode()).append("', ");

// territoire

		sb.append("'").append(bean.getTerritory()).append("' ");

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
	public String generateUPDATEquery(AbstractDTO ob) {
		StringBuilder sb = new StringBuilder();
		OfficesDTO bean = (OfficesDTO) ob;

// ville
		sb.append("city = '").append(bean.getCity()).append("', ");

// telephone
		sb.append("phone = '").append(bean.getPhoneOffice()).append("', ");

//address 1
		sb.append("addressLine2 = '").append(bean.getAddressLine2()).append("', ");

//etat
		sb.append("state = '").append(bean.getStateOffice()).append("', ");

//pays
		sb.append("country = '").append(bean.getCountryOffice()).append("', ");

//postal code
		sb.append("postalCode = '").append(bean.getPostalCode()).append("', ");

//territory
		sb.append("territory = '").append(bean.getTerritory()).append("' ");

// Clause WHERE
		sb.append(" WHERE officeCode = ").append(bean.getOfficeCode());

		return sb.toString();
	}

	@Override
	public String generateLASTquery(AbstractDTO bean) {
		StringBuilder sb = new StringBuilder();

		sb.append(" ORDER BY officeCode DESC; ");

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

		OfficesDTO bean = (OfficesDTO) ab;
		StringBuilder sb = new StringBuilder();

		sb.append("WHERE officeCode='").append(bean.getOfficeCode()).append("';");

		return sb.toString();
	}
}
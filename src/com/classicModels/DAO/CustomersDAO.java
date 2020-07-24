package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.OrdersDTO;

public class CustomersDAO extends AbstractDAO {
	private static final String AND = " AND ";
	private static final String WHERE = " WHERE ";

	/*
	 * Retourne une liste de clients à partir d'un ResultSet
	 */
	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();

		try {
			while (rs.next()) {
				CustomersDTO client = new CustomersDTO();
				client.setCustomerNumber(rs.getLong("customerNumber"));
				client.setCustomerName(rs.getString("customerName"));
				client.setContactLastName(rs.getString("contactLastName"));
				client.setContactFirstName(rs.getString("contactFirstName"));
				client.setPhone(rs.getString("phone"));
				client.setAddressLine1(rs.getString("addressLine1"));
				client.setAddressLine2(rs.getString("addressLine2"));
				client.setCity(rs.getString("city"));
				client.setState(rs.getString("state"));
				client.setPostalCode(rs.getString("postalCode"));
				client.setCountry(rs.getString("country"));
				client.setSalesRepEmployeeNumber(rs.getLong("salesRepEmployeeNumber"));
				client.setCreditLimit(rs.getDouble("creditLimit"));
				client.setEmail(rs.getString("email"));
				l.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public List<AbstractDTO> makeListOrdersInProcess(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();

		try {
			while (rs.next()) {
				OrdersDTO order = new OrdersDTO();
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setRequiredDate(rs.getDate("requiredDate"));
				order.setShippedDate(rs.getDate("shippedDate"));
				order.setStatusOrder(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getLong("customerNumber"));
				l.add(order);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public String generateUnionQuery(AbstractDTO cb) {
		// Marqueur permettant de savoir si la clause Where à déjà commencée

		StringBuilder sb = new StringBuilder();
		CustomersDTO bean = (CustomersDTO) cb;
		sb.append(" ON c.customerNumber = o.customerNumber ");
		sb.append(" WHERE c.salesRepEmployeeNumber = ").append(bean.getSalesRepEmployeeNumber());

		sb.append(" AND o.status LIKE 'In Process' ");

		return sb.toString();
	}

	/**
	 * Génère la clause where de la requête pour la table customers
	 * 
	 * @param cb
	 * @return
	 */
	public String generateWHEREquery(AbstractDTO cb) {
		// Marqueur permettant de savoir si la clause Where à déjà commencée
		boolean isWhereClause = false;

		StringBuilder sb = new StringBuilder();
		CustomersDTO bean = (CustomersDTO) cb;

		// Le numéro de client
		if (bean.getCustomerNumber() > 0) {
			isWhereClause = true;
			sb.append("WHERE customerNumber = ").append(bean.getCustomerNumber());
		}

		// Le nom du client
		if (bean.getCustomerName() != null && !bean.getCustomerName().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("customerName = '").append(bean.getCustomerName()).append("'");
		}

		// Le nom du contact
		if (bean.getContactLastName() != null && !bean.getContactLastName().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("contactLastName = '").append(bean.getContactLastName()).append("'");
		}

		// Le prenom du client
		if (bean.getContactFirstName() != null && !bean.getContactFirstName().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("contactFirstName = '").append(bean.getContactFirstName()).append("'");
		}

		// Numéro de téléphone
		if (bean.getPhone() != null && !bean.getPhone().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("phone = '").append(bean.getPhone()).append("'");
		}

		// Adresse 1
		if (bean.getAddressLine1() != null && !bean.getAddressLine1().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("addressLine1 = '").append(bean.getAddressLine1()).append("'");
		}

		// Adresse 2
		if (bean.getAddressLine2() != null && !bean.getAddressLine2().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("addressLine2 = '").append(bean.getAddressLine2()).append("'");
		}

		// Ville
		if (bean.getCity() != null && !bean.getCity().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("city = '").append(bean.getCity()).append("'");
		}

		// Etat
		if (bean.getState() != null && !bean.getState().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("state = '").append(bean.getState()).append("'");
		}

		// Code postal
		if (bean.getPostalCode() != null && !bean.getPostalCode().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("postalCode = '").append(bean.getPostalCode()).append("'");
		}

		// Pays
		if (bean.getCountry() != null && !bean.getCountry().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("country = '").append(bean.getCountry()).append("'");
		}

		// Référence employé
		if (bean.getSalesRepEmployeeNumber() > 0) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("salesRepEmployeeNumber = ").append(bean.getSalesRepEmployeeNumber());
		}

		// Limite de crédit
		if (bean.getCreditLimit() > 0) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("creditLimit = '").append(bean.getCreditLimit()).append("'");
		}

		// Email
		if (bean.getEmail() != null && !bean.getEmail().isEmpty()) {
			if (!isWhereClause) {
				sb.append(WHERE);
				isWhereClause = true;
			} else
				sb.append(AND);

			sb.append("email = '").append(bean.getEmail()).append("'");
		}

		return sb.toString();
	}

	/*
	 * Génère la seconde partie d'une requête INSERT* VALUES ( 'valeur 1', 'valeur
	 * 2', ... )
	 * 
	 * * seulement la liste des valeurs (2 l)
	 */
	public String generateINSERTquery(AbstractDTO ab) {
		CustomersDTO bean = (CustomersDTO) ab;
		StringBuilder sb = new StringBuilder();

		// Le numéro de client
		sb.append(bean.getCustomerNumber()).append(", ");

		// Le nom du client
		sb.append("'").append(bean.getCustomerName()).append("', ");

		// Le nom du contact
		sb.append("'").append(bean.getContactLastName()).append("', ");

		// Le prenom du client
		sb.append("'").append(bean.getContactFirstName()).append("', ");

		// Numéro de téléphone
		sb.append("'").append(bean.getPhone()).append("', ");

		// Adresse 1
		sb.append("'").append(bean.getAddressLine1()).append("', ");

		// Adresse 2
		sb.append("'").append(bean.getAddressLine2()).append("', ");

		// Ville
		sb.append("'").append(bean.getCity()).append("', ");

		// Etat
		sb.append("'").append(bean.getState()).append("', ");

		// Code postal
		sb.append("'").append(bean.getPostalCode()).append("', ");

		// Pays
		sb.append("'").append(bean.getCountry()).append("', ");

		// Référence employé
		sb.append(bean.getSalesRepEmployeeNumber()).append(", ");

		// Limite de crédit
		sb.append(bean.getCreditLimit()).append(", ");

		// Email
		sb.append("'").append(bean.getEmail()).append("'");

		return sb.toString();
	}

	/**
	 * 
	 * Effacer un enregistrement
	 * 
	 * @param bean
	 */
	public String generateDeletequery(AbstractDTO ab) {
		CustomersDTO bean = (CustomersDTO) ab;
		StringBuilder sb = new StringBuilder();

		sb.append("WHERE customerNumber='").append(bean.getCustomerNumber()).append("';");

		return sb.toString();
	}

	public String generateUPDATEquery(AbstractDTO ab) {
		CustomersDTO bean = (CustomersDTO) ab;
		StringBuilder sb = new StringBuilder();

		// Le nom du client
		sb.append("customerName = '").append(bean.getCustomerName()).append("', ");

		// Le nom du contact
		sb.append("contactLastName = '").append(bean.getContactLastName()).append("', ");

		// Le prenom du client
		sb.append("ContactFirstName = '").append(bean.getContactFirstName()).append("', ");

		// Numéro de téléphone
		sb.append("phone = '").append(bean.getPhone()).append("', ");

		// Adresse 1
		sb.append("AddressLine1 = '").append(bean.getAddressLine1()).append("', ");

		// Adresse 2
		sb.append("AddressLine2 = '").append(bean.getAddressLine2()).append("', ");

		// Ville
		sb.append("city = '").append(bean.getCity()).append("', ");

		// Etat
		sb.append("state = '").append(bean.getState()).append("', ");

		// Code postal
		sb.append("postalCode = '").append(bean.getPostalCode()).append("', ");

		// Pays
		sb.append("Country = '").append(bean.getCountry()).append("', ");

		// Référence employé
		sb.append("SalesRepEmployeeNumber = ").append(bean.getSalesRepEmployeeNumber()).append(", ");

		// Limite de crédit
		sb.append("CreditLimit = ").append(bean.getCreditLimit()).append(", ");

		// Email
		sb.append("email = '").append(bean.getEmail()).append("'");

		// Clause WHERE
		sb.append(" WHERE customerNumber = ").append(bean.getCustomerNumber());

		return sb.toString();
	}

	@Override
	public String generateLASTquery(AbstractDTO bean) {
		StringBuilder sb = new StringBuilder();

		sb.append(" ORDER BY customerNumber DESC; ");

		return sb.toString();
	}

}

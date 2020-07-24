package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.PaymentsDTO;

public class PaymentsDAO extends AbstractDAO {

	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();

		try {
			while (rs.next()) {
				PaymentsDTO payment = new PaymentsDTO();

				payment.setCustomerNumber(rs.getInt("customerNumber"));
				payment.setCheckNumber(rs.getString("checkNumber"));
				payment.setPaymentDate(rs.getDate("paymentDate"));
				payment.setAmountPayment(rs.getDouble("amount"));

				l.add(payment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

	public String generateWHEREquery(AbstractDTO pb) {
		// Marqueur permettant de savoir si la clause Where � d�j� commenc�e
		boolean isWhereClause = false;

		StringBuilder sb = new StringBuilder();
		PaymentsDTO bean = (PaymentsDTO) pb;

		// Le num�ro de client
		if (bean.getCustomerNumber() != 0) {
			isWhereClause = true;
			sb.append(" WHERE customerNumber LIKE ").append(bean.getCustomerNumber());
		}

		// Le numero du cheque
		if (!bean.getCheckNumber().isEmpty()) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("checkNumber LIKE '").append(bean.getCheckNumber()).append("'");
		}

		// La date de paiement
		if (bean.getPaymentDate() == new Date(0)) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("paymentDate LIKE '").append(bean.getPaymentDate()).append("'");
		}

		// Le pmontant du paiment
		if (!(bean.getAmountPayment() == 0.0)) {
			if (!isWhereClause)
				sb.append(" WHERE ");
			else
				sb.append(" AND ");

			sb.append("amount LIKE '").append(bean.getAmountPayment()).append("'");
		}

		return sb.toString();
	}

	/*
	 * Genere la requete INSERT* VALUES ( 'valeur 1', 'valeur 2', ... )
	 * 
	 * 
	 */
	public String generateINSERTquery(AbstractDTO pb) {
		StringBuilder sb = new StringBuilder();
		PaymentsDTO bean = (PaymentsDTO) pb;

// numero client
		sb.append("'").append(bean.getCustomerNumber()).append("', ");

// Le numero du check
		sb.append("'").append(bean.getCheckNumber()).append("', ");

// date de paiement
		sb.append("'").append(bean.getPaymentDate()).append("', ");

// montant du paiment
		sb.append("'").append(bean.getAmountPayment()).append("' ");

		return sb.toString();
	}

	/**
	 * La requ�te sql est UPDATE table SET colonne_1 = 'valeur 1', colonne_2 =
	 * 'valeur 2', colonne_3 = 'valeur 3' WHERE condition
	 * 
	 * Nous nous occupons juste du SET
	 * 
	 * @param bean
	 */
	public String generateUPDATEquery(AbstractDTO pb) {
		StringBuilder sb = new StringBuilder();
		PaymentsDTO bean = (PaymentsDTO) pb;

// date paiement
		sb.append("paymentDate = '").append(bean.getPaymentDate()).append("', ");

// Montant
		sb.append("amount = '").append(bean.getAmountPayment());

// Clause WHERE
		sb.append("' WHERE customerNumber = ").append(bean.getCustomerNumber()).append(" AND checkNumber = '")
				.append(bean.getCheckNumber()).append("'; ");

		return sb.toString();
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
		StringBuilder sb = new StringBuilder();
		PaymentsDTO bean = (PaymentsDTO) ab;

// Clause WHERE
		sb.append(" WHERE customerNumber = ").append(bean.getCustomerNumber()).append(" AND checkNumber = '")
				.append(bean.getCheckNumber()).append("'; ");

		return sb.toString();
	}

}

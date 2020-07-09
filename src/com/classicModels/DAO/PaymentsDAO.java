package com.classicModels.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.PaymentsDTO;






public class PaymentsDAO extends AbstractDAO{

	
	
	
	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();
		
		try {
			while (rs.next()) {
				PaymentsDTO payment = new PaymentsDTO();
				
				payment.setCustomerNumber(rs.getInt("customer_number"));
				payment.setCheckNumber(rs.getString("check_number"));
				payment.setPaymentDate(rs.getDate("payment_date"));
				payment.setAmountPayment(rs.getDouble("price_each"));
				
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
		sb.append(" WHERE customer_number LIKE ")
		  .append(bean.getCustomerNumber());
	}
	
	// Le numero du cheque
	if (bean.getCheckNumber() != null && !bean.getCheckNumber().isEmpty()) {
		if (!isWhereClause) sb.append(" WHERE ");
		else 				sb.append(" AND ");
		
		sb.append("check_number LIKE '")
		  .append(bean.getCheckNumber()).append("'");
	}
	
	// La date de paiement
	if (bean.getPaymentDate() != null) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("payment_date LIKE '")
		  .append(bean.getPaymentDate()).append("'");
	}
	
	// Le pmontant du paiment
	if (bean.getAmountPayment() != null && !(bean.getAmountPayment()>0.0)) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("amount LIKE '")
		  .append(bean.getAmountPayment()).append("'");
	}
	
		
	return sb.toString();
}

/*
 * G�n�re la seconde partie d'une requ�te INSERT*
 * VALUES (
 *   'valeur 1', 'valeur 2', ...
 * )
 * 
 * * seulement la liste des valeurs (2 lg)
 */	
public String generateINSERTquery(AbstractDTO pb) {
StringBuilder sb = new StringBuilder();
PaymentsDTO bean = (PaymentsDTO) pb;


// nuùmero client
sb.append("'").append(bean.getCustomerNumber()).append("', ");

// Le numero du check
sb.append("'").append(bean.getCheckNumber()).append("', ");

// qdate de paiement
sb.append("'").append(bean.getPaymentDate()).append("', ");

// montant du paiment
sb.append("'").append(bean.getAmountPayment()).append("' ");


return sb.toString();
}


/**
* La requ�te sql est
* UPDATE table 
*   SET colonne_1 = 'valeur 1', colonne_2 = 'valeur 2', colonne_3 = 'valeur 3'
*   WHERE condition
* 
* Nous nous occupons juste du SET
* @param bean
*/
public String generateUPDATEquery(AbstractDTO pb) {
StringBuilder sb = new StringBuilder();
PaymentsDTO bean =(PaymentsDTO) pb;


// quantité commandée
sb.append("check_number = '").append(bean.getCheckNumber()).append("', ");

// Le vendeur
sb.append("payment_date = '").append(bean.getPaymentDate()).append("', ");

// description du produit
sb.append("amount = '").append(bean.getAmountPayment());


// Clause WHERE
sb.append("' WHERE customer_number = ").append(bean.getCustomerNumber());

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
public String generateDeletequery(AbstractDTO bean) {
	// TODO Auto-generated method stub
	return null;
}


	
}

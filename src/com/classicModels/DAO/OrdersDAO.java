package com.classicModels.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.OrdersDTO;


public class OrdersDAO extends AbstractDAO  {




	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();
		
		try {
			while (rs.next()) {
				OrdersDTO order = new OrdersDTO();
				
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getDate("orderdate"));
				order.setRequiredDate(rs.getDate("requiredDate"));
				order.setShippedDate(rs.getDate("shippedDate"));
				order.setStatusOrder(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
									
				l.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}	
	
	  

public String generateWHEREquery(AbstractDTO ob) {
	// Marqueur permettant de savoir si la clause Where � d�j� commenc�e
	boolean isWhereClause = false;

	StringBuilder sb = new StringBuilder();
	OrdersDTO bean = (OrdersDTO) ob;
	
	// Le num�ro de client
	if (bean.getOrderNumber() != 0) {
		isWhereClause = true;
		sb.append(" WHERE orderNumber LIKE ")
		  .append(bean.getOrderNumber());
	}
//	
//	// Le code du  produit
//	if (bean.getOrderDate() != null ) {
//		if (!isWhereClause) sb.append(" WHERE ");
//		else 				sb.append(" AND ");
//		
//		sb.append("orderDate LIKE '")
//		  .append(bean.getOrderDate()).append("'");
//	}
//	
//	// La quantité commandée
//	if (bean.getRequiredDate() != null) {
//		if (!isWhereClause) sb.append(" WHERE ");
//		else				sb.append(" AND ");
//		
//		sb.append("requiredDate LIKE '")
//		  .append(bean.getRequiredDate()).append("'");
//	}
//	
//	// Le prix unitaire
//	if (bean.getShippedDate() != null ) {
//		if (!isWhereClause) sb.append(" WHERE ");
//		else				sb.append(" AND ");
//		
//		sb.append("shippedDate LIKE '")
//		  .append(bean.getShippedDate()).append("'");
//	}
//	
//	if(bean.getStatusOrder() != null && !bean.getStatusOrder().isEmpty()) {
//		if(!isWhereClause) sb.append(" WHERE ");
//		else			   sb.append(" AND ");
//		
//		sb.append("statusOrder LIKE '")
//		.append(bean.getStatusOrder()).append("'");
//	}
//	
//	if(bean.getComments() != null && !bean.getComments().isEmpty()) {
//		if(!isWhereClause) sb.append(" WHERE ");
//		else			   sb.append(" AND ");
//		
//		sb.append("comments = '")
//		.append(bean.getComments()).append("'");
//	}
	
	if(bean.getCustomerNumber() != 0) {
		if(!isWhereClause) sb.append(" WHERE ");
		else			   sb.append(" AND ");
		
		sb.append("customerNumber LIKE '")
		.append(bean.getCustomerNumber()).append("'");
	}
	System.out.println(sb);
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
public  String generateINSERTquery(AbstractDTO ob) {
StringBuilder sb = new StringBuilder();
OrdersDTO bean = (OrdersDTO) ob;


// numero commande
sb.append("'").append(bean.getOrderNumber()).append("', ");

// date commande
sb.append("'").append(bean.getOrderDate()).append("', ");

// date livraison demandée
sb.append("'").append(bean.getRequiredDate()).append("', ");

// date livraison
sb.append("'").append(bean.getShippedDate()).append("', ");

// etat de la commande

sb.append("'").append(bean.getStatusOrder()).append("', ");

//commentaires	

sb.append("'").append(bean.getComments()).append("', ");

//numero du client
sb.append("'").append(bean.getCustomerNumber()).append("'");


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
public String generateUPDATEquery(AbstractDTO ob) {
StringBuilder sb = new StringBuilder();
OrdersDTO bean = (OrdersDTO) ob;

// date commande
sb.append("orderDate = '").append(bean.getOrderDate()).append("', ");

// date livraison demandée
sb.append("requiredDate = '").append(bean.getRequiredDate()).append("', ");

// date livraison
sb.append("shippedDate = '").append(bean.getShippedDate()).append("', ");

// etat de la commande
sb.append("status = '").append(bean.getStatusOrder()).append("', ");

// commentaires

sb.append("comments = '").append(bean.getComments()).append("', ");

// code client

sb.append("customerNumber = '").append(bean.getCustomerNumber());


// Clause WHERE
sb.append("' WHERE orderNumber = ").append(bean.getOrderNumber());

return sb.toString();
}

// Methode renvoyant le dernier enregistrement de la table order 
public String generateLASTquery(AbstractDTO ob) {
StringBuilder sb = new StringBuilder();

sb.append(" ORDER BY orderNumber DESC; ");

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
public String generateDeletequery(AbstractDTO bean) {
	// TODO Auto-generated method stub
	return null;
}


}
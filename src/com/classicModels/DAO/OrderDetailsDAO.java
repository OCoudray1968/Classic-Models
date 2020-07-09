package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.ProductsDTO;


public class OrderDetailsDAO extends AbstractDAO{


	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();
		
		try {
			while (rs.next()) {
				OrderDetailsDTO orderdetail = new OrderDetailsDTO();
				
				orderdetail.setOrderNumber(rs.getInt("orderNumber"));
				orderdetail.setProductCode(rs.getString("productCode"));
				orderdetail.setQuantityOrdered(rs.getInt("quantityOrdered"));
				orderdetail.setPriceEach(rs.getDouble("priceEach"));
				orderdetail.setOrderLineNumber(rs.getInt("orderLineNumber"));
									
				l.add(orderdetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}	
	public List<AbstractDTO> makeListdetail(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();
		
		try {
			while (rs.next()) {
				ProductsDTO products =new ProductsDTO();
				OrderDetailsDTO orderdetail = new OrderDetailsDTO();
				
				orderdetail.setOrderNumber(rs.getInt("orderNumber"));
				orderdetail.setProductCode(rs.getString("productCode"));
				products.setProductName(rs.getString("productName"));
				orderdetail.setQuantityOrdered(rs.getInt("quantityOrdered"));
				orderdetail.setPriceEach(rs.getDouble("priceEach"));
				orderdetail.setOrderLineNumber(rs.getInt("orderLineNumber"));
									
				l.add(orderdetail);
				l.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}	
public String generateQuery(AbstractDTO odb) {
	StringBuilder sb = new StringBuilder();
	OrderDetailsDTO beanOrder = (OrderDetailsDTO) odb;
	sb.append("JOIN products WHERE (orderdetails.productCode = products.productCode AND orderNumber=")
			.append(beanOrder.getOrderNumber()).append(");");
	return sb.toString();
	
}
public String generateWHEREquery(AbstractDTO odb) {


	StringBuilder sb = new StringBuilder();
	OrderDetailsDTO bean = (OrderDetailsDTO) odb;
	
	
		sb.append(" WHERE orderNumber LIKE ")
		  .append(bean.getOrderNumber());
		sb.append(" AND ");
		sb.append("orderLineNumber LIKE '")
		.append(bean.getOrderLineNumber()).append("'");
	
	
		
	return sb.toString();
}

/*
 * Génère la seconde partie d'une requ�te INSERT*
 * VALUES (
 *   'valeur 1', 'valeur 2', ...
 * )
 * 
 * * seulement la liste des valeurs (2 lg)
 */	
public String generateINSERTquery(AbstractDTO odb) {
StringBuilder sb = new StringBuilder();
OrderDetailsDTO bean=(OrderDetailsDTO) odb;

// nuùmero commande
sb.append("'").append(bean.getOrderNumber()).append("', ");

// Le code produit
sb.append("'").append(bean.getProductCode()).append("', ");

// quantité commandée
sb.append("'").append(bean.getQuantityOrdered()).append("', ");

// prix unitaire
sb.append("'").append(bean.getPriceEach()).append("', ");

// numero ligne commande

sb.append("'").append(bean.getOrderLineNumber()).append("'");

return sb.toString();
}


/**
* La requête sql est
* UPDATE table 
*   SET colonne_1 = 'valeur 1', colonne_2 = 'valeur 2', colonne_3 = 'valeur 3'
*   WHERE condition
* 
* Nous nous occupons juste du SET
* @param bean
*/
public String generateUPDATEquery(AbstractDTO odb) {
StringBuilder sb = new StringBuilder();
OrderDetailsDTO bean= (OrderDetailsDTO) odb;

// code produit
sb.append("productCode= '").append(bean.getProductCode()).append("', ");

// quantité commandée
sb.append("quantityOrdered = '").append(bean.getQuantityOrdered()).append("', ");

// Le vendeur
sb.append("priceEach = '").append(bean.getPriceEach()).append("', ");

// description du produit
sb.append("orderLineNumber = '").append(bean.getOrderLineNumber());


// Clause WHERE
sb.append("' WHERE orderNumber = ").append(bean.getOrderNumber());

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

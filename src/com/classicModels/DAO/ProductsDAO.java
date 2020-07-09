package com.classicModels.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.ProductsDTO;




 public class ProductsDAO extends AbstractDAO {
	
	public List<AbstractDTO> makeList(ResultSet rs) {
		List<AbstractDTO> l = new ArrayList<AbstractDTO>();
		
		try {
			while (rs.next()) {
				ProductsDTO product = new ProductsDTO();
				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));
				
				l.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}




public  String generateWHEREquery(AbstractDTO pb) {
	// Marqueur permettant de savoir si la clause Where � d�j� commenc�e
	boolean isWhereClause = false;

	StringBuilder sb = new StringBuilder();
	ProductsDTO bean = (ProductsDTO)pb;
	
	
	// Le code du  produit
	if (bean.getProductCode() != null && !bean.getProductCode().isEmpty()) {
		 isWhereClause = true;
		sb.append(" WHERE productCode LIKE '")
		  .append(bean.getProductCode()).append("'");
	}
	
	// Le nom du produit
	if (bean.getProductName() != null && !bean.getProductName().isEmpty()) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("productName LIKE '")
		  .append(bean.getProductName()).append("'");
	}
	
	// Le product line
	if (bean.getProductLine() != null && !bean.getProductLine().isEmpty()) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("productLine = '")
		  .append(bean.getProductLine()).append("'");
	}
	
	// echelle du produit
	if (bean.getProductScale() != null && !bean.getProductScale().isEmpty()) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("productScale LIKE '")
		  .append(bean.getProductScale()).append("'");
	}
	
	// product vendor
	if (bean.getProductVendor() != null && !bean.getProductVendor().isEmpty()) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("productVendor = '")
		  .append(bean.getProductVendor()).append("'");
	}

	// description
	if (bean.getProductDescription() != null && !bean.getProductDescription().isEmpty()) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("productDescription LIKE '")
		  .append(bean.getProductDescription()).append("'");
	}

	// quantité
	if (bean.getQuantityInStock() != 0 && !(bean.getQuantityInStock()==0)) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("quantityInStock LIKE '")
		  .append(bean.getQuantityInStock()).append("'");
	}

	// prix de vente
	if (bean.getBuyPrice()!= null && !(bean.getBuyPrice()==0)) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("city LIKE '")
		  .append(bean.getBuyPrice()).append("'");
	}

	// Code postal
	if (bean.getMsrp() != null && !(bean.getMsrp()==0)) {
		if (!isWhereClause) sb.append(" WHERE ");
		else				sb.append(" AND ");
		
		sb.append("MSRP LIKE '")
		  .append(bean.getMsrp()).append("'");
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
public  String generateINSERTquery(AbstractDTO ab) {
StringBuilder sb = new StringBuilder();
ProductsDTO bean=(ProductsDTO)ab;
// Le code du produit
sb.append("'");
sb.append(bean.getProductCode()).append("', ");

// Le nom du produit
sb.append("'").append(bean.getProductName()).append("', ");

// La ligne du produit
sb.append("'").append(bean.getProductLine()).append("', ");

// L'echelle du produit
sb.append("'").append(bean.getProductScale()).append("', ");

// vendeur du produit
sb.append("'").append(bean.getProductVendor()).append("', ");

// Description
sb.append("'").append(bean.getProductDescription()).append("', ");

// Quantité en Stock
sb.append("'").append(bean.getQuantityInStock()).append("', ");

// prix d'achat
sb.append("'").append(bean.getBuyPrice()).append("', ");

// prix de revente conseillé
sb.append("'").append(bean.getMsrp()).append("' ");


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
public  String generateUPDATEquery(AbstractDTO ab) {
ProductsDTO bean=(ProductsDTO)ab;	
StringBuilder sb = new StringBuilder();

// Ligne du produit
sb.append("productLine= '").append(bean.getProductLine()).append("', ");

// Le nom du contact
sb.append("productScale = '").append(bean.getProductScale()).append("', ");

// Le vendeur
sb.append("productVendor = '").append(bean.getProductVendor()).append("', ");

// description du produit
sb.append("productDescription = '").append(bean.getProductDescription()).append("', ");

// quantité en stock
sb.append("quantityInStock = '").append(bean.getQuantityInStock()).append("', ");

// prix d'achat
sb.append("buyPrice = '").append(bean.getBuyPrice()).append("', ");

// prix de vente conseillé
sb.append("MSRP = '").append(bean.getMsrp());



// Clause WHERE
sb.append("' WHERE productCode = '").append(bean.getProductCode()).append("'");

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
	ProductsDTO bean = (ProductsDTO)ab;
	StringBuilder sb=new StringBuilder();
	
	sb.append("WHERE productCode='").append(bean.getProductCode()).append("';");
	
	return sb.toString();
}





}
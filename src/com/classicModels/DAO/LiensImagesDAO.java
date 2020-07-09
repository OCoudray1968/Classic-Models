package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.LiensImageDTO;





public class LiensImagesDAO extends AbstractDAO {





public List<AbstractDTO> makeList(ResultSet rs) {
	List<AbstractDTO> l = new ArrayList<AbstractDTO>();
	
	try {
		while (rs.next()) {
			LiensImageDTO lienimages = new LiensImageDTO();
			
			lienimages.setCustomerNumber(rs.getInt("customer_number"));
			lienimages.setEmployeeNumber(rs.getInt("Employee_number"));
			lienimages.setProductCode(rs.getString("product_code"));
			lienimages.setIdImage(rs.getInt("id_image"));
								
			l.add(lienimages);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return l;
}	


public String generateWHEREquery(AbstractDTO li) {
// Marqueur permettant de savoir si la clause Where � d�j� commenc�e
boolean isWhereClause = false;

StringBuilder sb = new StringBuilder();
LiensImageDTO bean = (LiensImageDTO) li;

// Le num�ro de client
if (bean.getCustomerNumber() != 0) {
	isWhereClause = true;
	sb.append(" WHERE customer_number LIKE ")
	  .append(bean.getCustomerNumber());
}

// Le numero de l'employee
if (bean.getEmployeeNumber() != 0 && !(bean.getEmployeeNumber()>0)) {
	if (!isWhereClause) sb.append(" WHERE ");
	else 				sb.append(" OR ");
	
	sb.append("employee_number LIKE '")
	  .append(bean.getEmployeeNumber()).append("'");
}

// Le code du produit
if (bean.getProductCode() != null && !bean.getProductCode().isEmpty()) {
	if (!isWhereClause) sb.append(" WHERE ");
	else				sb.append(" OR ");
	
	sb.append("product_code LIKE '")
	  .append(bean.getProductCode()).append("'");
}

// Le product line
if (bean.getIdImage() != 0 && !(bean.getIdImage()==0)) {
	if (!isWhereClause) sb.append(" WHERE ");
	else				sb.append(" AND ");
	
	sb.append("id_image LIKE '")
	  .append(bean.getIdImage()).append("'");
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
public String generateINSERTquery(AbstractDTO lib) {
StringBuilder sb = new StringBuilder();
LiensImageDTO bean = (LiensImageDTO) lib;


// La ligne du produit
sb.append("'").append(bean.getCustomerNumber()).append("', ");

// L'echelle du produit
sb.append("'").append(bean.getEmployeeNumber()).append("', ");

// vendeur du produit
sb.append("'").append(bean.getProductCode()).append("', ");

// Description
sb.append("'").append(bean.getIdImage()).append("', ");


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
public  String generateUPDATEquery(AbstractDTO lib) {
StringBuilder sb = new StringBuilder();
LiensImageDTO bean= (LiensImageDTO) lib;

// Ligne du produit
sb.append("customer_number= '").append(bean.getCustomerNumber()).append("', ");

// Le nom du contact
sb.append("employee_number '").append(bean.getEmployeeNumber()).append("', ");

// Le vendeur
sb.append("product_code = '").append(bean.getProductCode()).append("', ");

// description du produit
sb.append("id_image = '").append(bean.getIdImage()).append("', ");


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

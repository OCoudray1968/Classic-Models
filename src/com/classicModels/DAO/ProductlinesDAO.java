package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.ProductLinesDTO;



public class ProductlinesDAO extends AbstractDAO  {


		
		public  List<AbstractDTO> makeList(ResultSet rs) {
			List<AbstractDTO> l = new ArrayList<AbstractDTO>();
			
			try {
				while (rs.next()) {
					ProductLinesDTO client = new ProductLinesDTO();
					
					client.setProductLine(rs.getString("productLine"));
					client.setTextDescription(rs.getString("textDescription"));
					client.setHtmlDescription(rs.getString("htmlDescription"));
					client.setImage(rs.getString("image"));
										
					l.add(client);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return l;
		}	

	public String generateWHEREquery(AbstractDTO plb) {
		// Marqueur permettant de savoir si la clause Where � d�j� commenc�e
		boolean isWhereClause = false;

		StringBuilder sb = new StringBuilder();
		ProductLinesDTO bean = (ProductLinesDTO) plb;
		System.out.println("valeur du productline :"+ bean.getProductLine());
		// La ligne de produit
		if (bean.getProductLine() != "") {
			isWhereClause = true;
			sb.append(" WHERE product_line LIKE ")
			  .append(bean.getProductLine());
		}
		
		// La description du produit
		if (bean.getTextDescription() != null && !bean.getTextDescription().isEmpty()) {
			if (!isWhereClause) sb.append(" WHERE ");
			else 				sb.append(" AND ");
			
			sb.append("text_desciption LIKE '")
			  .append(bean.getTextDescription()).append("'");
		}
		
		// HTML description
		if (bean.getHtmlDescription() != null && !bean.getHtmlDescription().isEmpty()) {
			if (!isWhereClause) sb.append(" WHERE ");
			else				sb.append(" AND ");
			
			sb.append("html_description LIKE '")
			  .append(bean.getHtmlDescription()).append("'");
		}
		
		// Image du produit
		if (bean.getImage() != null && !bean.getImage().isEmpty()) {
			if (!isWhereClause) sb.append(" WHERE ");
			else				sb.append(" AND ");
			
			sb.append("image LIKE '")
			  .append(bean.getImage()).append("'");
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
	public String generateINSERTquery(AbstractDTO ab) {
	StringBuilder sb = new StringBuilder();
	ProductLinesDTO bean = (ProductLinesDTO) ab;

	// La ligne du produit
	sb.append("'").append(bean.getProductLine()).append("', ");

	// L'echelle du produit
	sb.append("'").append(bean.getTextDescription()).append("', ");

	// vendeur du produit
	sb.append("'").append(bean.getHtmlDescription()).append("', ");

	// Description
	sb.append("'").append(bean.getImage()).append("', ");


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
	public String generateUPDATEquery(AbstractDTO ab) {
	StringBuilder sb = new StringBuilder();
	ProductLinesDTO bean = (ProductLinesDTO) ab;

	// Ligne du produit
	sb.append("product_line= '").append(bean.getProductLine()).append("', ");

	// Le nom du contact
	sb.append("text_description = '").append(bean.getTextDescription()).append("', ");

	// Le vendeur
	sb.append("html_description = '").append(bean.getHtmlDescription()).append("', ");

	// description du produit
	sb.append("image = '").append(bean.getImage()).append("', ");


	// Clause WHERE
	sb.append("' WHERE product_line = ").append(bean.getProductLine());

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

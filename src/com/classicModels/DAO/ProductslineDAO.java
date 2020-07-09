package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.beans.ProductLinesBean;





public interface ProductslineDAO {

		public static List<ProductLinesBean> getRecords(ProductLinesBean bean) {
			List<ProductLinesBean> listeBeans = new ArrayList<ProductLinesBean>();
			
			List<Object> liste = listAll(bean);
			
			for (Object o : liste) {
				listeBeans.add((ProductLinesBean)o);
			}
			
			return listeBeans;
		}

		public static List<Object> listAll(ProductLinesBean bean) {
			// TODO Auto-generated method stub
			return null;
		}
	//@Override
		
		public static List<ProductLinesBean> makeList(ResultSet rs) {
			List<ProductLinesBean> l = new ArrayList<ProductLinesBean>();
			
			try {
				while (rs.next()) {
					ProductLinesBean client = new ProductLinesBean();
					
					client.setProductLine(rs.getString("product_line"));
					client.setTextDescription(rs.getString("text_description"));
					client.setHtmlDescription(rs.getString("html_description"));
					client.setImage(rs.getString("image"));
										
					l.add(client);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return l;
		}	
//	public ProductLinesBean retreive(int ProductLine);
//
//	public static String generateWHEREquery(ProductLinesBean plb) {
//		// Marqueur permettant de savoir si la clause Where � d�j� commenc�e
//		boolean isWhereClause = false;
//
//		StringBuilder sb = new StringBuilder();
//		ProductLinesBean bean = plb;
//		
//		// La ligne de produit
//		if (bean.getProductLine() != null) {
//			isWhereClause = true;
//			sb.append(" WHERE product_line LIKE ")
//			  .append(bean.getProductLine());
//		}
//		
//		// La description du produit
//		if (bean.getTextDescription() != null && !bean.getTextDescription().isEmpty()) {
//			if (!isWhereClause) sb.append(" WHERE ");
//			else 				sb.append(" AND ");
//			
//			sb.append("text_desciption LIKE '")
//			  .append(bean.getTextDescription()).append("'");
//		}
//		
//		// HTML description
//		if (bean.getHtmlDescription() != null && !bean.getHtmlDescription().isEmpty()) {
//			if (!isWhereClause) sb.append(" WHERE ");
//			else				sb.append(" AND ");
//			
//			sb.append("html_description LIKE '")
//			  .append(bean.getHtmlDescription()).append("'");
//		}
//		
//		// Image du produit
//		if (bean.getImage() != null && !bean.getImage().isEmpty()) {
//			if (!isWhereClause) sb.append(" WHERE ");
//			else				sb.append(" AND ");
//			
//			sb.append("image LIKE '")
//			  .append(bean.getImage()).append("'");
//		}
//		
//		
//		
//		return sb.toString();
//	}
//
//	/*
//	 * G�n�re la seconde partie d'une requ�te INSERT*
//	 * VALUES (
//	 *   'valeur 1', 'valeur 2', ...
//	 * )
//	 * 
//	 * * seulement la liste des valeurs (2 lg)
//	 */	
//	public static String generateINSERTquery(ProductLinesBean bean) {
//	StringBuilder sb = new StringBuilder();
//
//
//	// La ligne du produit
//	sb.append("'").append(bean.getProductLine()).append("', ");
//
//	// L'echelle du produit
//	sb.append("'").append(bean.getTextDescription()).append("', ");
//
//	// vendeur du produit
//	sb.append("'").append(bean.getHtmlDescription()).append("', ");
//
//	// Description
//	sb.append("'").append(bean.getImage()).append("', ");
//
//
//	return sb.toString();
//	}
//
//
//	/**
//	* La requ�te sql est
//	* UPDATE table 
//	*   SET colonne_1 = 'valeur 1', colonne_2 = 'valeur 2', colonne_3 = 'valeur 3'
//	*   WHERE condition
//	* 
//	* Nous nous occupons juste du SET
//	* @param bean
//	*/
//	public static String generateUPDATEquery(ProductLinesBean bean) {
//	StringBuilder sb = new StringBuilder();
//
//	// Ligne du produit
//	sb.append("product_line= '").append(bean.getProductLine()).append("', ");
//
//	// Le nom du contact
//	sb.append("text_description = '").append(bean.getTextDescription()).append("', ");
//
//	// Le vendeur
//	sb.append("html_description = '").append(bean.getHtmlDescription()).append("', ");
//
//	// description du produit
//	sb.append("image = '").append(bean.getImage()).append("', ");
//
//
//	// Clause WHERE
//	sb.append("' WHERE product_line = ").append(bean.getProductLine());
//
//	return sb.toString();
//	}

	public List<ProductLinesBean> lister();

	public static Object generateINSERTquery(ProductLinesBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object generateWHEREquery(ProductLinesBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object generateUPDATEquery(ProductLinesBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void create(ProductLinesBean bean) {
		// TODO Auto-generated method stub
		
	}

	public static void delete(ProductLinesBean bean) {
		// TODO Auto-generated method stub
		
	}

	public static void update(ProductLinesBean bean) {
		// TODO Auto-generated method stub
		
	}

	public static List<?> listAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}

package com.classicModels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.ImagesDTO;


public class ImageDAO extends AbstractDAO{

	
		
		public  List<AbstractDTO> makeList(ResultSet rs) {
			List<AbstractDTO> l = new ArrayList<AbstractDTO>();
			
			try {
				while (rs.next()) {
					ImagesDTO image = new ImagesDTO();
					
					image.setIdImage(rs.getInt("id_image"));
					image.setNomImage(rs.getString("nom_image"));
					image.setLabelImage(rs.getString("label_image"));
					image.setTagsImage(rs.getString("tags_image"));
										
					l.add(image);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return l;
		}	
	
	public String generateWHEREquery(AbstractDTO ib) {
		// Marqueur permettant de savoir si la clause Where à commencé
		boolean isWhereClause = false;

		StringBuilder sb = new StringBuilder();
		ImagesDTO bean = (ImagesDTO) ib;
	
		// L'id de l'image
		if (bean.getIdImage() != 0) {
			isWhereClause = true;
			sb.append(" WHERE id_image LIKE ")
			  .append(bean.getIdImage());
			
			
		}
		
		// Le nom de l image
		if (bean.getNomImage() != null && !bean.getNomImage().isEmpty()) {
			if (!isWhereClause) sb.append(" WHERE ");
			else 				sb.append(" AND ");
			
			sb.append("nom_image LIKE '")
			  .append(bean.getNomImage()).append("'");
		}
		
		// Le label d el 'image
		if (bean.getLabelImage()!= null && !bean.getLabelImage().isEmpty()) {
			if (!isWhereClause) sb.append(" WHERE ");
			else				sb.append(" AND ");
			
			sb.append("label_image LIKE '")
			  .append(bean.getLabelImage()).append("'");
		}
		
		// Le tag de l'image
		if (bean.getTagsImage()!= null && !bean.getTagsImage().isEmpty()) {
			if (!isWhereClause) sb.append(" WHERE ");
			else				sb.append(" AND ");
			
			sb.append("image LIKE '")
			  .append(bean.getTagsImage()).append("'");
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
	public String generateINSERTquery(AbstractDTO ib) {
	StringBuilder sb = new StringBuilder();
	ImagesDTO bean=(ImagesDTO) ib;


	// La ligne du produit
	sb.append("'").append(bean.getIdImage()).append("', ");

	// L'echelle du produit
	sb.append("'").append(bean.getNomImage()).append("', ");

	// vendeur du produit
	sb.append("'").append(bean.getLabelImage()).append("', ");

	// Description
	sb.append("'").append(bean.getTagsImage()).append("', ");


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
	public String generateUPDATEquery(AbstractDTO ib) {
	StringBuilder sb = new StringBuilder();
	ImagesDTO bean = (ImagesDTO) ib;

	
	// Le nom du contact
	sb.append("nom_image = '").append(bean.getNomImage()).append("', ");

	// Le vendeur
	sb.append("label_image = '").append(bean.getLabelImage()).append("', ");

	// description du produit
	sb.append("tags_image = '").append(bean.getTagsImage()).append("', ");


	// Clause WHERE
	sb.append("' WHERE id_image = ").append(bean.getIdImage());

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

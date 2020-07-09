package com.classicModels.DAO;

import java.sql.ResultSet;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;



public interface iDAO {
	// Méthodes à implémenter dans les classes filles
	public String generateINSERTquery(AbstractDTO bean);
	public String generateUPDATEquery(AbstractDTO bean);
	public String generateWHEREquery(AbstractDTO bean) ;
	public String generateLASTquery(AbstractDTO bean);
	public String generateDeletequery(AbstractDTO bean);
	public String generateUnionQuery(AbstractDTO bean);
	public List<AbstractDTO> makeList(ResultSet rs);
	public List<AbstractDTO> makeListOrdersInProcess(ResultSet rs);
}
package com.classicModels.managers;


import java.util.List;
import com.classicModels.DAO.ProductsDAO;
import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.ProductsDTO;




public class ProductsManager  {
	 
	    public static void update(AbstractDTO source, AbstractDTO cible) {
	        ProductsDTO dtoSource = (ProductsDTO) source;
	        ProductsDTO dtoCible = (ProductsDTO) cible;
	       
	        
	        dtoCible.setProductCode(dtoSource.getProductCode());
			
			if (dtoCible.getProductName().isEmpty())
			    dtoCible.setProductName(dtoSource.getProductName());
		
			if (dtoCible.getProductLine().isEmpty())
			    dtoCible.setProductLine(dtoSource.getProductLine());
		
			if (dtoCible.getProductScale().isEmpty())
			    dtoCible.setProductScale(dtoSource.getProductScale());
		
			if (dtoCible.getProductVendor().isEmpty())
			    dtoCible.setProductVendor(dtoSource.getProductVendor());
		
			if (dtoCible.getProductDescription().isEmpty())
			    dtoCible.setProductDescription(dtoSource.getProductDescription());
		
			if (dtoCible.getQuantityInStock()==0)
			    dtoCible.setQuantityInStock(dtoSource.getQuantityInStock());
		
			if (dtoCible.getBuyPrice() == 0)
			    dtoCible.setBuyPrice(dtoSource.getBuyPrice());
		
			if (dtoCible.getMsrp() == 0)
			    dtoCible.setMsrp(dtoSource.getMsrp());
		
			
			ProductsDAO product = new ProductsDAO() ;
		
			product.update(dtoCible);
	    }

	    
	    /**
	     * Retourne une liste de DTOs correspondant à la liste des enregistrements présent dans la table <code>classicmodels.Customers</code>.
	     * 
	     */
	    public static List<AbstractDTO> listAll() {
	    	ProductsDAO product = new ProductsDAO();
	    	return product.listAll(new ProductsDTO());
	    }


		/**
		 * Retourne un seul enregistrement
		 * @param bean
		 * @return
		 */
		public static AbstractDTO getRecord(AbstractDTO bean) {
			ProductsDAO product = new ProductsDAO(); 
			List <AbstractDTO>l = product.listAll(bean);
		
			return l.get(0);
		}
		
		/**
		 * Insère un enregistrement
		 * @param bean
		 */
		public static void setRecord(AbstractDTO bean) {
			ProductsDAO product = new ProductsDAO();
			product.create(bean);
		}


		public static List<AbstractDTO> listAll(ProductsDTO produit) {
			ProductsDAO product = new ProductsDAO(); 
			List <AbstractDTO>l = product.listAll(produit);
			return l;
		}

		/**
		 * supprime un enregistrement
		 * @param bean
		 * @return
		 */
		public static void delRecord(AbstractDTO bean) {
			ProductsDAO produit= new ProductsDAO(); 
			produit.delete(bean);
		
		}


	}

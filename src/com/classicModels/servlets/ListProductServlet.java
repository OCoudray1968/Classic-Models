package com.classicModels.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductsManager;


public class ListProductServlet extends HttpServlet{
	
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static final String ATT_PRODUCTLINES = "productline";
		public static final String ATT_PRODUCTS = "produit";
	    public static final String ATT_FORM     = "form";

	
	    public static final String VUE         = "/WEB-INF/catalogue.jsp";
	 
	    private String productline;
	    
	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    	productline = request.getParameter("productline");
	    	ProductsDTO produits = ManagerFactory.getProducts();
		    produits.setProductLine(productline);
		 
		   List<AbstractDTO> produit = ProductsManager.listAll(produits);
		   request.setAttribute( ATT_PRODUCTS,produit );     

	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
	    
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	//    	HttpSession sessioncategorie = request.getSession();
    	
	    	productline = request.getParameter(ATT_PRODUCTLINES);
	    	ProductsDTO produits = ManagerFactory.getProducts();
		    produits.setProductLine(productline);
		 	List<AbstractDTO> produit = ProductsManager.listAll(produits);
		 	System.out.println("la liste de sproduits est :"+produit);
         	request.setAttribute( ATT_PRODUCTS,produit );
	      

	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }


}

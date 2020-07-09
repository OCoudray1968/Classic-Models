package com.classicModels.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductsManager;



/**
 * Servlet implementation class ListProductCommandeServlet
 */
@WebServlet("/ListProductCommandeServlet")
public class ListProductCommandeServlet extends HttpServlet {
	
		  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public static final String ATT_PRODUCTLINES = "productline";
			public static final String ATT_PRODUCTS     = "produit";
			public static final String ATT_PANIER       = "panier";
			public static final String ATT_INDEX        ="lignePanier";
		    public static final String ATT_FORM         = "form";

		
		    public static final String VUE         = "/WEB-INF/catalogueCommande.jsp";
		 
		
		    private String productline;
		    private String codeProduit;
		    private String qty=null;
		    private String prix;
		    private String index=null;
		    private Integer indexPanier=0;
		 
		    private List<OrderDetailsDTO> panier = new ArrayList<OrderDetailsDTO>();
		    
		    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
				    
		    	productline = request.getParameter(ATT_PRODUCTLINES);
		       	System.out.println("GET du productline:"+ productline );
			    ProductsDTO produits = ManagerFactory.getProducts();
			    produits.setProductLine(productline);
			 
			    	
						List<AbstractDTO> produit = ProductsManager.listAll(produits);
			              	
		    	
				index=request.getParameter(ATT_INDEX);
			
				if(index!=null) {
				
					panier.remove(Integer.parseInt(index));
				}
				request.setAttribute(ATT_PANIER,panier);
			  	request.setAttribute(ATT_PRODUCTS,produit);
		        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		    }
		    
		    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		       
		    	HttpSession sessionPanier = request.getSession();

		    	productline = request.getParameter(ATT_PRODUCTLINES);
		
			    ProductsDTO produits = ManagerFactory.getProducts();
			    produits.setProductLine(productline);
//			 	    	
				List<AbstractDTO> produit = ProductsManager.listAll(produits);
			   	HttpSession sessionproduit = request.getSession();

			      		
				sessionproduit.setAttribute(ATT_PRODUCTS, produit);
			   	request.setAttribute( ATT_PRODUCTS,produit );
		
	
		    	codeProduit=request.getParameter("codeProduit");
				qty=request.getParameter("quantite");
				prix=request.getParameter("prix");
				index=request.getParameter("index");
			
				System.out.println(codeProduit+" "+qty+" "+prix+" "+index);
			
				if (qty!=null) {
				OrderDetailsDTO produitselect = new OrderDetailsDTO();
				produitselect.setProductCode(codeProduit);
				produitselect.setQuantityOrdered((Integer.parseInt(qty)));
				produitselect.setPriceEach(Double.parseDouble(prix));
			
			//	System.out.println("valeur de l'index :"+Integer.parseInt(index));
				produitselect.setOrderLineNumber(indexPanier);
			
				
				panier.add(produitselect);
				indexPanier++;
		    	 System.out.println("mon panier :"+panier);
		    	 	
				}
			
			
		    	request.setAttribute(ATT_PRODUCTS,produit);
		    	request.setAttribute(ATT_PANIER,panier); 
		    	   
		        sessionPanier.setAttribute(ATT_PANIER, panier);
		    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		    }
}
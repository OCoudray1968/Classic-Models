package com.classicModels.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.AbstractDTO;

import com.classicModels.managers.ProductLinesManager;

/**
 * Servlet implementation class CategorieCommandeServlet
 */
@WebServlet("/CategorieCommandeServlet")
public class CategorieCommandeServlet extends HttpServlet {
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static final String ATT_PRODUCTS         = "categorie";
	    public static final String ATT_FORM             = "form";
	    public static final String VUE                  = "/WEB-INF/categorieCommande.jsp";
	    


	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    
	    	List<AbstractDTO> categorie = ProductLinesManager.listAll();
			
			HttpSession sessioncategorie = request.getSession();

      		System.out.println("liste categorie en post:"+categorie);
      		sessioncategorie.setAttribute(ATT_PRODUCTS, categorie);
         	request.setAttribute( ATT_PRODUCTS,categorie );
	    	
	  	  
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
	    
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    
	 
	    	
				List<AbstractDTO> categorie = ProductLinesManager.listAll();
				
				HttpSession sessioncategorie = request.getSession();

	      		System.out.println("liste categorie en post:"+categorie);
	      		sessioncategorie.setAttribute(ATT_PRODUCTS, categorie);
	         	request.setAttribute( ATT_PRODUCTS,categorie );
				
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
}

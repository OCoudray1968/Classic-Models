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
import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductsManager;

/**
 * Servlet implementation class UpdateCustomersServlet
 */
@WebServlet("/updateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_PRODUIT = "produits";
	public static final String ATT_EMPLOYEE		  ="employee";	
 

    public static final String VUE        = "/WEB-INF/modifierProduits.jsp";
    public static final String VUE1        = "/WEB-INF/modifierChampsProduit.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
    	
	/**
	 * List de tout les codes produits
	 */
  
    	    List<AbstractDTO> produits = ProductsManager.listAll();
    	      		
      		session.setAttribute(ATT_PRODUIT, produits);
         	request.setAttribute( ATT_PRODUIT,produits );
         	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		/**
		 * Récupération du code produit produit pour recuperer l'enregistrement coprrespondant
		 */
		String productCode =request.getParameter("codeproduit");
		ProductsDTO produit =ManagerFactory.getProducts();
		produit.setProductCode(productCode);
		produit=(ProductsDTO) ProductsManager.getRecord(produit);
		session.setAttribute(ATT_PRODUIT, produit);
     	request.setAttribute( ATT_PRODUIT,produit );
     	this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
	}

}

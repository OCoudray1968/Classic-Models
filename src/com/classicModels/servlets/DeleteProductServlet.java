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
 * Servlet implementation class DeleteCustomersServlet
 */
@WebServlet("/deleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	public static final String ATT_PRODUIT = "produits";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/supprimerProduit.jsp";
    public static final String VUE1		  = "/WEB-INF/validerSupprimerProduit.jsp";
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    		HttpSession session =request.getSession();
              	
        
        
        //	    CustomersDTO client = ManagerFactory.getCustomers();
        	    List<AbstractDTO> produits = ProductsManager.listAll();
        	       		
          		session.setAttribute(ATT_PRODUIT, produits);
             	request.setAttribute( ATT_PRODUIT,produits);
             	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession session=request.getSession();
    		String productCode =request.getParameter("productcode");
    		
    		ProductsDTO produit =ManagerFactory.getProducts();
    		produit.setProductCode(productCode);
    		produit=(ProductsDTO) ProductsManager.getRecord(produit);
    	
    		session.setAttribute(ATT_PRODUIT, produit);
         	request.setAttribute( ATT_PRODUIT,produit );
    		this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
    	}
}

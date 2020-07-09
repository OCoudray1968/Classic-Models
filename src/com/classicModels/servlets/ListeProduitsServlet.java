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
 * Servlet implementation class ListeProduitsServlet
 */
@WebServlet("/listeProduitsServlet")
public class ListeProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_PRODUCTLINES = "productline";
	public static final String ATT_PRODUCTS = "produits";
    public static final String ATT_FORM     = "form";


    public static final String VUE         = "/WEB-INF/listerProduits.jsp";
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeProduitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private String productline;
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
	   List<AbstractDTO> produits = ProductsManager.listAll();
		session.setAttribute( ATT_PRODUCTS,produits );  

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
//    	HttpSession sessioncategorie = request.getSession();
    	HttpSession session = request.getSession();
    	productline = request.getParameter(ATT_PRODUCTLINES);
    	ProductsDTO produits = ManagerFactory.getProducts();
	    produits.setProductLine(productline);
	 	List<AbstractDTO> produit = ProductsManager.listAll(produits);
	 	System.out.println("la liste des produits est :"+produit);
     	session.setAttribute( ATT_PRODUCTS,produit );
      

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }



}

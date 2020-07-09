package com.classicModels.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductsManager;

/**
 * Servlet implementation class ValidateDeleteCustomerServlet
 */
@WebServlet("/validateDeleteProductServlet")
public class ValidateDeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateDeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public static final String ATT_PRODUIT = "produits";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/menuProduits.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productCode =request.getParameter("productcode");
	
		ProductsDTO produit =ManagerFactory.getProducts();
		produit.setProductCode(productCode);
		ProductsManager.delRecord(produit);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

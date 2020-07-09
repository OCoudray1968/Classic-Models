package com.classicModels.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/produitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_PRODUIT = "produits";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/menuProduits.jsp";   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
   	 
    	
		  
    	EmployeesDTO employee = ManagerFactory.GetEmployees();
    	employee=	(EmployeesDTO) session.getAttribute(ATT_EMPLOYEE);
    	   
    
    			
      		session.setAttribute(ATT_EMPLOYEE, employee);

    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

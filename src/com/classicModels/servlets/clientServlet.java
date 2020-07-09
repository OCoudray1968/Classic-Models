package com.classicModels.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class clientServlet
 */
@WebServlet("/clientServlet")
public class clientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_OFFICE = "clients";
	public static final String ATT_CUSTOMER		  ="client";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/menuClients.jsp";   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
   	 
    	
		  
    	CustomersDTO client = ManagerFactory.getCustomers();
    	client=	(CustomersDTO) session.getAttribute(ATT_CUSTOMER);
    	   
    
    			
      	session.setAttribute(ATT_CUSTOMER, client);

    	
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

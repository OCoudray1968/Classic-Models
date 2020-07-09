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
import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.EmployeesDTO;

import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;


@WebServlet("/listCustomersServlet")
public class ListCustomersServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_CLIENT = "clients";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/listerClients.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	HttpSession session =request.getSession();
    	    	
  
    	EmployeesDTO employee = ManagerFactory.GetEmployees();
    	employee=	(EmployeesDTO) session.getAttribute(ATT_EMPLOYEE);
    	
    
    
    	    CustomersDTO client = ManagerFactory.getCustomers();
    	    List<AbstractDTO> clients;
    	    if (employee.getEmployeeNumber()!=1713) {
         	client.setSalesRepEmployeeNumber((int) employee.getEmployeeNumber());
         	 clients = CustomersManager.listAll(client);
    	    } else {
    	    
			 clients = CustomersManager.listAll();
    	    }
			System.out.println(clients);   		
      		session.setAttribute(ATT_CLIENT, clients);
         	request.setAttribute( ATT_CLIENT,clients );
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
       
    }
}
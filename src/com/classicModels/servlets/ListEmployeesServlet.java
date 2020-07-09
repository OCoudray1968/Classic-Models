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
import com.classicModels.managers.EmployeesManager;




@WebServlet("/listEmployeesServlet")
public class ListEmployeesServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_EMPLOYEES = "employees";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/listerEmployees.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	HttpSession session =request.getSession();
    	    	
  
   // 	EmployeesDTO employee = ManagerFactory.GetEmployees();
   // 	employee=	(EmployeesDTO) session.getAttribute(ATT_EMPLOYEE);
    	
    
    
    	  List<AbstractDTO> employees = EmployeesManager.listAll();
   	      		
    		session.setAttribute(ATT_EMPLOYEES, employees);
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
       
    }
}
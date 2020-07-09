package com.classicModels.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.managers.EmployeesManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class ValidateDeleteCustomerServlet
 */
@WebServlet("/validateDeleteEmployeeServlet")
public class ValidateDeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateDeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public static final String ATT_EMPLOYEES = "employees";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/menuEmployees.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    		HttpSession session =request.getSession();
    	    String numEmployee = request.getParameter("NumEmployee");	
    	    
    	
    	    EmployeesDTO employees = ManagerFactory.GetEmployees();
    	    employees.setEmployeeNumber(Long.parseLong(numEmployee));
    //	  CustomersManager.
      		session.setAttribute(ATT_EMPLOYEES, employees);
         	request.setAttribute( ATT_EMPLOYEES,employees );
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String numEmployees =request.getParameter("EmployeeNumber");
		EmployeesDTO employees =ManagerFactory.GetEmployees();
		employees.setEmployeeNumber(Long.parseLong(numEmployees));
		EmployeesManager.delRecord(employees);
		session.setAttribute(ATT_EMPLOYEES, employees);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

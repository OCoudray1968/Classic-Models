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
import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.managers.EmployeesManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class UpdateCustomersServlet
 */
@WebServlet("/updateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_EMPLOYEES = "employees";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/modifierEmployee.jsp";
    public static final String VUE1        = "/WEB-INF/modifierChampsEmployee.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
    	
		  
//    	EmployeesDTO employee = ManagerFactory.GetEmployees();
//    	employee=	(EmployeesDTO) session.getAttribute(ATT_EMPLOYEE);
//    	
    
    
    //	    CustomersDTO client = ManagerFactory.getCustomers();
    	    List<AbstractDTO> employees = EmployeesManager.listAll();
    	      		
      		session.setAttribute(ATT_EMPLOYEES, employees);
         	request.setAttribute( ATT_EMPLOYEES,employees );
         	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String numEmployee =request.getParameter("NumEmployee");
	
		EmployeesDTO employees =ManagerFactory.GetEmployees();
		employees.setEmployeeNumber(Integer.parseInt(numEmployee));
		employees=(EmployeesDTO) EmployeesManager.getRecord(employees);
	//	client.setCustomerNumber(customerNumber);
		session.setAttribute(ATT_EMPLOYEES, employees);
     	request.setAttribute( ATT_EMPLOYEES,employees );
     	this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
	}

}

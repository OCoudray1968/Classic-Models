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
 * Servlet implementation class DeleteCustomersServlet
 */
@WebServlet("/deleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	public static final String ATT_EMPLOYEES = "employees";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/supprimerEmployee.jsp";
    public static final String VUE1		  = "/WEB-INF/validerSupprimerEmployee.jsp";
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    		HttpSession session =request.getSession();
              	
        
        
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
    		
    		EmployeesDTO employee =ManagerFactory.GetEmployees();
    		employee.setEmployeeNumber(Integer.parseInt(numEmployee));
    		employee=(EmployeesDTO) EmployeesManager.getRecord(employee);
    	
    		session.setAttribute(ATT_EMPLOYEES, employee);
         	request.setAttribute( ATT_EMPLOYEES,employee );
    		this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
    	}
}

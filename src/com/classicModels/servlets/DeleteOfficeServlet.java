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
import com.classicModels.DTO.OfficesDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OfficesManager;

/**
 * Servlet implementation class DeleteCustomersServlet
 */
@WebServlet("/deleteOfficeServlet")
public class DeleteOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	public static final String ATT_OFFICE = "offices";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/supprimerOffice.jsp";
    public static final String VUE1		  = "/WEB-INF/validerSupprimerOffice.jsp";
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    		HttpSession session =request.getSession();
        	
    		  
        	@SuppressWarnings("unused")
			EmployeesDTO employee = ManagerFactory.GetEmployees();
        	employee=	(EmployeesDTO) session.getAttribute(ATT_EMPLOYEE);
        	
        
        
        //	    CustomersDTO client = ManagerFactory.getCustomers();
        	    List<AbstractDTO> offices = OfficesManager.listAll();
        	        			  		
          		session.setAttribute(ATT_OFFICE, offices);
             	request.setAttribute( ATT_OFFICE,offices );
             	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession session=request.getSession();
    		String officeCode =request.getParameter("OfficeCode");
    		System.out.println("numero client dans le post"+officeCode);
    		OfficesDTO office =ManagerFactory.getOffices();
    		office.setOfficeCode(Integer.parseInt(officeCode));
    		office=(OfficesDTO) OfficesManager.getRecord(office);
    	//	client.setCustomerNumber(customerNumber);
    		session.setAttribute(ATT_OFFICE, office);
         	request.setAttribute( ATT_OFFICE,office); 
    		this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
    	}
}

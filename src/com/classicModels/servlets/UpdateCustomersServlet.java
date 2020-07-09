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
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class UpdateCustomersServlet
 */
@WebServlet("/updateCustomersServlet")
public class UpdateCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_CLIENT = "clients";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/modifierClients.jsp";
    public static final String VUE1        = "/WEB-INF/modifierChampsClient.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
    	
//		  
//    	EmployeesDTO employee = ManagerFactory.GetEmployees();
//    	employee=	(EmployeesDTO) session.getAttribute(ATT_EMPLOYEE);
    	
    
    
    //	    CustomersDTO client = ManagerFactory.getCustomers();
    	    List<AbstractDTO> clients = CustomersManager.listAll();
    	    
			System.out.println(clients);   		
      		session.setAttribute(ATT_CLIENT, clients);
         	request.setAttribute( ATT_CLIENT,clients );
         	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String numClient =request.getParameter("NumClient");
		System.out.println("numero client dans le post"+numClient);
		CustomersDTO client =ManagerFactory.getCustomers();
		client.setCustomerNumber(Integer.parseInt(numClient));
		client=(CustomersDTO) CustomersManager.getRecord(client);
	//	client.setCustomerNumber(customerNumber);
		session.setAttribute(ATT_CLIENT, client);
     	request.setAttribute( ATT_CLIENT,client );
     	this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
	}

}

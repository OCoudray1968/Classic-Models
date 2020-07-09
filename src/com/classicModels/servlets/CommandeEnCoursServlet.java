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
import com.classicModels.forms.CommandeEncoursForm;
import com.classicModels.managers.ManagerFactory;


/**
 * Servlet implementation class CommandeEnCoursServlet
 */
@WebServlet("/commandeEnCoursServlet")
public class CommandeEnCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_EMPLOYEE		  ="employee";	
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_COMMANDE = "commandes";
    public static final String ATT_FORM     = "form";

    public static final String VUE          = "/WEB-INF/commandesATraiter.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeEnCoursServlet() {
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
    	Long salesRep=employee.getEmployeeNumber();
    
		CommandeEncoursForm form = new CommandeEncoursForm();
		form.CommandeATraiter(salesRep);
		List<AbstractDTO> commande = form.getCommandes();
		System.out.println("commmande dans le get:"+commande);
	
         	HttpSession sessioncommande = request.getSession();
			session.setAttribute(ATT_EMPLOYEE, employee);
      		sessioncommande.setAttribute(ATT_COMMANDE, commande);
     //  	request.setAttribute( ATT_COMMANDE,commande );
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	  	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

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
import com.classicModels.DTO.RegistrationDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.RegistrationManager;


/**
 * Servlet implementation class ValidateUpdateCustomersServlet
 */
@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE       = "/WEB-INF/registration.jsp";
	public static final String VUE1       = "/WEB-INF/validerInscription.jsp";
	public static final String ATT_REGISTRATION	="registrations";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession registration = request.getSession();
		List<AbstractDTO> newclient= RegistrationManager.listAll();
		System.out.println("liste du registre:"+newclient);
		registration.setAttribute(ATT_REGISTRATION,newclient);
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String numDemande =request.getParameter("NumDemande");
		System.out.println("numero demande dans le post"+numDemande);
		RegistrationDTO demande =ManagerFactory.getRegistration();
		demande.setCustomerNumber(Integer.parseInt(numDemande));
		demande=(RegistrationDTO) RegistrationManager.getRecord(demande);
	//	client.setCustomerNumber(customerNumber);
		session.setAttribute(ATT_REGISTRATION, demande);
     	request.setAttribute( ATT_REGISTRATION,demande );
		this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
		
		
		this.getServletContext().getRequestDispatcher( VUE1).forward( request, response );
	}

}

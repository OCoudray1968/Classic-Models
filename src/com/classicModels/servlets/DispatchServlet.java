package com.classicModels.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.forms.ConnectionForms;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.EmployeesManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class DispatchServlet
 */
@WebServlet("/DispatchServlet")
public class DispatchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_LOGIN = "utilisateur";
	public static final String ATT_PWD = "password";
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_SESSION_LOGINS = "utilisateur";
	public static final String VUE = "/WEB-INF/connexion.jsp";
	public static final String VUE_EMPLOYE = "/WEB-INF/headerEmployee.jsp";
	public static final String VUE_CLIENT = "/WEB-INF/headerCustomer.jsp";
	public static final String VUE_ADMIN = "/WEB-INF/headerAdmin.jsp";
	public static final String ERROR_MESSAGE = "Login ou Mot de passe incorrect";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatchServlet() {
		super();
		// On utilise que le poste
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//

		HttpSession session = request.getSession();

		ConnectionForms form = new ConnectionForms();
		form.verificationLogin(request);

		/**
		 * On récupere les données des utilisateurs et on dispatch les vues en fonction
		 * du profil du login
		 */
		if (form.getProfil() != 0) {
			switch (form.getProfil()) {
			// cas pour un client
			case 4:

				CustomersDTO client = ManagerFactory.getCustomers();

				client.setCustomerNumber(form.getNumber());

				client = (CustomersDTO) CustomersManager.getRecord(client);

				session.setAttribute(ATT_CUSTOMER, client);
				request.setAttribute(ATT_CUSTOMER, client);

				request.getServletContext().setAttribute(ATT_CUSTOMER, client);
				request.getRequestDispatcher(VUE_CLIENT).forward(request, response);
				break;
			// cas pour un employé
			case 2:

				EmployeesDTO employees = ManagerFactory.GetEmployees();

				employees.setEmployeeNumber(form.getNumber());

				employees = (EmployeesDTO) EmployeesManager.getRecord(employees);

				request.setAttribute(ATT_EMPLOYEE, employees);
				session.setAttribute(ATT_EMPLOYEE, employees);

				request.getServletContext().setAttribute(ATT_EMPLOYEE, employees);
				request.getRequestDispatcher(VUE_EMPLOYE).forward(request, response);
				break;
			// cas pour l'administrateur
			case 1:
				EmployeesDTO admin = ManagerFactory.GetEmployees();

				admin.setEmployeeNumber(form.getNumber());

				admin = (EmployeesDTO) EmployeesManager.getRecord(admin);

				request.setAttribute(ATT_EMPLOYEE, admin);
				session.setAttribute(ATT_EMPLOYEE, admin);

				request.getServletContext().setAttribute(ATT_EMPLOYEE, admin);
				request.getRequestDispatcher(VUE_ADMIN).forward(request, response);

				break;
			// message d'erreur si le login ou le password sont incorrects
			default:
				request.setAttribute(ERROR_MESSAGE, form);
				request.getServletContext().setAttribute(ERROR_MESSAGE, form);
				request.getRequestDispatcher(VUE).forward(request, response);
				break;

			}
		} else {
			String resultat = form.getResultat();
			session.setAttribute(resultat, form);
			request.getServletContext().setAttribute(resultat, form);
			request.getRequestDispatcher(VUE).forward(request, response);

		}
	}

}

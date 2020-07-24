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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ConnectionForms form = new ConnectionForms();
		form.verificationLogin(request);
		System.out.println("num profil :" + form.getProfil());
		switch (form.getProfil()) {

		case 4:

			CustomersDTO client = ManagerFactory.getCustomers();

			client.setCustomerNumber(form.getNumber());

			client = (CustomersDTO) CustomersManager.getRecord(client);

			session.setAttribute(ATT_CUSTOMER, client);
			request.setAttribute(ATT_CUSTOMER, client);

			this.getServletContext().getRequestDispatcher(VUE_CLIENT).forward(request, response);
			break;
		case 2:

			EmployeesDTO employees = ManagerFactory.GetEmployees();

			employees.setEmployeeNumber(form.getNumber());

			employees = (EmployeesDTO) EmployeesManager.getRecord(employees);

			request.setAttribute(ATT_EMPLOYEE, employees);
			session.setAttribute(ATT_EMPLOYEE, employees);
			this.getServletContext().getRequestDispatcher(VUE_EMPLOYE).forward(request, response);
			break;
		case 1:
			EmployeesDTO admin = ManagerFactory.GetEmployees();

			admin.setEmployeeNumber(form.getNumber());

			admin = (EmployeesDTO) EmployeesManager.getRecord(admin);

			request.setAttribute(ATT_EMPLOYEE, admin);
			session.setAttribute(ATT_EMPLOYEE, admin);
			this.getServletContext().getRequestDispatcher(VUE_ADMIN).forward(request, response);
			break;
		default:
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			break;

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//

		HttpSession session = request.getSession();
		ConnectionForms form = new ConnectionForms();
		form.verificationLogin(request);
		System.out.println("num profil :" + form.getProfil());
		if (form.getProfil() != null) {
			switch (form.getProfil()) {

			case 4:

				CustomersDTO client = ManagerFactory.getCustomers();

				client.setCustomerNumber(form.getNumber());

				client = (CustomersDTO) CustomersManager.getRecord(client);

				session.setAttribute(ATT_CUSTOMER, client);
				request.setAttribute(ATT_CUSTOMER, client);

				this.getServletContext().getRequestDispatcher(VUE_CLIENT).forward(request, response);
				break;
			case 2:

				EmployeesDTO employees = ManagerFactory.GetEmployees();

				employees.setEmployeeNumber(form.getNumber());

				employees = (EmployeesDTO) EmployeesManager.getRecord(employees);

				request.setAttribute(ATT_EMPLOYEE, employees);
				session.setAttribute(ATT_EMPLOYEE, employees);
				this.getServletContext().getRequestDispatcher(VUE_EMPLOYE).forward(request, response);
				break;
			case 1:
				EmployeesDTO admin = ManagerFactory.GetEmployees();

				admin.setEmployeeNumber(form.getNumber());

				admin = (EmployeesDTO) EmployeesManager.getRecord(admin);

				request.setAttribute(ATT_EMPLOYEE, admin);
				session.setAttribute(ATT_EMPLOYEE, admin);
				this.getServletContext().getRequestDispatcher(VUE_ADMIN).forward(request, response);
				break;
			default:
				request.setAttribute("form", form);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				break;

			}
		} else {

			request.setAttribute(ERROR_MESSAGE, form);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		}
	}

}

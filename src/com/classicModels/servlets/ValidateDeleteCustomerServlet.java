package com.classicModels.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class ValidateDeleteCustomerServlet
 */
@WebServlet("/validateDeleteCustomerServlet")
public class ValidateDeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateDeleteCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final String ATT_CLIENT = "clients";
	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/menuClients.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String numCli = request.getParameter("NumClient");

		CustomersDTO client = ManagerFactory.getCustomers();
		client.setCustomerNumber(Long.parseLong(numCli));
		// CustomersManager.
		session.setAttribute(ATT_CLIENT, client);
		request.setAttribute(ATT_CLIENT, client);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String numClient = request.getParameter("NumClient");
		System.out.println("numero client dans le post" + numClient);
		CustomersDTO client = ManagerFactory.getCustomers();
		client.setCustomerNumber(Integer.parseInt(numClient));
		CustomersManager.delRecord(client);
		// client.setCustomerNumber(customerNumber);
		session.setAttribute(ATT_CLIENT, client);
		request.setAttribute(ATT_CLIENT, client);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

}

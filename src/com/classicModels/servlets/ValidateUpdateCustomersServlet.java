package com.classicModels.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class ValidateUpdateCustomersServlet
 */
@WebServlet("/validateUpdateCustomersServlet")
public class ValidateUpdateCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/menuClients.jsp";
	private String customerNumber = " ";
	private String customerName = " ";
	private String contactFirstName = " ";
	private String contactLastName = " ";
	private String phone = " ";
	private String addresse1 = " ";
	private String addresse2 = " ";
	private String city = " ";
	private String state = " ";
	private String country = " ";
	private String postalCode = " ";
	private String salesRep = " ";
	private String creditLimit = " ";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateUpdateCustomersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomersDTO client = ManagerFactory.getCustomers();
		customerNumber = request.getParameter("customernumber");

		client.setCustomerNumber(Integer.parseInt(customerNumber));
		customerName = request.getParameter("customername");
		client.setCustomerName(customerName);
		contactFirstName = request.getParameter("contactfirstname");
		client.setContactFirstName(contactFirstName);
		contactLastName = request.getParameter("contactlastname");
		client.setContactLastName(contactLastName);
		phone = request.getParameter("phone");
		client.setPhone(phone);
		addresse1 = request.getParameter("addressline1");
		client.setAddressLine1(addresse1);
		addresse2 = request.getParameter("addressline2");
		client.setAddressLine2(addresse2);
		postalCode = request.getParameter("postalcode");
		client.setPostalCode(postalCode);
		city = request.getParameter("city");
		client.setCity(city);
		state = request.getParameter("state");
		client.setState(state);
		country = request.getParameter("country");
		client.setCountry(country);
		salesRep = request.getParameter("salesrep");
		client.setSalesRepEmployeeNumber(Long.parseLong(salesRep));
		creditLimit = request.getParameter("creditlimit");
		client.setCreditLimit(Double.parseDouble(creditLimit));

		System.out.println("client apres:" + client);

		CustomersDTO clientsource = ManagerFactory.getCustomers();
		clientsource.setCustomerNumber(Integer.parseInt(customerNumber));
		clientsource = (CustomersDTO) CustomersManager.getRecord(clientsource);
		System.out.println("client avant:" + clientsource);
		CustomersManager.update(clientsource, client);

		request.getRequestDispatcher(VUE).forward(request, response);
	}

}

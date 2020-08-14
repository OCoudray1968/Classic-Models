package com.classicModels.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OrdersManager;

public class ListeCommandesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_LOGIN = "utilisateur";
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_COMMANDE = "commandes";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/listerCommandes.jsp";

	public int Num_Cli = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute(ATT_CUSTOMER);

		CustomersDTO client = ManagerFactory.getCustomers();
		client = (CustomersDTO) session.getAttribute(ATT_CUSTOMER);

		OrdersDTO orders = ManagerFactory.getOrders();
		orders.setCustomerNumber((int) client.getCustomerNumber());

		List<AbstractDTO> commande = OrdersManager.listAll(orders);
		HttpSession sessioncommande = request.getSession();

		sessioncommande.setAttribute(ATT_COMMANDE, commande);
		request.setAttribute(ATT_COMMANDE, commande);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Session :" + session);

		String customerNumber = request.getParameter(ATT_CUSTOMER);
		System.out.println("num client :" + customerNumber);
		CustomersDTO clients = ManagerFactory.getCustomers();
		clients.setCustomerNumber(Integer.valueOf(customerNumber));
		CustomersDTO client = (CustomersDTO) CustomersManager.getRecord(clients);
		System.out.println("POST :" + client.getCustomerNumber());
		OrdersDTO orders = ManagerFactory.getOrders();
		orders.setCustomerNumber((int) client.getCustomerNumber());

		List<AbstractDTO> commande = OrdersManager.listAll(orders);
		HttpSession sessioncommande = request.getSession();

		System.out.println("commande :" + commande);
		sessioncommande.setAttribute(ATT_COMMANDE, commande);
		request.setAttribute(ATT_COMMANDE, commande);
		request.getRequestDispatcher(VUE).forward(request, response);

	}
}
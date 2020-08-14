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
import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OrderDetailsManager;
import com.classicModels.managers.OrdersManager;

/**
 * Servlet implementation class DetailCommandesEnCours
 */
@WebServlet("/detailCommandesEnCours")
public class DetailCommandesEnCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_COMMANDE = "commandes";
	public static final String ATT_DETAIL_COMMANDE = "detailcommandes";
	public static final String VUE = "/WEB-INF/ligneCommandeEnCours.jsp";
	public static final String VUE1 = "/WEB-INF/validationCommandeEnCours.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailCommandesEnCours() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		String ordernumber = request.getParameter("orderNumber");
		CustomersDTO client = ManagerFactory.getCustomers();
		String numcli = request.getParameter("customerNumber");

		client.setCustomerNumber(Integer.parseInt(numcli));
		client = (CustomersDTO) CustomersManager.getRecord(client);
		EmployeesDTO employee = ManagerFactory.GetEmployees();
		employee = (EmployeesDTO) session.getAttribute(ATT_EMPLOYEE);

		OrderDetailsDTO orderdetail = ManagerFactory.getOrderDetails();
		orderdetail.setOrderNumber(Integer.parseInt(ordernumber));

		List<AbstractDTO> detailcommandes = OrderDetailsManager.listOrderdetail(orderdetail);

		HttpSession sessiondetailcommande = request.getSession();
		session.setAttribute(ATT_CUSTOMER, client);
		session.setAttribute("numcommande", ordernumber);
		session.setAttribute(ATT_EMPLOYEE, employee);
		sessiondetailcommande.setAttribute(ATT_DETAIL_COMMANDE, detailcommandes);
		request.setAttribute(ATT_DETAIL_COMMANDE, detailcommandes);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute(ATT_DETAIL_COMMANDE);
		session.getAttribute(ATT_CUSTOMER);
		String ordernumber = request.getParameter("orderNumber");

		OrdersDTO order = ManagerFactory.getOrders();
		order.setOrderNumber(Integer.parseInt(ordernumber));
		order = (OrdersDTO) OrdersManager.getRecord(order);

		OrderDetailsDTO orderdetail = ManagerFactory.getOrderDetails();
		orderdetail.setOrderNumber((int) order.getOrderNumber());

		List<AbstractDTO> detailcommandes = OrderDetailsManager.listOrderdetail(orderdetail);
		HttpSession sessiondetailcommande = request.getSession();

		System.out.println("detail de la commande dans le post :" + detailcommandes);
		sessiondetailcommande.setAttribute(ATT_DETAIL_COMMANDE, detailcommandes);
		request.setAttribute(ATT_DETAIL_COMMANDE, detailcommandes);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

}

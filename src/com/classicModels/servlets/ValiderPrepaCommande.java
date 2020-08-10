package com.classicModels.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.OrderDetailsManager;
import com.classicModels.managers.OrdersManager;
import com.classicModels.managers.ProductsManager;

/**
 * Servlet implementation class ValiderPrepaCommande
 */
@WebServlet("/validerPrepaCommande")
public class ValiderPrepaCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_COMMANDE = "commandes";
	public static final String ATT_DETAIL_COMMANDE = "detailcommandes";

	public static final String VUE = "/WEB-INF/validationCommandeEnCours.jsp";

	private Integer quantiteStock = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValiderPrepaCommande() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Recuperation des donnees de la vue
		session.getAttribute(ATT_DETAIL_COMMANDE);
		session.getAttribute(ATT_CUSTOMER);

		@SuppressWarnings("unchecked")
		List<OrderDetailsDTO> panier = (List<OrderDetailsDTO>) session.getAttribute(ATT_DETAIL_COMMANDE);
		System.out.println("Le panier :" + panier);
		OrderDetailsDTO detailCommandeAp = new OrderDetailsDTO();
		OrderDetailsDTO detailCommandeAv = new OrderDetailsDTO();
		ProductsDTO productsAv = new ProductsDTO();
		ProductsDTO productsAp = new ProductsDTO();
		detailCommandeAp = panier.get(0);
		boolean etatcheckbox = request.getParameter("valid") != null;
		int numcommande = detailCommandeAp.getOrderNumber();
		for (int i = 0; i < panier.size(); i++) {

			detailCommandeAp = panier.get(i);
			// MAJ de la ligne de commande
			System.out.println("etat de la checkbox :" + etatcheckbox);
			detailCommandeAv.setOrderNumber(numcommande);
			detailCommandeAv.setOrderLineNumber(detailCommandeAp.getOrderLineNumber());
			detailCommandeAv = (OrderDetailsDTO) OrderDetailsManager.getRecord(detailCommandeAv);
			OrderDetailsManager.update(detailCommandeAp, detailCommandeAv);
			// mise à jour des stock
			productsAv.setProductCode(detailCommandeAp.getProductCode());
			productsAv = (ProductsDTO) ProductsManager.getRecord(productsAv);
			productsAp.setProductCode(detailCommandeAp.getProductCode());
			quantiteStock = productsAv.getQuantityInStock();
			quantiteStock = quantiteStock - detailCommandeAp.getQuantityOrdered();
			productsAp.setQuantityInStock(quantiteStock);
			ProductsManager.update(productsAp, productsAv);

		}
		OrdersDTO commandeAv = new OrdersDTO();
		commandeAv.setOrderNumber(numcommande);

		commandeAv = (OrdersDTO) OrdersManager.getRecord(commandeAv);

		OrdersDTO commandeAp = new OrdersDTO();
		commandeAp.setOrderDate(commandeAv.getOrderDate());
		commandeAp.setRequiredDate(commandeAv.getRequiredDate());
		commandeAp.setShippedDate(commandeAv.getShippedDate());
		commandeAp.setCustomerNumber(commandeAv.getCustomerNumber());
		commandeAp.setStatusOrder("In Delivering");
		OrdersManager.update(commandeAv, commandeAp);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}

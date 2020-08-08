package com.classicModels.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classicModels.beans.CartBean;

public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_PRODUCTS = "produit";
	public static final String ATT_PANIER = "panier";
	private static String VUE_PANIER = "/WEB-INF/catalogueCommande.jsp";
	private String codeProduit;
	private String qty;
	private String designation;
	private String prix;
	private List<CartBean> panier = new ArrayList<CartBean>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VUE_PANIER).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		codeProduit = request.getParameter("codeProduit");
		designation = request.getParameter("designation");
		qty = request.getParameter("quantite");
		prix = request.getParameter("prix");
		System.out.println("code produit :" + codeProduit + " quantité : " + qty + " prix : " + prix);
		CartBean produit = new CartBean();
		produit.setProductCode(codeProduit);
		produit.setDesignation(designation);
		produit.setQuantity((Integer.parseInt(qty)));
		produit.setPrice(Double.parseDouble(prix));

		panier.add(produit);

		request.setAttribute(ATT_PANIER, panier);

		request.getRequestDispatcher(VUE_PANIER).forward(request, response);
	}

}
package com.classicModels.servlets;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.beans.CartBean;



/**
 * Servlet implementation class ConfirmationPanier
 */
@WebServlet("/ConfirmationPanier")
public class ConfirmationPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String ATT_CUSTOMER       = "client";
	 public static final String ATT_ORDER       = "commande";
	public static final String ATT_PANIER       = "panier";
	public static final String ATT_INDEX        ="lignePanier";
	public static final String VUE1         = "/WEB-INF/commandeValider.jsp";
	public static final String VUE         = "/WEB-INF/bonDeCommande.jsp";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<CartBean> panier = (List<CartBean>)session.getAttribute(ATT_PANIER);
		
		CustomersDTO client = (CustomersDTO) session.getAttribute(ATT_CUSTOMER);
		OrdersDTO commande = (OrdersDTO) session.getAttribute(ATT_ORDER);
	
		System.out.println(commande);
		
	   session.setAttribute(ATT_CUSTOMER, client);
	   session.setAttribute(ATT_ORDER, commande);
	   session.setAttribute(ATT_PANIER, panier);
		
				
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

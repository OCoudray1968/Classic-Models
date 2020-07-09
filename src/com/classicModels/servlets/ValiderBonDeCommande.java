package com.classicModels.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OrderDetailsManager;
import com.classicModels.managers.OrdersManager;
import com.classicModels.tools.DateUtils;

/**
 * Servlet implementation class ValiderBonDeCommande
 */
@WebServlet("/ValiderBonDeCommande")
public class ValiderBonDeCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_CUSTOMER       = "client";
	public static final String ATT_ORDER       = "commande";
	public static final String ATT_PANIER       = "panier";
	public static final String ATT_INDEX        ="lignePanier";
	public static final String VUE         = "/WEB-INF/commandeValider.jsp";
	

   private Date dateCommande;
   private Date dateDemande;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderBonDeCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderDetailsDTO> panier = (List<OrderDetailsDTO>)session.getAttribute(ATT_PANIER);
		
		CustomersDTO client = (CustomersDTO) session.getAttribute(ATT_CUSTOMER);
	
		
		DateUtils dateUtils = new DateUtils();
		dateCommande = dateUtils.toSQLDate(LocalDate.now());
		 String dateDem = request.getParameter("requiredDate");
		
	   if(dateDem!=null) {
	  
	  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  	try {
			dateDemande=sdf.parse(dateDem);
			dateDemande=dateUtils.toSQLDate(dateDemande);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	    session.setAttribute(ATT_CUSTOMER, client);
		
		session.setAttribute(ATT_PANIER, panier);
		
		OrdersDTO commande= ManagerFactory.getOrders();
	
		OrdersDTO lastOrder =  (OrdersDTO) OrdersManager.getLast(commande);
			
		int ordernumber = lastOrder.getOrderNumber()+1;
		if(dateDem!=null) {
	
		commande.setOrderNumber(ordernumber);
		commande.setOrderDate(dateCommande);
		commande.setRequiredDate(dateDemande);
		commande.setShippedDate(dateDemande);
		commande.setStatusOrder("In Process");
		commande.setComments(request.getParameter("comments"));
		commande.setCustomerNumber(client.getCustomerNumber());
				
		OrdersManager.setRecord(commande);
		}
		OrderDetailsDTO detailCommande = new OrderDetailsDTO();
		detailCommande.setOrderNumber(ordernumber);
		
		for(int i=0;i<panier.size();i++) {
		detailCommande=panier.get(i);
		detailCommande.setOrderNumber(ordernumber);
		OrderDetailsManager.setRecord(detailCommande);
		}

		session.setAttribute(ATT_ORDER, commande);
			
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

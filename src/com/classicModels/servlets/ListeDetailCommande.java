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
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OrderDetailsManager;


/**
 * Servlet implementation class ListeDetaiCommande
 */
@WebServlet("/ListeDetailCommande")
public class ListeDetailCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_COMMANDE = "commandes";
	public static final String ATT_DETAIL_COMMANDE = "detailcommandes";
	public static final String VUE          = "/WEB-INF/listerCommandes.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeDetailCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
    	String ordernumber=request.getParameter("orderNumber");

    
       	System.out.println("GET :"+ ordernumber);
    	    OrderDetailsDTO orderdetail = ManagerFactory.getOrderDetails();
         	orderdetail.setOrderNumber(Integer.parseInt(ordernumber));
 
    	
			List<AbstractDTO> detailcommandes = OrderDetailsManager.listOrderdetail(orderdetail);
         	System.out.println("detail de la commande :"+detailcommandes);
      		
         	HttpSession sessiondetailcommande = request.getSession();
      		sessiondetailcommande.setAttribute(ATT_DETAIL_COMMANDE, detailcommandes);
         	request.setAttribute( ATT_DETAIL_COMMANDE,detailcommandes );
         	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
    	session.getAttribute(ATT_COMMANDE);
   
    	
  
    	OrdersDTO order = ManagerFactory.getOrders();
    	order=	(OrdersDTO) session.getAttribute(ATT_COMMANDE);
    	
    
    	System.out.println("POST :"+ order.getOrderNumber());
    		
    	    OrderDetailsDTO orderdetail = ManagerFactory.getOrderDetails();
         	orderdetail.setOrderNumber((int) order.getOrderNumber());
 
    	
			List<AbstractDTO> detailcommandes = OrderDetailsManager.listOrderdetail(orderdetail);
         	HttpSession sessiondetailcommande = request.getSession();

      		System.out.println(detailcommandes);
      		sessiondetailcommande.setAttribute(ATT_DETAIL_COMMANDE, detailcommandes);
         	request.setAttribute( ATT_DETAIL_COMMANDE,detailcommandes );
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

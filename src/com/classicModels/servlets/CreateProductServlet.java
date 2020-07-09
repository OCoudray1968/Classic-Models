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
import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductLinesManager;
import com.classicModels.managers.ProductsManager;


@WebServlet("/createProductServlet")
public class CreateProductServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String ATT_PRODUCTLINE	="productline";
	public static final String ATT_EMPLOYEES     	= "employees";
	

    public static final String VUE       = "/WEB-INF/createProduct.jsp";
    private String productCode="";
    private String productName="";
    private String productLine="";
    private String productScale="";
    private String productVendor="";
    private String productDescription="";
    private String quantityInStock="";
    private String buyPrice="";
    private String Msrp=" ";
  
   

    
    public void init() throws ServletException {
    	
    	/* récupération d'une instance du DAO Customer */
    //this.clientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getCustomersDAO();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
    	HttpSession session=request.getSession();
    	List<AbstractDTO> productline= ProductLinesManager.listAll();
   
    	
    	session.setAttribute(ATT_PRODUCTLINE,productline);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
      
    	HttpSession session=request.getSession();
    	
    	session.getAttribute(ATT_PRODUCTLINE);
    	System.out.println(request.getParameter("productline"));
		ProductsDTO produit = ManagerFactory.getProducts();
		
		productCode=request.getParameter("productcode");
		produit.setProductCode(productCode);
		productName=request.getParameter("productname");
		produit.setProductName(productName);
		productLine=request.getParameter("productline");
		System.out.println("le productLine est:"+productLine);
		produit.setProductLine(productLine);
		productScale=request.getParameter("productscale");
		produit.setProductScale(productScale);
		productVendor=request.getParameter("productvendor");
		produit.setProductVendor(productVendor);
		productDescription=request.getParameter("productdescription");
		produit.setProductDescription(productDescription);
		quantityInStock=request.getParameter("quantityinstock");
		produit.setQuantityInStock(Integer.parseInt(quantityInStock));
		buyPrice=request.getParameter("buyprice");
		produit.setBuyPrice(Double.parseDouble(buyPrice));
		Msrp=request.getParameter("msrp");
		produit.setMsrp(Double.parseDouble(Msrp));
			System.out.println("produit :"+produit);
		ProductsManager.setRecord(produit);
		
	
        this.getServletContext().getRequestDispatcher( VUE).forward( request, response );

    }
}
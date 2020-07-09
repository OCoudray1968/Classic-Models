package com.classicModels.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.ProductsManager;

/**
 * Servlet implementation class ValidateUpdateCustomersServlet
 */
@WebServlet("/validateUpdateProductServlet")
public class ValidateUpdateProductServlet extends HttpServlet {
	
	/**
	 * definition des champs modifiés
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE        = "/WEB-INF/menuProduits.jsp";
    private String productCode="";
    private String productName="";
    private String productLine="";
    private String productScale="";
    private String productVendor="";
    private String productDescription="";
    private String quantityInStock="";
    private String buyPrice="";
    private String msrp="";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUpdateProductServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductsDTO produit = ManagerFactory.getProducts();
		/**
		 * Récupération des changements effectués
		 */
		productCode = request.getParameter("productcode");
		
		produit.setProductCode(productCode);
		productName = request.getParameter("productname");
		produit.setProductName(productName);
		productLine=request.getParameter("productline");
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
		msrp=request.getParameter("msrp");
		produit.setMsrp(Double.parseDouble(msrp));
		
		/**
		 * on effectue l'enregistrement des modifications
		 */
		ProductsDTO produitsource=ManagerFactory.getProducts();
		produitsource.setProductCode(productCode);
		produitsource=(ProductsDTO) ProductsManager.getRecord(produitsource);
		ProductsManager.update(produit, produitsource);
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

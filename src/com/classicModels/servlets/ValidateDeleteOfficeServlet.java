package com.classicModels.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.classicModels.DTO.OfficesDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OfficesManager;

/**
 * Servlet implementation class ValidateDeleteCustomerServlet
 */
@WebServlet("/validateDeleteOfficeServlet")
public class ValidateDeleteOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateDeleteOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public static final String ATT_OFFICE = "offices";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/menuOffices.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String officeCode =request.getParameter("officecode");
		System.out.println("numero client dans le post"+officeCode);
		OfficesDTO office =ManagerFactory.getOffices();
		office.setOfficeCode(Integer.parseInt(officeCode));
		OfficesManager.delRecord(office);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	

}

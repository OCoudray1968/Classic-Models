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
 * Servlet implementation class ValidateUpdateCustomersServlet
 */
@WebServlet("/validateUpdateOfficeServlet")
public class ValidateUpdateOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String VUE        = "/WEB-INF/menuOffices.jsp";
    private String officeCode=" ";
  
    private String phone=" ";
    private String addresse1=" ";
    private String addresse2=" ";
    private String city=" ";
    private String state=" ";
    private String country=" ";
    private String postalCode=" ";
    private String territory=" ";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUpdateOfficeServlet() {
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
	
		OfficesDTO office = ManagerFactory.getOffices();
		officeCode = request.getParameter("officecode");
		
		office.setOfficeCode(Integer.parseInt(officeCode));
		
		city=request.getParameter("city");
		office.setCity(city);
		phone=request.getParameter("phone");
		office.setPhoneOffice(phone);
		addresse1=request.getParameter("addressline1");
		office.setAddressLine1(addresse1);
		addresse2=request.getParameter("addressline2");
		office.setAddressLine2(addresse2);
		postalCode=request.getParameter("postalcode");
		office.setPostalCode(postalCode);
		
		state=request.getParameter("state");
		office.setStateOffice(state);
		country=request.getParameter("country");
		office.setCountryOffice(country);
		territory=request.getParameter("territory");
		office.setTerritory(territory);
		
		
		System.out.println("office apres:"+office);
		
		
		OfficesDTO officesource=ManagerFactory.getOffices();
		officesource.setOfficeCode(Integer.parseInt(officeCode));
		officesource=(OfficesDTO) OfficesManager.getRecord(officesource);
		System.out.println("client avant:"+officesource);
		OfficesManager.update(officesource, office);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}

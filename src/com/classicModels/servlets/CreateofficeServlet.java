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
import com.classicModels.DTO.OfficesDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OfficesManager;


@WebServlet("/createOfficeServlet")
public class CreateofficeServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String CHEMIN           = "chemin";
	public static final String ATT_OFFICES		="offices";
	public static final String ATT_EMPLOYEE     	= "employees";
	public static final String ATT_FORM         = "form";
    public static final String VUE       = "/WEB-INF/createOffice.jsp";
   
  
    private String city=" ";
    private String phone=" ";
    private String addresse1=" ";
    private String addresse2=" ";
    private String state=" ";
    private String country=" ";
    private String postalCode=" ";
    private String territory=" ";
   

    
    public void init() throws ServletException {
    	
    	/* récupération d'une instance du DAO Customer */
    //this.clientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getCustomersDAO();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
    	HttpSession sessionSalesRep=request.getSession();
    	List<AbstractDTO> offices= OfficesManager.listAll();
    
    	
    	sessionSalesRep.setAttribute(ATT_OFFICES,offices);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
      
  
    	OfficesDTO dernierOffice=ManagerFactory.getOffices();
    	dernierOffice=(OfficesDTO) OfficesManager.getLast(dernierOffice);
    	System.out.println("dernier client"+dernierOffice);
		OfficesDTO office = ManagerFactory.getOffices();
		
		
		office.setOfficeCode(dernierOffice.getOfficeCode()+1);
		
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
		
			
		
		OfficesManager.setRecord(office);
		
         this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
//        }
    }
}
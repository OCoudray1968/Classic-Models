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
import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.EmployeesManager;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;


@WebServlet("/createCustomersServlet")
public class CreateCustomerServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String ATT_SALESREP		="salesrep";
	public static final String ATT_EMPLOYEE     	= "employees";
	public static final String ATT_FORM         = "form";
    public static final String SESSION_CLIENTS  = "clients";

    public static final String VUE       = "/WEB-INF/createCustomer.jsp";
  
    private Long customerNumber;
    private String customerName=" ";
    private String contactFirstName=" ";
    private String contactLastName=" ";
    private String phone=" ";
    private String addresse1=" ";
    private String addresse2=" ";
    private String city=" ";
    private String state=" ";
    private String country=" ";
    private String postalCode=" ";
    private String salesRep=" ";
    private String creditLimit=" ";
    private String login="";
    private String pwd="";
    private Integer profil=4;
    
   

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
    	HttpSession sessionSalesRep=request.getSession();
    	List<AbstractDTO> employees= EmployeesManager.listAll();
    	System.out.println("Liste des n° employees"+employees);
    	
    	sessionSalesRep.setAttribute(ATT_SALESREP,employees);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
      
    
    	CustomersDTO dernierclient=ManagerFactory.getCustomers();
    	dernierclient=(CustomersDTO) CustomersManager.getLast(dernierclient);
    	System.out.println("dernier client"+dernierclient);
		CustomersDTO client = ManagerFactory.getCustomers();
		
		
		client.setCustomerNumber(dernierclient.getCustomerNumber()+1);
		customerName = request.getParameter("customername");
		client.setCustomerName(customerName);
		contactFirstName=request.getParameter("contactfirstname");
		client.setContactFirstName(contactFirstName);
		contactLastName=request.getParameter("contactlastname");
		client.setContactLastName(contactLastName);
		phone=request.getParameter("phone");
		client.setPhone(phone);
		addresse1=request.getParameter("addressline1");
		client.setAddressLine1(addresse1);
		addresse2=request.getParameter("addressline2");
		client.setAddressLine2(addresse2);
		postalCode=request.getParameter("postalcode");
		client.setPostalCode(postalCode);
		city=request.getParameter("city");
		client.setCity(city);
		state=request.getParameter("state");
		client.setState(state);
		country=request.getParameter("country");
		client.setCountry(country);
		salesRep=request.getParameter("salesrep");
		client.setSalesRepEmployeeNumber(Long.parseLong(salesRep));
		creditLimit=request.getParameter("creditlimit");
		client.setCreditLimit(Double.parseDouble(creditLimit));
		
						
		CustomersManager.setRecord(client);
		
		LoginsDTO logins = ManagerFactory.getlogins();
		logins.setCustomerNumber(customerNumber);
		login=request.getParameter("login");
		logins.setLogin(login);
		pwd=request.getParameter("pwd");
		logins.setPasswordLogin(pwd);
		
		logins.setProfil(profil);
		
		LoginsManager.setRecord(logins);
		
         this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
//        }
    }
}
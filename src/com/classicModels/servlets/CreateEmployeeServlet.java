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
import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.EmployeesManager;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.OfficesManager;


@WebServlet("/createEmployeeServlet")
public class CreateEmployeeServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String ATT_REPORTSTO	="reportsto";
	public static final String ATT_EMPLOYEES     	= "employees";
	public static final String ATT_OFFICES     	= "offices";

    public static final String VUE       = "/WEB-INF/createEmployee.jsp";
  
    private String firstName=" ";
    private String lastName=" ";
    private String extension=" ";
    private String email=" ";
    private String officeCode=" ";
    private String reportsTo=" ";
    private String jobTitle=" ";
    private String loginEmployee="";
    private String pwd="";
    private String profil="";
   

    
    public void init() throws ServletException {
    	
    	/* récupération d'une instance du DAO Employee */
    //this.customerDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getEmployeesDAO();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
    	HttpSession sessionSalesRep=request.getSession();
    	HttpSession sessionOfficeSession=request.getSession();
    	//liste des employées pour la liste deroulante
    	List<AbstractDTO> employees= EmployeesManager.listAll();
    	//liste des agences pour la liste deroulante
    	List<AbstractDTO> offices=OfficesManager.listAll();
    	sessionOfficeSession.setAttribute(ATT_OFFICES, offices);
    	sessionSalesRep.setAttribute(ATT_REPORTSTO,employees);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
      
    	
    	EmployeesDTO dernieremployee=ManagerFactory.GetEmployees();
    	dernieremployee=(EmployeesDTO) EmployeesManager.getLast(dernieremployee);
    	
		EmployeesDTO employee = ManagerFactory.GetEmployees();
		//on enregistre les données du formulaire
		
		employee.setEmployeeNumber(dernieremployee.getEmployeeNumber()+1);
		firstName=request.getParameter("firstname");
		employee.setFirstName(firstName);
		lastName=request.getParameter("lastname");
		employee.setLastName(lastName);
		extension=request.getParameter("extension");
		employee.setExtension(extension);
		email=request.getParameter("email");
		employee.setEmail(email);
		officeCode=request.getParameter("officecode");
		employee.setOfficeCode(Integer.parseInt(officeCode));
		reportsTo=request.getParameter("reportsto");
		employee.setReportsTo(Integer.parseInt(reportsTo));
		jobTitle=request.getParameter("jobtitle");
		employee.setJobTitle(jobTitle);
			
		EmployeesManager.setRecord(employee);
		//on crée le login du nouvel utilisateur
		LoginsDTO login = ManagerFactory.getlogins();
		login.setEmployeeNumber((int) (dernieremployee.getEmployeeNumber()+1));
		loginEmployee=request.getParameter("login");
		login.setLogin(loginEmployee);
		pwd=request.getParameter("pwd");
		login.setPasswordLogin(pwd);
		profil=request.getParameter("profil");
		login.setProfil(Integer.parseInt(profil));
			
		LoginsManager.setRecord(login);
        this.getServletContext().getRequestDispatcher( VUE).forward( request, response );

    }
}
package com.classicModels.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.managers.EmployeesManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class ValidateUpdateCustomersServlet
 */
@WebServlet("/validateUpdateEmployeeServlet")
public class ValidateUpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE       = "/WEB-INF/menuEmployees.jsp";
	private String employeeNumber="";
	private String firstName="";
	private String lastName="";
	private String extension="";
	private String email="";
	private String officeCode="";
	private String reportsTo="";
	private String jobTitle="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUpdateEmployeeServlet() {
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
		
		EmployeesDTO employee = ManagerFactory.GetEmployees();
		employeeNumber = request.getParameter("employeenumber");
		
		employee.setEmployeeNumber(Integer.parseInt(employeeNumber));
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
		
		
		EmployeesDTO employeesource=ManagerFactory.GetEmployees();
		employeesource.setEmployeeNumber(Long.parseLong(employeeNumber));
		employeesource=(EmployeesDTO) EmployeesManager.getRecord(employeesource);

		EmployeesManager.update(employeesource, employee);
		
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}

}

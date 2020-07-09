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
import com.classicModels.managers.OfficesManager;


@WebServlet("/listOfficesServlet")
public class ListOfficesServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_OFFICES = "offices";
	public static final String ATT_EMPLOYEE		  ="employee";	
    public static final String ATT_FORM   = "form";

    public static final String VUE        = "/WEB-INF/listerOffices.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	HttpSession session =request.getSession();
    	    	
  
    
    
    	    List<AbstractDTO> offices = OfficesManager.listAll();
    	   
			System.out.println(offices);   		
      		session.setAttribute(ATT_OFFICES, offices);
         
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
       
    }
}
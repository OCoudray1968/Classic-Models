package com.classicModels.servlets;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ConnexionServlet extends HttpServlet {
 
	private static final long serialVersionUID 	  = 1L;
	
    
    public static final String VUE             	  = "/WEB-INF/connexion.jsp";
   

   
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
     
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
   
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    	}
    }

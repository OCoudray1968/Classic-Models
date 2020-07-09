package com.classicModels.servlets;

import java.io.IOException;
import java.text.NumberFormat;

import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.DTO.ProductsDTO;
import com.classicModels.managers.ManagerFactory;

import com.classicModels.managers.OrdersManager;
import com.classicModels.managers.ProductsManager;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;




@WebServlet("/pdfexport")
public class PDFExport extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_CUSTOMER       = "client";
	public static final String ATT_ORDER       = "commande";
	public static final String ATT_PANIER       = "panier";
	public static final String ATT_INDEX        ="lignePanier";
	public static final String VUE         = "/WEB-INF/commandeValider.jsp";
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<OrderDetailsDTO> panier = (List<OrderDetailsDTO>)session.getAttribute(ATT_PANIER);
		
		CustomersDTO client = (CustomersDTO) session.getAttribute(ATT_CUSTOMER);
	
		
		
	
	    session.setAttribute(ATT_CUSTOMER, client);
		
		session.setAttribute(ATT_PANIER, panier);
		
		OrdersDTO commande= ManagerFactory.getOrders();
	
		OrdersDTO lastOrder =  (OrdersDTO) OrdersManager.getLast(commande);
	
		
		
		String masterPath = request.getServletContext().getRealPath("/WEB-INF/MasterBondeCommande.pdf");
		response.setContentType("application/pdf");
		// creation du PDf du bon de commande
		try(
			    PdfReader reader = new PdfReader(masterPath);
				PdfWriter writer = new PdfWriter(response.getOutputStream());
				PdfDocument document = new PdfDocument(reader, writer);
			)
			{
			
						PdfPage page = document.getPage(1);
						PdfCanvas canvas=new PdfCanvas(page);
						FontProgram fontProgram = FontProgramFactory.createFont();
						PdfFont font = PdfFontFactory.createFont(fontProgram, "utf-8",true);
						canvas.setFontAndSize(font, 12);
				 
						canvas.beginText();
						//date
						SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
						String strdate = date.format(lastOrder.getOrderDate());
						
							
						canvas.setTextMatrix(370,755);
						canvas.showText( "" + strdate);
						
						//Societe
						canvas.setTextMatrix(370,728);
						canvas.showText( "" + client.getCustomerName());
						//Adresse facturation
						canvas.setTextMatrix(340,682);
						canvas.showText( "" + client.getAddressLine1());
						if(client.getPostalCode()!=null) {
						canvas.setTextMatrix(340,670);
						canvas.showText( "" + client.getPostalCode());
						}
						canvas.setTextMatrix(340,658);
						canvas.showText( "" + client.getCity());
						
						//Numéro de commande
						canvas.setFontAndSize(font, 18);
						canvas.setTextMatrix(220,640);
						canvas.showText( "" + lastOrder.getOrderNumber());
						
						//detail de la commande
						canvas.setFontAndSize(font, 12);
						OrderDetailsDTO detailCommande = new OrderDetailsDTO();
										
						int top = 590;
						double totalPrice = 0;
						String designation;
						NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("fr", "FR"));
						for(int i=0;i<panier.size();i++) {
						detailCommande=panier.get(i);
						
				
						canvas.setTextMatrix(20,top);
						canvas.showText( "" + detailCommande.getProductCode());
						
						//recuperation de la designation de l'article
						ProductsDTO produit= ManagerFactory.getProducts();
						produit.setProductCode(detailCommande.getProductCode());
						produit=(ProductsDTO)ProductsManager.getRecord(produit);
						if (produit.getProductName().length()>30) {
						designation =(produit.getProductName()).substring(0,30);
						}else {
						designation=produit.getProductName();	
						}
						canvas.setTextMatrix(110,top);
						canvas.showText( "" + designation);
						
						//prix des articles
						canvas.setTextMatrix(290,top);
						canvas.showText( "" + formatter.format(detailCommande.getPriceEach()));
						
						//quantité d'article
						canvas.setTextMatrix(400,top);
						canvas.showText( "" + detailCommande.getQuantityOrdered());
				
						double total =detailCommande.getPriceEach()*detailCommande.getQuantityOrdered();
						totalPrice +=total;
						canvas.setTextMatrix(500,top);
						canvas.showText( "" +formatter.format(total));
												
						top -=20;
						}
						canvas.setTextMatrix(500,325);
						canvas.showText( "" +formatter.format(totalPrice)+"€");
						double tva = 18.6;
						double montantTva = totalPrice*(tva/100);
						canvas.setTextMatrix(500,295);
						canvas.showText( "" +formatter.format(montantTva)+"€");
						double totalTtc = totalPrice+montantTva;
						canvas.setTextMatrix(500,265);
						canvas.showText( "" +formatter.format(totalTtc)+"€");
						canvas.endText();
		
			}
	}

}

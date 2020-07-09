package com.classicModels.beans;

public class ProductLinesBean {

	// identifiant produit
	private String ProductLine ="";
	//Description ligne produit
	private String TextDescription ="";
	//Description HTML
	private String HtmlDescription ="";
	// image ligne produit
	private String Image ="";
	
	public ProductLinesBean(String productLine, String textDescription, String htmlDescription, String image) {
		
		this.ProductLine=productLine;
		this.TextDescription=textDescription;
		this.HtmlDescription=htmlDescription;
		this.Image=image;
	}
	
	public ProductLinesBean() {}

	public String getProductLine() {
		return ProductLine;
	}

	public void setProductLine(String productLine) {
		this.ProductLine = productLine;
	}

	public String getTextDescription() {
		return TextDescription;
	}

	public void setTextDescription(String textDescription) {
		this.TextDescription = textDescription;
	}

	public String getHtmlDescription() {
		return HtmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.HtmlDescription = htmlDescription;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		this.Image = image;
	};
	
	
}

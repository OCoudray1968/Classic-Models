package com.classicModels.beans;

public class ProductsBean {

	//Code du produit
	private String ProductCode ="";
	//Nom du produit
	private String ProductName = "";
	//Ligne produit (rattach� � product line)
	private String ProductLine ="";
	//Echelle du produit
	private String ProductScale ="";
	//Vendeur du produit
	private String ProductVendor ="";
	//Description du produit
	private String ProductDescription ="";
	//Quantit� en stock
	private Integer QuantityInStock =0;
	//Price achat
	private Double BuyPrice ;
	//prix de revente sugg�r�
	private Double Msrp;
	
	public ProductsBean (String ProductCode, String ProductName, String ProductLine, String ProductScale, String ProductVendor, String ProductDescription,
			Integer QuantityInStock, Double BuyPrice, Double Msrp) {
		
		this.ProductCode=ProductCode;
		this.ProductName=ProductName;
		this.ProductLine=ProductLine;
		this.ProductScale=ProductScale;
		this.ProductVendor=ProductVendor;
		this.ProductDescription=ProductDescription;
		this.QuantityInStock=QuantityInStock;
		this.Msrp=Msrp;
				
	}
	
	public ProductsBean() {}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		this.ProductCode = productCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public String getProductLine() {
		return ProductLine;
	}

	public void setProductLine(String productLine) {
		this.ProductLine = productLine;
	}

	public String getProductScale() {
		return ProductScale;
	}

	public void setProductScale(String productScale) {
		this.ProductScale = productScale;
	}

	public String getProductVendor() {
		return ProductVendor;
	}

	public void setProductVendor(String productVendor) {
		this.ProductVendor = productVendor;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		this.ProductDescription = productDescription;
	}

	public Integer getQuantityInStock() {
		return QuantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.QuantityInStock = quantityInStock;
	}

	public Double getBuyPrice() {
		return BuyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.BuyPrice = buyPrice;
	}

	public Double getMsrp() {
		return Msrp;
	}

	public void setMsrp(Double Msrp) {
		this.Msrp = Msrp;
	};
	
	
}

package com.classicModels.DTO;

import com.classicModels.beans.ProductsBean;

public class ProductsDTO extends AbstractDTO{

	private String ProductCode;
	private String ProductName;
	private String ProductLine;
	private String ProductScale;
	private String ProductVendor;
	private String ProductDescription;
	private int QuantityInStock;
	private Double BuyPrice ;
	private Double Msrp;


public ProductsDTO() {clear();}
	
	public ProductsDTO(ProductsBean bean) {
		
		// Correspondent en tous point aux champs de la table classicmodels.Products
			
				
		this.ProductCode=bean.getProductCode();
		this.ProductName=bean.getProductName();
		this.ProductLine=bean.getProductLine();
		this.ProductScale=bean.getProductScale();
		this.ProductVendor=bean.getProductVendor();
		this.ProductDescription=bean.getProductDescription();
		this.QuantityInStock=bean.getQuantityInStock();
		this.BuyPrice=bean.getBuyPrice();
		this.Msrp=bean.getMsrp();
				
			}
			
	public void clear() {
				
		this.ProductCode="";
		this.ProductName="";
		this.ProductLine="";
		this.ProductScale="";
		this.ProductVendor="";
		this.ProductDescription="";
		this.QuantityInStock=0;
		this.BuyPrice=0.0;
		this.Msrp=0.0;
				
	}		
			
	public ProductsBean getBean() {
			
				ProductsBean bean = new ProductsBean();
				
				bean.setProductCode(getProductCode());
				bean.setProductName(getProductName());
				bean.setProductLine(getProductLine());
				bean.setProductScale(getProductScale());
				bean.setProductVendor(getProductVendor());
				bean.setProductDescription(getProductDescription());
				bean.setQuantityInStock(getQuantityInStock());
				bean.setBuyPrice(getBuyPrice());
				bean.setMsrp(getMsrp());
				
				
				
				return bean;
				
			}
	
	public String toString() {
		StringBuilder sb =new StringBuilder();
			sb.append("[ProductsDTO]\n")
				.append("ProductCode : ").append(this.getProductCode()).append(", ")
				.append("ProductName : ").append(this.getProductName()).append(", \n")
				.append("ProductLine : ").append(this.getProductLine()).append(", \n")
				.append("ProductScale : ").append(this.getProductScale()).append(", \n")
				.append("ProductVendor : ").append(this.getProductVendor()).append(", \n")
				.append("ProductDescription : ").append(this.getProductDescription()).append(", \n")
				.append("QuantityInStock : ").append(this.getQuantityInStock()).append(", \n")
				.append("BuyPrice : ").append(this.getBuyPrice()).append(", \n")
				.append("Msrp  : ").append(this.getMsrp()).append(", ");
				
			return sb.toString();
						
						
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductLine() {
		return ProductLine;
	}

	public void setProductLine(String productLine) {
		ProductLine = productLine;
	}

	public String getProductScale() {
		return ProductScale;
	}

	public void setProductScale(String productScale) {
		ProductScale = productScale;
	}

	public String getProductVendor() {
		return ProductVendor;
	}

	public void setProductVendor(String productVendor) {
		ProductVendor = productVendor;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

	public int getQuantityInStock() {
		return QuantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		QuantityInStock = quantityInStock;
	}

	public Double getBuyPrice() {
		return BuyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		BuyPrice = buyPrice;
	}

	public Double getMsrp() {
		return Msrp;
	}

	public void setMsrp(Double msrp) {
		Msrp = msrp;
	}





}

package com.classicModels.DTO;

import com.classicModels.beans.ProductLinesBean;

public class ProductLinesDTO extends AbstractDTO{

	private String ProductLine;
	private String TextDescription;
	private String HtmlDescription;
	private String Image;
	
	public ProductLinesDTO() {clear();}
	
	public ProductLinesDTO(ProductLinesBean bean) {
			
				this.ProductLine=bean.getProductLine();
				this.TextDescription=bean.getTextDescription();
				this.HtmlDescription=bean.getHtmlDescription();
				this.Image=bean.getImage();
				
			}
			
	public void clear() {
				
				this.ProductLine="";
				this.TextDescription="";
				this.HtmlDescription="";
				this.Image="";
	}		
			
	public ProductLinesBean getBean() {
			
				ProductLinesBean bean = new ProductLinesBean();
				
				bean.setProductLine(getProductLine());
				bean.setTextDescription(getTextDescription());
				bean.setHtmlDescription(getHtmlDescription());
				bean.setImage(getImage());
				
				
				return bean;
				
			}

	public String getProductLine() {
		return ProductLine;
	}

	public void setProductLine(String productLine) {
		ProductLine = productLine;
	}

	public String getTextDescription() {
		return TextDescription;
	}

	public void setTextDescription(String textDescription) {
		TextDescription = textDescription;
	}

	public String getHtmlDescription() {
		return HtmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		HtmlDescription = htmlDescription;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
}

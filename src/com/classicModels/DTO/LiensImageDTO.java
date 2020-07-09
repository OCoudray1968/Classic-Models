package com.classicModels.DTO;

import com.classicModels.beans.LiensImagesBean;

public class LiensImageDTO extends AbstractDTO {
	
	private int CustomerNumber;
	private int EmployeeNumber;
	private int IdImage;
	private String ProductCode;
	
	
	public  LiensImageDTO() {clear();}
	
	public LiensImageDTO(LiensImagesBean bean) {
		
			this.CustomerNumber=bean.getCustomerNumber();
			this.EmployeeNumber=bean.getEmployeeNumber();
			this.IdImage=bean.getIDImage();
			this.ProductCode=bean.getProductCode();
			
		}
		
	public void clear() {
			
			this.CustomerNumber=0;
			this.EmployeeNumber=0;
			this.IdImage=0;
			this.ProductCode="";
			
		}
		
	public LiensImagesBean getBean() {
		
			LiensImagesBean bean = new LiensImagesBean();
			
			bean.setIDImage(getIdImage());
			bean.setCustomerNumber(getCustomerNumber());
			bean.setIDImage(getIdImage());
			bean.setProductCode(getProductCode());
			
			return bean;
			
		}
	
	public String toString() {
		StringBuilder sb =new StringBuilder();
			sb.append("[LiensImageDTO]\n")
				.append("customer_number : ").append(this.getCustomerNumber()).append(", \n")
				.append("employee_number : ").append(this.getEmployeeNumber()).append(", \n")
				.append("product_code : ").append(this.getProductCode()).append(", \n")
				.append("id_image : ").append(this.getIdImage()).append(", \n");
				
			return sb.toString();
						
						
	}

	public int getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		CustomerNumber = customerNumber;
	}

	public int getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		EmployeeNumber = employeeNumber;
	}

	public int getIdImage() {
		return IdImage;
	}

	public void setIdImage(int idImage) {
		IdImage = idImage;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

}

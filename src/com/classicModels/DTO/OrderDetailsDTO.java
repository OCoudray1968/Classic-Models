package com.classicModels.DTO;

import com.classicModels.beans.OrderDetailsBean;

public class OrderDetailsDTO extends AbstractDTO{
	
	private int OrderNumber ;
	private String ProductCode;
	private int QuantityOrdered;
	private Double PriceEach;
	private int OrderLineNumber;


	public OrderDetailsDTO() {clear();}
	
	public OrderDetailsDTO(OrderDetailsBean bean) {
			
				this.OrderNumber=bean.getOrderNumber();
				this.ProductCode=bean.getProductCode();
				this.QuantityOrdered=bean.getQuantityOrdered();
				this.PriceEach=bean.getPriceEach();
				this.OrderLineNumber=bean.getOrderLineNumber();
			
			}
			
	public void clear() {
				
				this.OrderNumber=0;
				this.ProductCode="";
				this.QuantityOrdered=0;
				this.PriceEach=0.0;
				this.OrderLineNumber=0;
	}		
			
	public OrderDetailsBean getBean() {
			
				OrderDetailsBean bean = new OrderDetailsBean();
				
				bean.setOrderNumber(getOrderNumber());
				bean.setProductCode(getProductCode());
				bean.setQuantityOrdered(getQuantityOrdered());
				bean.setOrderLineNumber(getOrderLineNumber());
				
				return bean;
				
			}
	
	public String toString() {
		StringBuilder sb =new StringBuilder();
			sb.append("[orderdetailsDTO]\n")
				.append("order_number : ").append(this.getOrderNumber()).append(", \n")
				.append("product_code : ").append(this.getProductCode()).append(", \n")
				.append("quantity_ordered : ").append(this.getQuantityOrdered()).append(", \n")
				.append("price_each : ").append(this.getPriceEach()).append(", \n")
				.append("order_line_number : ").append(this.getOrderLineNumber()).append(", \n");
								
				
			return sb.toString();
						
						
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public int getQuantityOrdered() {
		return QuantityOrdered;
	}

	public void setQuantityOrdered(int quantityOdered) {
		QuantityOrdered = quantityOdered;
	}

	public Double getPriceEach() {
		return PriceEach;
	}

	public void setPriceEach(Double priceEach) {
		PriceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return OrderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		OrderLineNumber = orderLineNumber;
	}



}

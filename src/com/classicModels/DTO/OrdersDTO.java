package com.classicModels.DTO;

import java.util.Date;

import com.classicModels.beans.OrdersBean;



public class OrdersDTO extends AbstractDTO{
	
		private int OrderNumber ;
		private Date OrderDate;
		private Date RequiredDate;
		private Date ShippedDate;
		private String StatusOrder;
		private String Comments ;
		private long CustomerNumber;

		public OrdersDTO() {clear();}
		
		public OrdersDTO(OrdersBean bean) {
				
					this.OrderNumber=bean.getOrderNumber();
					this.OrderDate=bean.getOrderDate();
					this.RequiredDate=bean.getRequiredDate();
					this.ShippedDate=bean.getShippedDate();
					this.StatusOrder=bean.getStatus();
					this.Comments=bean.getComments();
					this.CustomerNumber=bean.getCustomerNumber();
				
				}
				
		public void clear() {
					
					this.OrderNumber=0;
					this.OrderDate=new Date(0);
					this.RequiredDate=new Date(0);
					this.ShippedDate=new Date(0);
					this.StatusOrder="";
					this.Comments="";
					this.CustomerNumber=0;
		}		
				
		public OrdersBean getBean() {
				
					OrdersBean bean = new OrdersBean();
					
					bean.setOrderNumber(getOrderNumber());
					bean.setOrderDate(getOrderDate());
					bean.setRequiredDate(getRequiredDate());
					bean.setShippedDate(getShippedDate());
					bean.setStatus(getStatusOrder());
					bean.setComments(getComments());
					bean.setCustomerNumber(getCustomerNumber());
					
					return bean;
					
				}
		
		public String toString() {
			StringBuilder sb =new StringBuilder();
				sb.append("[ordersDTO]\n")
					.append("orderNumber : ").append(this.getOrderNumber()).append(", \n")
					.append("orderDate ").append(this.getOrderDate()).append(", \n")
					.append("requiredDate : ").append(this.getRequiredDate()).append(", \n")
					.append("shippedDate : ").append(this.getShippedDate()).append(", \n")
					.append("statusOrders : ").append(this.getStatusOrder()).append(", \n")
					.append("comments ").append(this.getComments()).append(", \n")
					.append("customerNumber :").append(this.getCustomerNumber()).append(", \n");
					
					
				return sb.toString();
							
							
		}

		public int getOrderNumber() {
			return OrderNumber;
		}

		public void setOrderNumber(int orderNumber) {
			OrderNumber = orderNumber;
		}

		public Date getOrderDate() {
			return OrderDate;
		}

		public void setOrderDate(Date date) {
			OrderDate = date;
		}

		public Date getRequiredDate() {
			return RequiredDate;
		}

		public void setRequiredDate(Date requiredDate) {
			RequiredDate = requiredDate;
		}

		public Date getShippedDate() {
			return ShippedDate;
		}

		public void setShippedDate(Date shippedDate) {
			ShippedDate = shippedDate;
		}

		public String getStatusOrder() {
			return StatusOrder;
		}

		public void setStatusOrder(String statusOrder) {
			StatusOrder = statusOrder;
		}

		public String getComments() {
			return Comments;
		}

		public void setComments(String comments) {
			Comments = comments;
		}

		public long getCustomerNumber() {
			return CustomerNumber;
		}

		public void setCustomerNumber(long l) {
			CustomerNumber = l;
		}




}

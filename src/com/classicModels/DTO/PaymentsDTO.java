package com.classicModels.DTO;

import java.util.Date;

import com.classicModels.beans.PaymentsBean;




public class PaymentsDTO extends AbstractDTO{
	
	private int CustomerNumber ;
	private String CheckNumber ;
	private Date PaymentDate;
	private Double AmountPayment ;
	
	public PaymentsDTO() {clear();}
	
	public PaymentsDTO(PaymentsBean bean) {
			
				this.CustomerNumber=bean.getCustomerNumber();
				this.CheckNumber=bean.getCheckNumber();
				this.PaymentDate=bean.getPaymentDate();
				this.AmountPayment=bean.getAmountPayment();
				
			}
			
	public void clear() {
				
				this.CustomerNumber=0;
				this.CheckNumber="";
				this.PaymentDate=new Date(0);
				this.AmountPayment=0.0;
				
	}		
			
	public PaymentsBean getBean() {
			
				PaymentsBean bean = new PaymentsBean();
				
				bean.setCustomerNumber(getCustomerNumber());
				bean.setCheckNumber(getCheckNumber());
				bean.setPaymentDate(getPaymentDate());
				bean.setAmountPayment(getAmountPayment());
				
				
				return bean;
				
			}
	
	public String toString() {
		StringBuilder sb =new StringBuilder();
			sb.append("[paymentsDTO]\n")
				.append("customer_number : ").append(this.getCustomerNumber()).append(", \n")
				.append("check_number: ").append(this.getCheckNumber()).append(", \n")
				.append("payment_date : ").append(this.getPaymentDate()).append(", \n")
				.append("amount: ").append(this.getAmountPayment()).append(", \n");
				
				
			return sb.toString();
						
						
	}

	public int getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		CustomerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return CheckNumber;
	}

	public void setCheckNumber(String checkNumber) {
		CheckNumber = checkNumber;
	}

	public Date getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		PaymentDate = paymentDate;
	}

	public Double getAmountPayment() {
		return AmountPayment;
	}

	public void setAmountPayment(Double amountPayment) {
		AmountPayment = amountPayment;
	}	
}

package com.classicModels.beans;

import java.util.Date;

public class PaymentsBean {

	// Num client (lien avec la table customers)
	private int CustomerNumber = 0;
	//Num paiement
	private String CheckNumber = "";
	// date de paiement
	private Date PaymentDate;
	//montant du paiement
	private Double AmountPayment ;
	
	public PaymentsBean(int CustomerNumber, String CheckNumber, Date PaymentDate, Double AmountPayment) {
		
		this.CustomerNumber=CustomerNumber;
		this.CheckNumber=CheckNumber;
		this.PaymentDate=PaymentDate;
		this.AmountPayment=AmountPayment;
		
	}
	
	public PaymentsBean() {}

	public int getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.CustomerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return CheckNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.CheckNumber = checkNumber;
	}

	public Date getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.PaymentDate = paymentDate;
	}

	public Double getAmountPayment() {
		return AmountPayment;
	}

	public void setAmountPayment(Double AmountPayment) {
		this.AmountPayment = AmountPayment;
	};
	
	
}

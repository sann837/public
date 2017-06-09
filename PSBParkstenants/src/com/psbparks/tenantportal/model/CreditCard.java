package com.psbparks.tenantportal.model;

/**
 * @author Sandeep Thandra 
 * This class is designed to hold entities related to
 * the CreditCard and providing access through only getters by making
 * them private
 *
 *
 */
public class CreditCard {

	private String cardNumber;
	private String nameoncard;
	private String cvv;
	private String expiryDate;
	private double amount;

	public String getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", nameoncard=" + nameoncard + ", cvv=" + cvv + ", expiryDate="
				+ expiryDate + ", amount=" + amount + "]";
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}

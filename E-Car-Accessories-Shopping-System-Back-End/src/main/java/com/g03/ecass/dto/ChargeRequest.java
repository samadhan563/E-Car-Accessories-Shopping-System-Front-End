package com.g03.ecass.dto;

/*
public enum Currency{
   INR;
}

private String description;
private int amount;
private Currency currency;


public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public int getAmount() {
    return amount;
}

public void setAmount(int amount) {
    this.amount = amount;
}

public Currency getCurrency() {
    return currency;
}

public void setCurrency(Currency currency) {
    this.currency = currency;
}*/

public class ChargeRequest {
	public enum Currency {
		INR;
	}

	private String description;
	private double amount;
	private Currency currency;
	private String stripeEmail;
	private String stripeToken;

	public ChargeRequest() {
		// TODO Auto-generated constructor stub
	}

	public ChargeRequest(String description, double amount, Currency currency, String stripeEmail, String stripeToken) {
		super();
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.stripeEmail = stripeEmail;
		this.stripeToken = stripeToken;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getStripeEmail() {
		return stripeEmail;
	}

	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}

	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	@Override
	public String toString() {
		return "ChargeRequest [description=" + description + ", amount=" + amount + ", currency=" + currency
				+ ", stripeEmail=" + stripeEmail + ", stripeToken=" + stripeToken + "]";
	}
	

}
package com.arun.stripepayments.form;

import javax.validation.constraints.*;

public class CheckoutForm {
	
	@NotNull
	@Min(5)
	private Integer amount;
	
	@NotNull
	@Size(min = 5, max = 200)
	private String featureRequest;
	
	@Email
	private String email;
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getFeatureRequest() {
		return featureRequest;
	}
	
	public void setFeatureRequest(String featureRequest) {
		this.featureRequest = featureRequest;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}

package com.arun.stripepayments.dto;

import javax.validation.constraints.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

//import com.google.gson.annotations.SerializedName;

public class CreatePayment {
	
		@NotNull
		@Min(5)
	    private Integer amount;
	    
		@NotNull
		@Size(min = 5, max = 200)
	    private String featureRequest;

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

}

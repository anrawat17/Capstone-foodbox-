package com.app.foodbox;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripe.Stripe;

@SpringBootApplication
public class CapstoneProjectApplication {
	
	@PostConstruct
	public void setup() {
		//Stripe Secret Key
		Stripe.apiKey = "Enter your stripe secret key here";
	}

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);
	}

}

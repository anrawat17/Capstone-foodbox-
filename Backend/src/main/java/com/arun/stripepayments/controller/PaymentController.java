package com.arun.stripepayments.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishekjain.stripepayments.dto.CreatePayment;
import com.abhishekjain.stripepayments.dto.CreatePaymentResponse;
import com.abhishekjain.stripepayments.form.CheckoutForm;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
public class PaymentController {

	@PostMapping("/create-payment-intent")
	public CreatePaymentResponse createPaymentIntent(@RequestBody @Valid CreatePayment createPayment) throws StripeException {
		      List<String> paymentMethodTypes = new ArrayList<>();
//		      paymentMethodTypes.add("giropay");
//		      paymentMethodTypes.add("eps");
//		      paymentMethodTypes.add("p24");
//		      paymentMethodTypes.add("sofort");
//		      paymentMethodTypes.add("sepa_debit");
		      paymentMethodTypes.add("card");
//		      paymentMethodTypes.add("bancontact");
//		      paymentMethodTypes.add("ideal");
		      System.out.println(createPayment.toString());
		      PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
		          .setAmount(createPayment.getAmount() * 100L)
		          .setCurrency("inr")
		          .putMetadata("featureRequest", createPayment.getFeatureRequest())
		          .addAllPaymentMethodType(paymentMethodTypes)
		          .build();

		      // Create a PaymentIntent with the order amount and currency
		      PaymentIntent paymentIntent = PaymentIntent.create(params);

		      return new CreatePaymentResponse(paymentIntent.getClientSecret());
	}
}

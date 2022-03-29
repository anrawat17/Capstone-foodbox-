package com.arun.stripepayments.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.abhishekjain.stripepayments.dto.CreatePayment;
import com.abhishekjain.stripepayments.form.CheckoutForm;

@Controller
public class WebController {
	
/*	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("checkoutForm", new CheckoutForm());
//		model.addAttribute("checkoutForm", new CreatePayment());
		return "index";
	}
*/	
	@PostMapping("/")
	public String checkout(@ModelAttribute @Valid CheckoutForm checkoutForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		model.addAttribute("amount", checkoutForm.getAmount());
		model.addAttribute("email", checkoutForm.getEmail());
		model.addAttribute("featureRequest", checkoutForm.getFeatureRequest());
//		CreatePayment createPayment = new CreatePayment();
//		CheckoutForm checkoutForm1 = new CheckoutForm();
//		BeanUtils.copyProperties(createPayment, checkoutForm1);
//		createPayment.setAmount(checkoutForm.getAmount());
//		model.addAttribute("featureRequest", createPayment.setFeatureRequest(featureRequest));
		return "checkout";
	}
	
	@GetMapping("success")
	public String done(Model model) {
		return "thank";
	}

}

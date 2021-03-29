package com.g03.ecass.service.impls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.g03.ecass.dto.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.model.Charge;

@Service
//@Transactional
public class StripeService {
	/*
	 * @Value("${STRIPE_SECRET_KEY}") private String API_SECRET_KEY;
	 * 
	 * @Autowired public PaymentService() { Stripe.apiKey = API_SECRET_KEY; }
	 * 
	 * 
	 * public PaymentIntent paymentIntent(PaymentIntentDto paymentIntentDto) throws
	 * Exception { System.out.println(paymentIntentDto); // Stripe.apiKey =
	 * secretKey; List<String> paymentMethodTypes = new ArrayList<>();
	 * paymentMethodTypes.add("card"); Map<String, Object> params = new HashMap<>();
	 * params.put("amount", paymentIntentDto.getAmount()); params.put("currency",
	 * paymentIntentDto.getCurrency()); params.put("description",
	 * paymentIntentDto.getDescription()); params.put("payment_method_types",
	 * paymentMethodTypes); return PaymentIntent.create(params); }
	 * 
	 * public PaymentIntent confirm(String id) throws Exception { Stripe.apiKey =
	 * API_SECRET_KEY; PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
	 * Map<String, Object> params = new HashMap<>(); params.put("payment_method",
	 * "pm_card_visa"); paymentIntent.confirm(params); return paymentIntent; }
	 * 
	 * public PaymentIntent cancel(String id) throws Exception { Stripe.apiKey =
	 * API_SECRET_KEY; PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
	 * paymentIntent.cancel(); return paymentIntent; }
	 */

	@Value("${STRIPE_SECRET_KEY}")
	private String secretKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}

	public Charge charge(ChargeRequest chargeRequest) throws Exception {
		List<Object> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");
		Map<String, Object> chargeParams = new HashMap<>();
		chargeParams.put("amount", Math.round(chargeRequest.getAmount()));

		chargeParams.put("currency", chargeRequest.getCurrency());
		chargeParams.put("description", chargeRequest.getDescription());
		// chargeParams.put("email", chargeRequest.getStripeEmail());
		chargeParams.put("receipt_email", chargeRequest.getStripeEmail());
		// chargeParams.put("confirm", true);
		// chargeParams.put("capture_method", "automatic");
		// chargeParams.put("payment_method_types", paymentMethodTypes);
		// chargeParams.put("created", 1616994490);
		chargeParams.put("source", chargeRequest.getStripeToken());
		return Charge.create(chargeParams);
	}

}
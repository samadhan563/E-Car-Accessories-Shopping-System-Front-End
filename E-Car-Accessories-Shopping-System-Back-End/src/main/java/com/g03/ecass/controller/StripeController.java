package com.g03.ecass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g03.ecass.dto.ChargeRequest;
import com.g03.ecass.dto.ChargeRequest.Currency;
import com.g03.ecass.service.impls.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@RestController
@RequestMapping("/stripe")
@CrossOrigin
public class StripeController {

	@Autowired
	private StripeService paymentService;
/*
	@Value("${STRIPE_SECRET_KEY}")
	private String stripePublicKey;
*/
	public StripeController() {

	}

	@PostMapping("/paymentintent")
	public void charge(@RequestBody ChargeRequest chargeRequest) throws StripeException {
		System.out.println(chargeRequest);
		chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(Currency.INR);
		try {
			Charge charge = paymentService.charge(chargeRequest);
			System.out.println(charge);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * model.addAttribute("id", charge.getId()); model.addAttribute("status",
		 * charge.getStatus()); model.addAttribute("chargeId", charge.getId());
		 * model.addAttribute("balance_transaction", charge.getBalanceTransaction());
		 * return "result";
		 */
	}

	/*
	 * @PostMapping("/paymentintent") public ResponseEntity<String>
	 * payment(@RequestBody PaymentIntentDto paymentIntentDto) throws Exception {
	 * PaymentIntent paymentIntent = paymentService.paymentIntent(paymentIntentDto);
	 * String paymentStr = paymentIntent.toJson(); return new
	 * ResponseEntity<String>(paymentStr, HttpStatus.OK); }
	 * 
	 * @PostMapping("/confirm/{id}") public ResponseEntity<String>
	 * confirm(@PathVariable("id") String id) throws Exception { PaymentIntent
	 * paymentIntent = paymentService.confirm(id); String paymentStr =
	 * paymentIntent.toJson(); return new ResponseEntity<String>(paymentStr,
	 * HttpStatus.OK); }
	 * 
	 * @PostMapping("/cancel/{id}") public ResponseEntity<String>
	 * cancel(@PathVariable("id") String id) throws Exception { PaymentIntent
	 * paymentIntent = paymentService.cancel(id); String paymentStr =
	 * paymentIntent.toJson(); return new ResponseEntity<String>(paymentStr,
	 * HttpStatus.OK); }
	 */
}
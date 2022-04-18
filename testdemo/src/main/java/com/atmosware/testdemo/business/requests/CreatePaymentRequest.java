package com.atmosware.testdemo.business.requests;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
	
	private int id;
	private double total;
	private int customerId;
	private int transactionId;
	
	
	private CreateCreditCardRequest createCreditCardRequest;

}

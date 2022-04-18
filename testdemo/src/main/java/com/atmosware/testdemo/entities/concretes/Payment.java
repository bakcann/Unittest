package com.atmosware.testdemo.entities.concretes;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private int id;
	private double total;
	private int customerId;
	private int transactionId;
	private LocalDate date;

}







//add payment yaz ->Customer , CreditCard (kredi kartı bilgisi al - müşteri bilgisi al) --> Request
//Bu müşterinin sistemde olması gerekir yoksa businessException fırlat.
//Exp.date bu aydan önce olması gerekir.
//Banka sisteminin kredi kartına onay vermesi gerekir.
//herşey ın memory
//mocking-mockito (sıkıştıgında arastır)

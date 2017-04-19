package com.ronalag.ronabank.webservice;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ronalag.ronabank.webservice.common.Common;
import com.ronalag.ronabank.webservice.financialcalculators.GetMonthlyPaymentRequest;
import com.ronalag.ronabank.webservice.financialcalculators.GetMonthlyPaymentResponse;

@Endpoint
public class FinancialCalculatorEndpoint {
	
	private static final int ONE_HUNDRED_PERCENT = 100;
	
	private static final int DEFAULT_PRECISION = 5;
	
	private static final String GET_MONTHLY_PAYMENT_REQUEST_PATH = "getMonthlyPaymentRequest";
	
	private static final int MONTHS_PER_YEAR = 12;

	private static final int RESULT_PRECISION = 2;
	
	/**
	 * Calculates the monthly mortgage payment bassed on the request.
	 * 
	 * @param request Input containing all the information required.
	 * @return A response containing the calculated result.
	 */
	@PayloadRoot(namespace = Common.NAMESPACE_URI, localPart = GET_MONTHLY_PAYMENT_REQUEST_PATH)
	@ResponsePayload
	public GetMonthlyPaymentResponse getCountry(@RequestPayload GetMonthlyPaymentRequest request) {
		GetMonthlyPaymentResponse response = new GetMonthlyPaymentResponse();
		
		/*
		 * Formula to calculate monthly payment is M = P [i(1+i)^n]/[(1+i)^n-1]
		 * 
		 * where:
		 * 
		 * M - Monthly mortgage payment
		 * P - The principle
		 * i - The monthly interest rate
		 * n - The number of payments over the life of the loan
		 * 
		 */
		
		int noPayments = request.getAmortization() * MONTHS_PER_YEAR; 
		BigDecimal interestRate = request.getInterestRate()
				.divide(new BigDecimal(ONE_HUNDRED_PERCENT), DEFAULT_PRECISION, RoundingMode.HALF_UP)
				.divide(new BigDecimal(MONTHS_PER_YEAR), DEFAULT_PRECISION, RoundingMode.HALF_UP);
		BigDecimal principal = request.getPurchasePrice().subtract(request.getDownPayment());
		BigDecimal formulaPart = new BigDecimal(1).add(interestRate);
		BigDecimal composedFormulaPart = formulaPart.pow(noPayments-1);
		BigDecimal numerator = principal.multiply(interestRate.multiply(composedFormulaPart).multiply(formulaPart));
		BigDecimal denominator = composedFormulaPart;
		BigDecimal monthlyPayment = numerator.divide(denominator, RESULT_PRECISION, RoundingMode.HALF_UP);
		response.setMonthlyPayment(monthlyPayment);

		return response;
	}
}

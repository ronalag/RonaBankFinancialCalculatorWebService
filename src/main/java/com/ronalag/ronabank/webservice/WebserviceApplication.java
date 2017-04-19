package com.ronalag.ronabank.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main class for the SOAP web service application.
 * 
 * @author Henry Aghaulor
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"com.ronalag.ronabank.webservice"})
public class WebserviceApplication {

	/**
	 * The entry point for the application.
	 * 
	 * @param args Command line arguments supplied to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}
}

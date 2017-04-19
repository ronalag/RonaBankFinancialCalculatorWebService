package com.ronalag.ronabank.webservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.ronalag.ronabank.webservice.common.Common;

/**
 * Configures beans for the web service.
 * 
 * @author Henry Aghaulor
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	private static final String LOCATION_URI = "/ws";
	
	private static final String PORT_TYPE_NAME = "FiancialCalculatorsPort";
	
	private static final String SCHEMA_FILE_NAME = "financialcalculators.xsd";
	
	private static final String WEB_SERVICE_REQUEST_BASE_PATH = "/ws/*";
		
	/**
	 * Generates a Servlet used to handle SOAP messages.
	 * 
	 * @param applicationContext The context of the application.
	 * @return A configured Servlet.
	 */
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, WEB_SERVICE_REQUEST_BASE_PATH);
	}

	/**
	 * Generates a WSDL definition.
	 * 
	 * @param financialCalculatorsSChema A object representation of a schema used to generate the WSDL.
	 * @return A WSDL definition.
	 */
	@Bean(name = "financialcalculators")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema financialCalculatorsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName(PORT_TYPE_NAME);
		wsdl11Definition.setLocationUri(LOCATION_URI);
		wsdl11Definition.setTargetNamespace(Common.NAMESPACE_URI);
		wsdl11Definition.setSchema(financialCalculatorsSchema);
		return wsdl11Definition;
	}

	/**
	 * Generates a financial calculators schema.
	 * 
	 * @return A financial calculators schema.
	 */
	@Bean
	public XsdSchema financialCalculatorsSchema() {
		return new SimpleXsdSchema(new ClassPathResource(SCHEMA_FILE_NAME));
	}
}

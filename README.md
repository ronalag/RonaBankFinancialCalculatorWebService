# RonaBankFinancialCalculatorWebService
A SOAP web service component of the Rona Bank SOA application. It contains an service endpoint for calculating monthly mortgage payments.

## What you'll need

* JDK 1.8
* Maven 3.0+
* Service Registry application such as [Eureka Server](https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance). You can learn more about setting a server by looking at this [guide](https://spring.io/guides/gs/service-registration-and-discovery/) on [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/).

## How to build and run the application

The Service Registry application should be running before you start this service.

Run the following command:

```
mvn spring-boot:run
```

This will start the web service on a random port. If you want to run the application on a specific port number you can add the option `-Dserver.port=1111`.

## Related projects

[Ronabank-website](https://github.com/ronalag/RonaBankWebSite)

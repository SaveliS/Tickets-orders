package com.saveli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(App.class, args);
        // ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        // var aspect = context.getBean(LoggingAspect.class);
        // System.out.println(aspect.toString());
        // var context = new AnnotationConfigApplicationContext(SpringConfign.class);
        //var customerService = context.getBean(CustomerService.class);
        // CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
        // TicketRepository ticketRepository = context.getBean(TicketRepository.class);
        // CustomerPrinter customerPrinter = new CustomerPrinter(customerRepository);
        // customerPrinter.run(args);   
    }
}

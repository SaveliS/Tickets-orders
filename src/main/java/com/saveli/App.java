package com.saveli;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.saveli.aspect.LoggingAspect;
import com.saveli.configuration.SpringConfign;
import com.saveli.logging.CreateLogs;
import com.saveli.repository.CustomerRepository;
import com.saveli.repository.TicketRepository;
import com.saveli.service.CustomerService;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;


@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        Iterator iter = customerService.getAllCustomer().iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
        var aspect = context.getBean(LoggingAspect.class);
        System.out.println(aspect.toString());
        // var context = new AnnotationConfigApplicationContext(SpringConfign.class);
        //var customerService = context.getBean(CustomerService.class);
        // CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
        // TicketRepository ticketRepository = context.getBean(TicketRepository.class);
        // CustomerPrinter customerPrinter = new CustomerPrinter(customerRepository);
        // customerPrinter.run(args);
        
    }
}

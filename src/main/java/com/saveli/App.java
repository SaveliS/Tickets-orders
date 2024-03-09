package com.saveli;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.saveli.configuration.SpringConfign;
import com.saveli.repository.CustomerRepository;
import com.saveli.service.CustomerService;


@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        var context = new AnnotationConfigApplicationContext(SpringConfign.class);
        var customerService = context.getBean(CustomerService.class);
        // CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
        // CustomerPrinter customerPrinter = new CustomerPrinter(customerRepository);
        // customerPrinter.run(args);
        
    }
}

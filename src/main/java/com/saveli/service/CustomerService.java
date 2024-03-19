package com.saveli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveli.aspect.ToLog;
import com.saveli.logging.CreateLogs;
import com.saveli.model.Customer;
import com.saveli.repository.CustomerRepository;

@Service
public class CustomerService {

    private CreateLogs logger = new CreateLogs();
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @ToLog
    public Iterable<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @ToLog
    public List<Customer> findByname(String name){
        return customerRepository.findByname(name);
    }
}

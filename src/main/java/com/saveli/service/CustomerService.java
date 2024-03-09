package com.saveli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveli.model.Customer;
import com.saveli.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public List<Customer> findByname(String name){
        return customerRepository.findByname(name);
    }
}

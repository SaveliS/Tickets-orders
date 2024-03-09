package com.saveli.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saveli.model.Customer;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
    List<Customer> findByname(String name);
    List<Customer> findAll();
}

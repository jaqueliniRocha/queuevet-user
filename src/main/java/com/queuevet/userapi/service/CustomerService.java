package com.queuevet.userapi.service;

import com.queuevet.userapi.model.Customer;
import com.queuevet.userapi.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        if (customerRepository.existsByCpf(customer.getCpf())) {
            throw new RuntimeException("Existing customer with this cpf!");
        }
        return customerRepository.save(customer);
    }
}

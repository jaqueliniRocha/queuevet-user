package com.queuevet.user.application;

import com.queuevet.user.model.Customer;
import com.queuevet.user.model.repository.CustomerRepository;
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

package com.queuevet.user.infrastructure.rest;

import com.queuevet.user.infrastructure.rest.exception.CustomerNotFoundException;
import com.queuevet.user.model.Customer;
import com.queuevet.user.model.repository.CustomerRepository;
import com.queuevet.user.application.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customer")
    List<Customer> all(){
        return repository.findAll();
    }

    @PostMapping("/customer")
    Customer create(@RequestBody Customer newCostumer){
        return customerService.save(newCostumer);
    }

    @GetMapping("/customer/{id}")
    Customer findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customer/{id}")
    Customer update(@RequestBody Customer newCustomer, @PathVariable Long id){
        return repository.findById(id)
                .map(customer -> {
                    customer.setAnimals(newCustomer.getAnimals());
                    customer.setName(newCustomer.getName());
                    customer.setCpf(newCustomer.getCpf());
                    return repository.save(newCustomer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customer/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }


}

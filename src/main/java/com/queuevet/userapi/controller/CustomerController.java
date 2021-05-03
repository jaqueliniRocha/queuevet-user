package com.queuevet.userapi.controller;

import com.queuevet.userapi.model.Customer;
import com.queuevet.userapi.model.CustomerRepository;
import com.queuevet.userapi.model.User;
import com.queuevet.userapi.service.CustomerService;
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
    Customer newCustomer(@RequestBody Customer newCostumer){
        return customerService.save(newCostumer);
    }

    @GetMapping("/customer/{id}")
    Customer findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customer/{id}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){
        return repository.findById(id)
                .map(customer -> {
                    customer.setNamePet(newCustomer.getNamePet());
                    customer.setName(newCustomer.getName());
                    customer.setCpf(newCustomer.getCpf());
                    customer.setConsultationDate((newCustomer.getConsultationDate()));
                    return repository.save(newCustomer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Long id){
        repository.deleteById(id);
    }


}

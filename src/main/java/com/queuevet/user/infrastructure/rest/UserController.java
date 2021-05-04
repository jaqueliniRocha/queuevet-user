package com.queuevet.user.infrastructure.rest;

import java.util.List;

import com.queuevet.user.infrastructure.rest.exception.UserNotFoundException;
import com.queuevet.user.application.UserService;
import com.queuevet.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.queuevet.user.model.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/user")
    User create(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @GetMapping("/user/{id}")
    User findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User update(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/user/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

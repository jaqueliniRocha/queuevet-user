package com.queuevet.userapi.controller;

import com.queuevet.userapi.model.QueueConsRepository;
import com.queuevet.userapi.model.QueueConsult;
import com.queuevet.userapi.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class QueueConsultController {

    @Autowired
    private QueueConsRepository repository;

    @Autowired
    private QueueService queueService;


    @GetMapping("/queue")
    List<QueueConsult> all() {
        return repository.findAll();
    }

    @PostMapping("/queue")
    QueueConsult newQueue(@RequestBody QueueConsult newUser) {
        return queueService.save(newUser);
    }

    @GetMapping("/queue/{id}")
    QueueConsult findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new QueueConsultControllerNotFoundException(id));
    }

    @PutMapping("/queue/{id}")
    QueueConsult replaceUser(@RequestBody QueueConsult newQueue, @PathVariable Long id) {
        return repository.findById(id)
                .map(queue -> {
                    queue.setCustomer(newQueue.getCustomer());
                    queue.setVet(newQueue.getVet());
                    queue.setCurrentDate(newQueue.getCurrentDate());
                    return repository.save(queue);
                })
                .orElseGet(() -> {
                    newQueue.setId(id);
                    return repository.save(newQueue);
                });
    }

    @DeleteMapping("/queue/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

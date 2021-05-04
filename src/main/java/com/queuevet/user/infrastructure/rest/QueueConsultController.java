package com.queuevet.user.infrastructure.rest;

import com.queuevet.user.infrastructure.rest.exception.QueueConsultControllerNotFoundException;
import com.queuevet.user.application.QueueService;
import com.queuevet.user.model.QueueConsult;
import com.queuevet.user.model.repository.QueueConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class QueueConsultController {

    @Autowired
    private QueueConsultRepository repository;

    @Autowired
    private QueueService queueService;


    @GetMapping("/queue")
    List<QueueConsult> all() {
        return repository.findAll();
    }

    @PostMapping("/queue")
    QueueConsult create(@RequestBody QueueConsult newUser) {
        return queueService.save(newUser);
    }

    @GetMapping("/queue/{id}")
    QueueConsult findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new QueueConsultControllerNotFoundException(id));
    }

    @PutMapping("/queue/{id}")
    QueueConsult update(@RequestBody QueueConsult newQueue, @PathVariable Long id) {
        return repository.findById(id)
                .map(queue -> {
                    queue.setCustomer(newQueue.getCustomer());
                    queue.setVet(newQueue.getVet());
                    return repository.save(queue);
                })
                .orElseGet(() -> {
                    newQueue.setId(id);
                    return repository.save(newQueue);
                });
    }

    @DeleteMapping("/queue/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

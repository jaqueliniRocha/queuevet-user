package com.queuevet.user.infrastructure.rest;



import com.queuevet.user.model.Vet;
import com.queuevet.user.model.repository.VetRepository;
import com.queuevet.user.application.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VetController {

    @Autowired
    private VetService vetService;

    @Autowired
    private VetRepository repository;

    @GetMapping("/vet")
    List<Vet> all(){
        return repository.findAll();
    }

    @PostMapping("/vet")
    Vet create(@RequestBody Vet newVet){
        return vetService.save(newVet);
    }

    @GetMapping("/vet/{id}")
    Vet findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VetNotFoundException(id));
    }

    @PutMapping("/vet/{id}")
    Vet update(@RequestBody Vet newVet, @PathVariable Long id){
        return repository.findById(id)
                .map(vet -> {
                    vet.setName(newVet.getName());
                    vet.setCrmv(newVet.getCrmv());
                    return repository.save(newVet);
                })
                .orElseGet(() -> {
                    newVet.setId(id);
                    return repository.save(newVet);
                });
    }

    @DeleteMapping("/vet/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}

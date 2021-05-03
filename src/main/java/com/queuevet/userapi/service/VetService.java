package com.queuevet.userapi.service;

import com.queuevet.userapi.model.Vet;
import com.queuevet.userapi.model.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetService {

    @Autowired
    private VetRepository vetRepository;

    public Vet save(Vet vet){
        if (vetRepository.existsByCrmv(vet.getCrmv())) {
            throw new RuntimeException("Existing vet with this crmv!");
        }
        return vetRepository.save(vet);
    }
}

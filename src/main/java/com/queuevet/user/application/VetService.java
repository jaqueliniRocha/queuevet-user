package com.queuevet.user.application;

import com.queuevet.user.model.Vet;
import com.queuevet.user.model.repository.VetRepository;
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

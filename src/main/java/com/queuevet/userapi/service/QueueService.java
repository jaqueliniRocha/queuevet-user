package com.queuevet.userapi.service;

import com.queuevet.userapi.model.QueueConsRepository;
import com.queuevet.userapi.model.QueueConsult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    @Autowired
    private QueueConsRepository repository;

    public QueueConsult save (QueueConsult queueConsult){
        if(repository.existsById(queueConsult.getId())){
            throw new RuntimeException("Existing Customer with this id!");
        }
        return repository.save(queueConsult);
    }
}

package com.queuevet.user.application;

import com.queuevet.user.model.QueueConsult;
import com.queuevet.user.model.repository.QueueConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    @Autowired
    private QueueConsultRepository repository;

    public QueueConsult save(QueueConsult queueConsult){
        if(repository.existsById(queueConsult.getId())){
            throw new RuntimeException("Existing Customer with this id!");
        }
        return repository.save(queueConsult);
    }
}

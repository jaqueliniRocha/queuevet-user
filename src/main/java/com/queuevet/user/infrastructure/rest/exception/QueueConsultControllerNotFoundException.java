package com.queuevet.user.infrastructure.rest.exception;

public class QueueConsultControllerNotFoundException extends RuntimeException{

    public QueueConsultControllerNotFoundException(Long id) {
        super("Could not find" + id);
    }
}

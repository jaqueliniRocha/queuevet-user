package com.queuevet.userapi.controller;

public class QueueConsultControllerNotFoundException extends RuntimeException{

    public QueueConsultControllerNotFoundException(Long id) {
        super("Could not find" + id);
    }
}

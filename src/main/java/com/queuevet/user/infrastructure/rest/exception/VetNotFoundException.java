package com.queuevet.user.infrastructure.rest.exception;

public class VetNotFoundException extends RuntimeException{

    public VetNotFoundException(Long id){
        super("Could not find Vet" + id);
    }
}

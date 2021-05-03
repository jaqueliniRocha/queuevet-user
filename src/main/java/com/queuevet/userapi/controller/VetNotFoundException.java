package com.queuevet.userapi.controller;

public class VetNotFoundException extends RuntimeException{

    public VetNotFoundException(Long id){
        super("Could not find Vet" + id);
    }
}

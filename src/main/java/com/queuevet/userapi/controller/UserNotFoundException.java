package com.queuevet.userapi.controller;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(Long id) {
		super("Could not find product" + id);
	}
}

package com.quicklearn.web.advice;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(int id) {
		super("Could not find student " + id);
	}

}


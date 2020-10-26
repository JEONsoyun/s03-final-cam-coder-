package com.coder.demo.exception;

public class NotExistIdException extends Exception{
	public NotExistIdException() {
		super("user with this Id dosn't exist");
	}
}

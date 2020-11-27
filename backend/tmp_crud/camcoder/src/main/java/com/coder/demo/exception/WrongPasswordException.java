package com.coder.demo.exception;

public class WrongPasswordException extends Exception {
	public WrongPasswordException() {
		super("password is not correct");
	}
}

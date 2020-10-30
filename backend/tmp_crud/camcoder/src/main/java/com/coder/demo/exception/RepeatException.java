package com.coder.demo.exception;

public class RepeatException extends Exception{
	public RepeatException() {
		super("이미 등록된 유저입니다.");
	}
}

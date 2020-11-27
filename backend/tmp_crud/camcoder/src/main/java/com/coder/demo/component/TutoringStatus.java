package com.coder.demo.component;

public enum TutoringStatus {
	WAITINGF("요청중"),
	WAITINGT("미확인"),
	ACCEPT("수락"),
	COMPLETE("완료"),
	CLOSE("종료");
	
	final private String name;
	
	private TutoringStatus(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}


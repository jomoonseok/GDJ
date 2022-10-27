package com.gdu.app01.xml07;

public class Contact {
	
	// field
	private String address;
	private String domain;
	private String tel;
	
	// constructor
	public Contact(String address, String domain, String tel) {
		super();
		this.address = address;
		this.domain = domain;
		this.tel = tel;
	}
	
	// method
	public void info() {
		System.out.println("주소 : " + address);
		System.out.println("이메일 : " + domain);
		System.out.println("연락처 : " + tel);
	}
	
	

}

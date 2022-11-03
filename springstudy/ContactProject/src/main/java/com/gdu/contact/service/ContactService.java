package com.gdu.contact.service;

import java.util.List;

import com.gdu.contact.domain.Contact;

public interface ContactService {

	public List<Contact> findAllContact();
	public Contact findContactByNo(int no);
	public int saveContact(Contact contact);
	public int modifyContact(Contact contact);
	public int removeContact(int no);
}

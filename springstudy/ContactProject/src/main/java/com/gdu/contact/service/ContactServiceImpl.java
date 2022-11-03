package com.gdu.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.contact.domain.Contact;
import com.gdu.contact.repository.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO dao;

	@Override
	public List<Contact> findAllContact() {
		return dao.selectAllContact();
	}

	@Override
	public Contact findContactByNo(int no) {
		return dao.selectContactByNo(no);
	}

	@Override
	public int saveContact(Contact contact) {
		return dao.insertContact(contact);
	}

	@Override
	public int modifyContact(Contact contact) {
		return dao.updateContact(contact);
	}

	@Override
	public int removeContact(int no) {
		return dao.deleteContact(no);
	}

}

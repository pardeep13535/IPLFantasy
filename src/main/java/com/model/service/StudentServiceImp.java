package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Dao.ContactDao;
import com.model.mappingFile.Contacts;

@Service
public class StudentServiceImp implements ContactsService {

	@Autowired
	private ContactDao contactDao;
	
	@Transactional
	public void add(Contacts conatct) {
		contactDao.add(conatct);
	}

	@Transactional
	public Contacts getContact(String id) {
		return contactDao.getContact(id);
	}

	@Transactional
	public List getAllContact() {
		return contactDao.getAllContact();
	}

}

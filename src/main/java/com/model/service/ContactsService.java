package com.model.service;

import java.util.List;

import com.model.mappingFile.Contacts;

public interface ContactsService {
	public void add(Contacts conatct);
	public Contacts getContact(String id);
	public List getAllContact();
}

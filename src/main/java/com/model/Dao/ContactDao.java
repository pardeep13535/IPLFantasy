package com.model.Dao;
import java.util.List;

import com.model.mappingFile.Contacts;

public interface ContactDao {
	public void add(Contacts conatct);
	public Contacts getContact(String id);
	public List getAllContact();
}

package com.model.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.mappingFile.Contacts;

@Repository
public  class ContactDaoImp implements ContactDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Contacts contact) {
		session.getCurrentSession().beginTransaction();
		session.getCurrentSession().save(contact);
		session.getCurrentSession().getTransaction().commit();
	}

	@Override
	public Contacts getContact(String teamName) {
		session.getCurrentSession().beginTransaction();
		List<?> contacts = session.getCurrentSession().createQuery("from Contacts where teamName = '" + teamName + "'" ).list();
		Contacts contact = (Contacts) contacts.get(0);
		session.getCurrentSession().getTransaction().commit();
		return contact;
	}

	@Override
	public List<Contacts> getAllContact() {
		session.getCurrentSession().beginTransaction();
		List<Contacts> contactList =  session.getCurrentSession().createQuery("from Contacts").list();
		session.getCurrentSession().getTransaction().commit();
		return contactList;
	}

}

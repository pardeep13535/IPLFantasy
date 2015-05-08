/**
 * 
 */
package com.model.mappingFile;


/**
 * @author Pardeep Kumar
 * @FBID www.facebook.com/pradeep13535
 */
public class ContactBean {
	private static ContactBean instance;
	private static Contacts contactList;

	public static ContactBean getInstance() {
		if (instance == null) {
			instance = new ContactBean();
		}
		return instance;
	}
	
	public Contacts getContactList() {
		return contactList;
	}

	public void setContactList(Contacts contactList) {
		ContactBean.contactList = contactList;
	}
	
}

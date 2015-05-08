package com.model.RequestClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.mappingFile.ContactBean;
import com.model.mappingFile.Contacts;

public class GetData extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonContact = "{\"players\":[";
		// Contacts con = (Contacts)
		// req.getSession().getAttribute("ContactList");
		// for (Iterator<?> iterator = contactList.iterator();
		// iterator.hasNext();) {
		// Contacts con = (Contacts) iterator.next();.

		Contacts con = ContactBean.getInstance().getContactList();

		//System.out.println(con.getPlayer1() + " " + con.getPlayer2() + " " + con.getTeamName());
		jsonContact += "{\"name\":\"" + con.getTeamName() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer1() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer2() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer3() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer4() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer5() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer6() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer7() + "\"},";
		jsonContact += "{\"name\":\"" + con.getPlayer8() + "\"}";

		// }
		// jsonContact = jsonContact.substring(0, jsonContact.length() - 1);
		jsonContact += "]}";
		resp.getOutputStream().print(jsonContact);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
package com.model.RequestClient;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.mappingFile.Contacts;
import com.model.service.ContactsService;

public class GetData1 extends HttpServlet {

	@Autowired
	private ContactsService contactService;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Contacts conatct = new Contacts();
		
		String player1 = req.getParameter("player1");
		
		conatct.setPlayer1(player1);
		contactService.add(conatct);
		
		RequestDispatcher dispatcher = 
			       getServletContext().getRequestDispatcher("/show.html");
			dispatcher.forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
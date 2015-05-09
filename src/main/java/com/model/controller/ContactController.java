package com.model.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.mappingFile.ContactBean;
import com.model.mappingFile.Contacts;
import com.model.service.ContactsService;

@Controller
public class ContactController {

	@Autowired
	private ContactsService contactService;

	@Autowired
	public SessionFactory factory;

	@RequestMapping(value = "/yourTeam.do", method = RequestMethod.GET, params = { "teamName" })
	public String getTeamBean(@RequestParam(value = "teamName") String teamName){
		System.out.println(teamName);
		Contacts  contactList = contactService.getContact(teamName);
		
		ContactBean.getInstance().setContactList(contactList);
		String redirectView = "forward:/yourTeam.html";
		return redirectView;
	}
	
	@RequestMapping(value = "/success.do", method = RequestMethod.POST)
	public String addContact(@ModelAttribute Contacts contact, Model model) {
		model.addAttribute("contact", contact);
		contactService.add(contact);
		
		String redirectView = "forward:/success.html";
		return redirectView;
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String showHomePage() {
		String redirectView = "forward:/index.html";
		return redirectView;
	}
	
	@RequestMapping(value = "/createTeam.do", method = RequestMethod.GET)
	public String createTeamPage() {
		String redirectView = "forward:/createTeam.html";
		return redirectView;
	}
	
	@RequestMapping(value = "/viewTeam.do", method = RequestMethod.GET)
	public String viewTeamPage() {
		String redirectView = "forward:/viewTeam.html";
		return redirectView;
	}
}

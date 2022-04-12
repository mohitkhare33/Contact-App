package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
@CrossOrigin
@RestController

public class ContactRestController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact)
	{
		boolean status =contactService.saveContact(contact);
		if(status)
		{
			return "contact saved";
			
		}
		else
		{
			return "failed to  save contact";
		}
		}
	
	@GetMapping("/contacts")
	public List<Contact>getAllContact()
	{
		return contactService.getAllContacts();
		
	}
	
	@GetMapping("/contact/{cid}")
	public Contact editContact(@PathVariable("cid")Integer contactId)
	{
		return contactService.getContactById(contactId);
		
	}
	
	@DeleteMapping
	public String deleteContact(Integer contactID)
	{
		boolean status =contactService.deleteContactById(contactID);
		if(status)
		{
			return "contact deleted";
		}
		else
		{
			return "failed to delete";
		}
		
		
	}
	
}

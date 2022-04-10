package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repo.ContactRepo;
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
	private ContactRepo contactRepo;
	
    @Override
	public boolean saveContact(Contact contact) {
		// TODO Auto-generated method stub
		contact.setActiveSw("Y");
		Contact save =contactRepo.save(contact);
		if(save.getContactId()!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return contactRepo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById=contactRepo.findById(contactId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		Optional<Contact>findById =contactRepo.findById(contactId);
		if(findById.isPresent())
		{
		Contact contact =findById.get();
		contact.setActiveSw("N");
		contactRepo.delete(contact);
		return true;
		
	}
		return false;
	}

}

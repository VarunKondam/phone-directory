package com.assignment.service.impl;


import com.assignment.entity.Contact;
import com.assignment.exception.NoDataFoundException;
import com.assignment.repository.ContactRepository;
import com.assignment.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactsRepository;

    public List<Contact> getAllContacts(){
        return (List<Contact>) contactsRepository.findAll();
    }

    public Contact saveContact(com.assignment.model.Contact contact) {
        Contact newContact = new Contact();
        newContact.setName(contact.getName());
        newContact.setPhoneNumber(contact.getPhoneNumber());
        newContact.setEmail(contact.getEmail());
        return contactsRepository.save(newContact);
    }

    public Optional<Contact> getContactById(Integer id) {
        return contactsRepository.findById(id);
    }

    public Optional<Contact> getContactByName(String name){
        return contactsRepository.findByName(name);
    }

    public Contact updateContact(Integer id, com.assignment.model.Contact updatedContact) throws NoDataFoundException {
        Optional<Contact> existingContact = getContactById(id);
        if(existingContact.isPresent()){
            existingContact.get().setName(updatedContact.getName());
            existingContact.get().setPhoneNumber(updatedContact.getPhoneNumber());
            existingContact.get().setEmail(updatedContact.getEmail());
            return contactsRepository.save(existingContact.get());
        } else {
            throw new NoDataFoundException("No record found for given Id");
        }

    }

    public boolean deleteContact(Integer id) {
        contactsRepository.deleteById(id);
        return true;
    }
}

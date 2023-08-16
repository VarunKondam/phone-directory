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

    public Optional<Contact> getContactById(Integer id) throws NoDataFoundException {
        Optional<Contact> contact = contactsRepository.findById(id);
        if (contact.isPresent()){
            return contact;
        } else {
            throw new NoDataFoundException("No record found for given Id");
        }
    }

    public Optional<Contact> getContactByName(String name) throws NoDataFoundException{
        Optional<Contact> contact = contactsRepository.findByName(name);;
        if (contact.isPresent()){
            return contact;
        } else {
            throw new NoDataFoundException("No record found for given Name");
        }
    }

    public Contact updateContact(Integer id, com.assignment.model.Contact updatedContact) throws NoDataFoundException {
        Optional<Contact> existingContact = getContactById(id);
            existingContact.get().setName(updatedContact.getName());
            existingContact.get().setPhoneNumber(updatedContact.getPhoneNumber());
            existingContact.get().setEmail(updatedContact.getEmail());
            return contactsRepository.save(existingContact.get());
    }

    public boolean deleteContact(Integer id) {
        contactsRepository.deleteById(id);
        return true;
    }
}

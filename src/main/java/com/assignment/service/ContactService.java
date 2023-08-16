package com.assignment.service;

import com.assignment.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService  {
    List<Contact> getAllContacts();

    Contact saveContact(com.assignment.model.Contact contact);

    Optional<Contact> getContactById(Integer id);

    Contact updateContact(Integer id, com.assignment.model.Contact contact);

    boolean deleteContact(Integer id);

    Optional<Contact> getContactByName(String name);
}

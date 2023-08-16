package com.assignment.controller;

import com.assignment.entity.Contact;
import com.assignment.service.ContactService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

    @Mock
    ContactService contactService;
    @InjectMocks
    ContactController contactController;

    @Test
    public void getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setName("test");
        contact.setPhoneNumber("1234568889");
        contact.setEmail("test1@test.com");
        contactList.add(contact);

        Mockito.when(contactService.getAllContacts()).thenReturn(contactList);
        ResponseEntity<List<Contact>> contactResponseEntity = contactController.getAllContacts();

        Assert.assertNotNull(contactResponseEntity);
        Assert.assertNotNull(contactResponseEntity.getBody());

    }

    @Test
    public void saveContact() {

        com.assignment.model.Contact contact = new com.assignment.model.Contact();
        contact.setName("test");
        contact.setPhoneNumber("1234568889");
        contact.setEmail("test1@test.com");

        Contact newContact = new Contact();
        newContact.setId(1);
        newContact.setName("test");
        newContact.setPhoneNumber("1234568889");
        newContact.setEmail("test1@test.com");

        Mockito.when(contactService.saveContact(contact)).thenReturn(newContact);
        ResponseEntity<Contact> contactResponseEntity = contactController.saveContact(contact);
        Assert.assertNotNull(contactResponseEntity);
        Assert.assertNotNull(contactResponseEntity.getBody());
    }

    @Test
    public void getContactById() {
        Contact newContact = new Contact();
        newContact.setId(1);
        newContact.setName("test");
        newContact.setPhoneNumber("1234568889");
        newContact.setEmail("test1@test.com");

        Mockito.when(contactService.getContactById(1)).thenReturn(Optional.of(newContact));
        ResponseEntity responseEntity = contactController.getContactById(1);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull(responseEntity.getBody());

    }

    @Test
    public void getContactByName() {
        Contact newContact = new Contact();
        newContact.setId(1);
        newContact.setName("test1");
        newContact.setPhoneNumber("1234568889");
        newContact.setEmail("test1@test.com");

        Mockito.when(contactService.getContactByName("test1")).thenReturn(Optional.of(newContact));
        ResponseEntity responseEntity = contactController.getContactByName("test1");
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull(responseEntity.getBody());

    }

    @Test
    public void updateContact() {
        com.assignment.model.Contact contact = new com.assignment.model.Contact();
        contact.setName("test1");
        contact.setPhoneNumber("1111111111");
        contact.setEmail("test1@test.com");

        Contact newContact = new Contact();
        newContact.setId(1);
        newContact.setName("test1");
        newContact.setPhoneNumber("1111111111");
        newContact.setEmail("test1@test.com");

        Mockito.when(contactService.updateContact(1, contact)).thenReturn(newContact);
        ResponseEntity responseEntity = contactController.updateContact(1, contact);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull(responseEntity.getBody());

    }

    @Test
    public void deleteContact() {
        Mockito.when(contactService.deleteContact(3)).thenReturn(true);
        ResponseEntity responseEntity = contactController.deleteContact(3);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull(responseEntity.getBody());

    }


}
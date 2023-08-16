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
    }

    @Test
    public void getContactById() {
    }

    @Test
    public void getContactByName() {
    }

    @Test
    public void updateContact() {
    }

    @Test
    public void deleteContact() {
    }


}
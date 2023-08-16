package com.assignment.controller;

import com.assignment.entity.Contact;
import com.assignment.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class with CRUD operations on phone directory.
 */
@RestController
@Validated
@RequestMapping("/v1/contacts")
@Slf4j
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     * HTTP GET call to retrieve all existing contacts from directory.
     *
     * @return ResponseEntity<List < Contact>>
     */
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        log.info("Request received to retrieve all existing contacts from directory");
        List<Contact> contactList = contactService.getAllContacts();
        return ResponseEntity.status(HttpStatus.OK).body(contactList);
    }

    /**
     * HTTP POST call to add a new contact to the directory.
     *
     * @param contact
     * @return ResponseEntity<Contact>
     * @Valid validates the request body.
     */
    @PostMapping
    public ResponseEntity<Contact> saveContact(@Valid @RequestBody com.assignment.model.Contact contact) {
        log.info("Request received to add a new contact to the directory");
        Contact newContact = contactService.saveContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(newContact);
    }

    /**
     * HTTP GET call to search contacts by Id.
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity getContactById(@PathVariable("id") Integer id) {
        log.info("Request received to search contacts by Id " + id + " from directory");
        Optional<Contact> contact = contactService.getContactById(id);
        if (contact.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(contact.get());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("No data found for given ID");
        }
    }

    /**
     * HTTP GET call to search contacts by Name.
     *
     * @param name
     * @return ResponseEntity
     */
    @GetMapping("/{name}")
    public ResponseEntity getContactByName(@PathVariable("name") String name) {
        log.info("Request received to search contacts by Name " + name + " from directory");
        Optional<Contact> contact = contactService.getContactByName(name);
        if (contact.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(contact.get());
        } else {
            log.info("Request processed and No data found for given Name " + name);
            return ResponseEntity.status(HttpStatus.OK).body("No data found for given Name");
        }
    }

    /**
     * HTTP PUT call to update/modify an existing contact.
     *
     * @param id
     * @param contact
     * @return ResponseEntity
     * @Valid validates the request body.
     */
    @PutMapping("/{id}")
    public ResponseEntity updateContact(@PathVariable("id") Integer id, @Valid @RequestBody com.assignment.model.Contact contact) {
        log.info("Request received to modify existing contact by Id " + id + " from directory");
        Contact updatedContact = contactService.updateContact(id, contact);
        if (updatedContact != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedContact);
        } else {
            log.info("Request processed and No data found for given Id " + id);
            return ResponseEntity.status(HttpStatus.OK).body("No data found for given Id");
        }
    }

    /**
     * HTTP DELETE call to delete an existing contact
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteContact(@PathVariable("id") Integer id) {
        log.info("Request received to delete existing contact by Id " + id + " from directory");
        boolean deleted = contactService.deleteContact(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Record successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("No data found for given Id.");
        }
    }


}

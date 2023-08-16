package com.assignment.controller;

import com.assignment.entity.Contact;
import com.assignment.model.ErrorResponse;
import com.assignment.service.ContactService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/v1/contacts")
@Slf4j
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        log.info("Request received to getAllContacts()");
        List<Contact> contactList = contactService.getAllContacts();
        return ResponseEntity.status(HttpStatus.OK).body(contactList);
    }

    @PostMapping()
    public ResponseEntity<Contact> saveContact(@Valid @RequestBody com.assignment.model.Contact contact) {
        Contact newContact = contactService.saveContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(newContact);
    }

    @GetMapping("/{id}")
    public ResponseEntity getContactById(@PathVariable("id") Integer id) {
        Optional<Contact> contact = contactService.getContactById(id);
        if (contact.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(contact.get());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("No data found for given ID");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity getContactByName(@PathVariable("name") String name) {
        Optional<Contact> contact = contactService.getContactByName(name);
        if (contact.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(contact.get());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("No data found for given Name");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateContact(@PathVariable("id") Integer id, @Valid @RequestBody com.assignment.model.Contact contact) {
        Contact updatedContact = contactService.updateContact(id, contact);
        if (updatedContact != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedContact);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("No data found for given Name");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") Integer id) {
        boolean deleted = contactService.deleteContact(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    public ErrorResponse createErrorResponse(String message){
//
//    }

}

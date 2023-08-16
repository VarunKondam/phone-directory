package com.assignment.repository;

import com.assignment.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Optional<Contact> findById(Integer Id);
    Optional<Contact> findByName(String name);
}

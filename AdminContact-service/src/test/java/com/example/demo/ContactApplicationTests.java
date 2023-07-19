package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContactApplicationTests {

    @Autowired
    private ContactService contactService;

    @MockBean
    private ContactRepository contactRepository;

    @Test
    public void testGetContact() {
        when(contactRepository.findAll()).thenReturn(Stream.of(new Contact("12", "Tapan", "415178261678"),
                new Contact("69", "Riya", "123656760")).collect(Collectors.toList()));
        assertEquals(2, contactService.getContact().size());
    }

    @Test
    public void testSaveContact() {
        Contact contact = new Contact("999", "Pranya", "431516626262");
        when(contactRepository.save(contact)).thenReturn(contact);
        assertEquals(contact, contactService.addContact(contact));
    }
}

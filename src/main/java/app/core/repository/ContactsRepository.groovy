package app.core.repository;

import app.core.models.Contact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactsRepository {

    List<Contact> contacts = [
            new Contact('1234', 'Matthew Shaw', 'shaw500@gmail.com', 'mjshaw'),
    new Contact('5678', 'Taffany Leung', 'taffanyl@gmail.com', 'taffanyl')
    ]

    def List<Contact> all() {
        contacts
    }

    def Contact getById(String id) {
        contacts.find { contact -> contact.id ==  id }
    }

    def Contact save(Contact contact) {
        contacts.add(contact)
        contact
    }
}

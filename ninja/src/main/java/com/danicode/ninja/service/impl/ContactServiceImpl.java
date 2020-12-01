package com.danicode.ninja.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.danicode.ninja.component.ContactConverter;
import com.danicode.ninja.entity.Contact;
import com.danicode.ninja.model.ContactModel;
import com.danicode.ninja.repository.ContactRepository;
import com.danicode.ninja.service.ContactService;

@Service("ContactServiceImpl")
public class ContactServiceImpl implements ContactService {

	// Inyectando el repositorio
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	// Inyectando el convertidor (Entity <==> Model)
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		// Devuelve y recibe un Entity. Usar Converter (model => entity)
		Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		return contactConverter.convertContactToContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new LinkedList<>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContactToContactModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContactToContactModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = contactRepository.findById(id);
		if (contact != null) {
			contactRepository.delete(contact);
		}

	}

}

package com.danicode.ninja.service;

import java.util.List;

import com.danicode.ninja.entity.Contact;
import com.danicode.ninja.model.ContactModel;

public interface ContactService {

	// Agregar contacto que devuelve model ContactModel
	public abstract ContactModel addContact(ContactModel contactModel);

	// Listar
	public abstract List<ContactModel> listAllContacts();

	// Get Entity
	public abstract Contact findContactById(int id);
	
	// Get ContactModel
	public ContactModel findContactByIdModel(int id);

	// Eliminar
	public abstract void removeContact(int id);
}

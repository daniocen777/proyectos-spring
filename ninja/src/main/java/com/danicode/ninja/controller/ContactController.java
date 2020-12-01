package com.danicode.ninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.danicode.ninja.constant.ViewConstant;
import com.danicode.ninja.model.ContactModel;
import com.danicode.ninja.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	// Inyectar el servicio
	@Autowired
	@Qualifier("ContactServiceImpl")
	private ContactService contactService;

	// Para el botón cancelar (regresar a la lista de contactos)
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}

	// Ir a formulario de contacto
	@GetMapping("/contactform")
	private String redirectContactForm(@RequestParam(name = "id", required = false) int id, Model model) {
		ContactModel contact = new ContactModel();
		if (id != 0) { // Si viene con un ID, lo busca
			contact = contactService.findContactByIdModel(id);
		}

		// Si el ID = 0 (desde la vista contacts al dar clic en Nuevo Contacto) => new Contact()
		model.addAttribute("contactModel", contact);
		return ViewConstant.CONTACT_FORM;
	}

	// Nuevo contacto
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) {
		LOG.info("METHOD: addContact() -- PARAMS: err = " + contactModel.toString());
		if (contactService.addContact(contactModel) != null) {
			LOG.info("METHOD: addContact() -- OK");
			model.addAttribute("result", 1); // Para mensaje de OK
		} else {
			LOG.info("METHOD: addContact() -- ERROR");
			model.addAttribute("result", 0); // Para mensaje de ERROR
		}

		return "redirect:/contacts/showcontacts";
	}

	// Listar contactos
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}

	// Get
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return showContacts();

	}

}

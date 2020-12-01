package com.danicode.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danicode.model.Vacante;
import com.danicode.service.IVacantesService;

@Controller
public class HomeController {

	// Inyectando servicio
	@Autowired
	private IVacantesService vacantesService;

	// Para una tabla
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = vacantesService.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}

	// Listado de vacantes
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(7300);
		model.addAttribute("vacante", vacante);

		return "detalle";
	}

	// Lista
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		model.addAttribute("empleos", lista);

		return "listado";
	}

	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> lista = vacantesService.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "home";
	}

}
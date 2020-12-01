package com.danicode.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.danicode.model.Vacante;

@Service
public class VacantesServiceImp implements IVacantesService {

	private List<Vacante> lista = null;

	// Constructor
	public VacantesServiceImp() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
			// 1° vacante
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civel");
			vacante1.setDescripcion("Solicitamos Ingeniero Civel para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(4099.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");

			// 2° vacante
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador público");
			vacante2.setDescripcion("Empresa importante requiere de contador con 5 años de experiencia y titulado");
			vacante2.setFecha(sdf.parse("11-02-2019"));
			vacante2.setSalario(8099.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");

			// 3° vacante
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("xxxx xxxx");
			vacante3.setDescripcion("xxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxx");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(1091.0);
			vacante3.setDestacado(1);

			// 4° vacante
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("xxxx xxxx");
			vacante4.setDescripcion("xxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxx");
			vacante4.setFecha(sdf.parse("01-12-2019"));
			vacante4.setSalario(1091.0);
			vacante4.setDestacado(0);
			vacante4.setImagen("empresa3.png");

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);

		} catch (ParseException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer id) {
		for (Vacante vacante : lista) {
			if (vacante.getId() == id) {
				return vacante;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);

	}

}

package com.danicode.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danicode.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.danicode.microservicios.commons.alumnos.models.entity.Alumno;
import com.danicode.microservicios.commons.services.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String texto) {

		return repository.findByNombreOrApellido(texto);
	}

}

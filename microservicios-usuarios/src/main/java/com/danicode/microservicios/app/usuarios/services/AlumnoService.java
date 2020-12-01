package com.danicode.microservicios.app.usuarios.services;

import java.util.List;

import com.danicode.microservicios.commons.alumnos.models.entity.Alumno;
import com.danicode.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno> {

	public List<Alumno> findByNombreOrApellido(String texto);
}

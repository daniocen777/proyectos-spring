package com.danicode.microservicios.app.cursos.services;

import com.danicode.microservicios.app.cursos.models.entity.Curso;
import com.danicode.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	public Curso findCursoByAlumnoId(Long id);
}
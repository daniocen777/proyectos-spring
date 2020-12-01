package com.danicode.service;

import java.util.List;

import com.danicode.model.Vacante;

public interface IVacantesService {

	List<Vacante> buscarTodas();

	Vacante buscarPorId(Integer id);

	void guardar(Vacante vacante);

}

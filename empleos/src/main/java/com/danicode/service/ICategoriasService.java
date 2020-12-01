package com.danicode.service;

import java.util.List;

import com.danicode.model.Categoria;

public interface ICategoriasService {

	void guardar(Categoria categoria);

	List<Categoria> buscarTodas();

	Categoria buscarPorId(Integer idCategoria);

}

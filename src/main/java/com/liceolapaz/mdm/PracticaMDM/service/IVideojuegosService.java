package com.liceolapaz.mdm.PracticaMDM.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;

public interface IVideojuegosService{

	Videojuego guardar(Videojuego videojuego);
	List<Videojuego> buscarTodas();
	Videojuego findById(int id);
	List<Videojuego> findByName(String name);
	void deleteById(Integer id);
}
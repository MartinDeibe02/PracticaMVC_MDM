package com.liceolapaz.mdm.PracticaMDM.service;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.stereotype.Service;

import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;

public interface IVideojuegosService{

	Videojuego guardar(Videojuego videojuego);
	List<Videojuego> buscarTodas();
	Videojuego findById(int id);
	Videojuego findByName(String name);
	void deleteById(Integer id);
	void deleteAllById(List<Integer> array);	
	
	
}

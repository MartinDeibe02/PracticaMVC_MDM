package com.liceolapaz.mdm.PracticaMDM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;

public interface VideojuegosRepository extends JpaRepository<Videojuego, Integer> {
	Videojuego findByNombre(String name);
}

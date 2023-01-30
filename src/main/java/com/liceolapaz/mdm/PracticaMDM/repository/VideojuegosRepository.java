package com.liceolapaz.mdm.PracticaMDM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;

public interface VideojuegosRepository extends JpaRepository<Videojuego, Integer> {
	List<Videojuego> findByNombre(String name);
}
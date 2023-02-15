package com.liceolapaz.mdm.PracticaMDM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.VideoJuegoSucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;
import com.liceolapaz.mdm.PracticaMDM.model.VideojuegosSucursalId;

public interface VideojuegosSucursalRepository extends JpaRepository<VideoJuegoSucursal, Integer>{
	VideoJuegoSucursal findBySucursalAndVideojuego(Sucursal sucursal, Videojuego videojuego);
}

package com.liceolapaz.mdm.PracticaMDM.service;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.VideoJuegoSucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;

public interface IVideojuegoSucursalService {
	void guardar(VideoJuegoSucursal videojuegoSucursal);
	boolean prueba(VideoJuegoSucursal videojuegoSucursal);
	VideoJuegoSucursal find(int v, int s, int cant);
	Integer getSum();
}

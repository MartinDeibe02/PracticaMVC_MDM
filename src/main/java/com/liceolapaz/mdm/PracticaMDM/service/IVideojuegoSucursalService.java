package com.liceolapaz.mdm.PracticaMDM.service;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.VideoJuegoSucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;

public interface IVideojuegoSucursalService {
	void guardar(VideoJuegoSucursal videojuegoSucursal);
	VideoJuegoSucursal find(Sucursal idSucursal, Videojuego idVideojuego);

}

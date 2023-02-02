package com.liceolapaz.mdm.PracticaMDM.service;

import java.util.List;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;

public interface ISucursalService {
	List<Sucursal> buscarTodas();
	void guardar(Sucursal sucursal);
	Sucursal findById(Integer id);
	Sucursal findByName(int name);
}

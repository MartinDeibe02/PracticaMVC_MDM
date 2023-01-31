package com.liceolapaz.mdm.PracticaMDM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
	Sucursal findByNumSucursal(int sucursal);
}

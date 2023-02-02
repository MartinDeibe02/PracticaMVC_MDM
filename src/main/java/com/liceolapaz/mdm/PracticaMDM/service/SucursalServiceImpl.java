package com.liceolapaz.mdm.PracticaMDM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements ISucursalService {

	@Autowired
	SucursalRepository sucursalRepo;
	
	@Override
	public List<Sucursal> buscarTodas() {
		return sucursalRepo.findAll();
	}

	@Override
	public void guardar(Sucursal sucursal) {
		sucursalRepo.save(sucursal);
	}

	@Override
	public Sucursal findById(Integer id) {
		Optional<Sucursal> sucursaltemp = sucursalRepo.findById(id);
		
		Sucursal sucursal = sucursaltemp.get();
		return sucursal;
	}

	@Override
	public Sucursal findByName(int name) {
		return sucursalRepo.findByNumSucursal(name);
	}

}

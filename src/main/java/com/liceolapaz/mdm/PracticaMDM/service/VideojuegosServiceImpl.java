package com.liceolapaz.mdm.PracticaMDM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.VideoJuegoSucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;
import com.liceolapaz.mdm.PracticaMDM.repository.SucursalRepository;
import com.liceolapaz.mdm.PracticaMDM.repository.VideojuegosRepository;
import com.liceolapaz.mdm.PracticaMDM.repository.VideojuegosSucursalRepository;

@Service
public class VideojuegosServiceImpl implements IVideojuegosService {

	@Autowired
	VideojuegosRepository videojuegosRepo;
	
	@Autowired
	SucursalRepository sucRepo;
	
	@Autowired 
	VideojuegosSucursalRepository vidSucRep;
	
	
	@Override
	public Videojuego guardar(Videojuego videojuego) {
		 return videojuegosRepo.save(videojuego);		 
	}

	@Override
	public List<Videojuego> buscarTodas() {
		return videojuegosRepo.findAll();
	}

	@Override
	public Videojuego findById(int id) {
		Optional<Videojuego> vid = videojuegosRepo.findById(id);
		if(vid.isPresent()) {
			return vid.get();
		}
		return null;
	}

	@Override
	public Videojuego findByName(String name) {
		return videojuegosRepo.findByNombre(name);
	}

	@Override
	public void deleteById(Integer id) {
		videojuegosRepo.deleteById(id);
	}

	@Override
	public void deleteAllById(List<Integer> array) {
		for(int i = 0; i<array.size();i++) {
			videojuegosRepo.deleteById(array.get(i));
		}
		
	}







}

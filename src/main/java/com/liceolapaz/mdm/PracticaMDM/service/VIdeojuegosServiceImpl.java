package com.liceolapaz.mdm.PracticaMDM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;
import com.liceolapaz.mdm.PracticaMDM.repository.VideojuegosRepository;

@Service
public class VIdeojuegosServiceImpl implements IVideojuegosService {

	@Autowired
	VideojuegosRepository videojuegosRepo;
	
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
	public void saveVidSuc(Videojuego videojuego) {
		
	}



}

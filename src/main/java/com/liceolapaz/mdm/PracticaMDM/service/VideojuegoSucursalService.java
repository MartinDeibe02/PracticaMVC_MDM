package com.liceolapaz.mdm.PracticaMDM.service;

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
public class VideojuegoSucursalService implements IVideojuegoSucursalService {

	@Autowired
	VideojuegosSucursalRepository vidSurRep;
	
	@Autowired 
	VideojuegosRepository videojuegosRepo;
	
	@Autowired
	SucursalRepository sucursalRepo;
	
	@Override
	public void guardar(VideoJuegoSucursal videojuegoSucursal) {
		vidSurRep.save(videojuegoSucursal);
		
		
	}

	@Override
	public VideoJuegoSucursal find(Sucursal sucursal1, Videojuego videojuego1) {
		
		
		Optional<Sucursal> sucursal = sucursalRepo.findById(sucursal1.getId());
		Optional<Videojuego> videojuego = videojuegosRepo.findById(videojuego1.getId());
		if(sucursal.isPresent() && videojuego.isPresent()) {
			
			Optional<VideoJuegoSucursal> vidSuc = Optional.of(vidSurRep.findBySucursalAndVideojuego(sucursal.get(), videojuego.get()));
			VideoJuegoSucursal v = null;
			if(vidSuc.isPresent()) {
				v = vidSuc.get();
				System.out.println(vidSuc.get());
				int cant = v.getCantidad();
				v.setCantidad(cant+1);
			}		
			
			return v;
		}else {
			VideoJuegoSucursal videoJuegoSuc = new VideoJuegoSucursal();
			videoJuegoSuc.setVideojuego(videojuego1);
			videoJuegoSuc.setSucursal(sucursal1);
			vidSurRep.save(videoJuegoSuc);
		}
		return null;


	}
	
	

}

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
	public void find(Videojuego videojuego) {
			
		if(videojuegosRepo.findByNombre(videojuego.getNombre())!=null) {
			VideoJuegoSucursal videoJuegoSuc = new VideoJuegoSucursal();
			videoJuegoSuc.setVideojuego(videojuego);
			//videoJuegoSuc.setSucursal(sucursal);
			videoJuegoSuc.setCantidad(1);
			vidSurRep.save(videoJuegoSuc);
		}else {
		/*	Optional<VideoJuegoSucursal> vidSuc = Optional.of(vidSurRep.findBySucursalAndVideojuego(sucursal, videojuego));
			VideoJuegoSucursal v = null;
			if(vidSuc.isPresent()) {
				v = vidSuc.get();
				int cant = v.getCantidad();
				v.setCantidad(cant+1);*/
		}
		
			
			
	
	}
	}

	@Override
	public void find(Sucursal idSucursal, Videojuego idVideojuego) {
		// TODO Auto-generated method stub
		
	}
}

package com.liceolapaz.mdm.PracticaMDM.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
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
		System.out.println(videojuegoSucursal);
		vidSurRep.save(videojuegoSucursal);

	}

	@Override
	public boolean prueba(VideoJuegoSucursal videojuegoSucursal) {
		Videojuego vid = videojuegoSucursal.getVideojuego();
		Sucursal suc = videojuegoSucursal.getSucursal();
		
		
		Optional<Videojuego> v = Optional.ofNullable(videojuegosRepo.findByNombre(vid.getNombre()));
		Optional<Sucursal> s = Optional.of(sucursalRepo.findByNumSucursal(suc.getNumSucursal()));
		
		if(!(v.isPresent())) {
			videojuegoSucursal.setCantidad(1);
			vid.getSucursalAssoc().clear();
			vid.addsucursal(videojuegoSucursal);
			System.out.println(vid);
			videojuegosRepo.save(vid);
			
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public VideoJuegoSucursal find(int v, int s, int cant) {
		Optional<Videojuego> vidTemp = videojuegosRepo.findById(v);
		Optional<Sucursal> sucTemp = sucursalRepo.findById(s);
		
		if(vidTemp.isPresent() && sucTemp.isPresent()) {
			Videojuego vid = vidTemp.get();
			Sucursal suc = sucTemp.get();
			return vidSurRep.findBySucursalAndVideojuego(suc, vid);

		}else {
			Videojuego vid = vidTemp.get();
			Sucursal suc = sucTemp.get();
			VideoJuegoSucursal vxt = new VideoJuegoSucursal();
			vxt.setVideojuego(vid);
			vxt.setSucursal(suc);
			
			return vidSurRep.save(vxt);
		}

	}

	@Override
	public Integer getSum() {
		List<VideoJuegoSucursal> vids = vidSurRep.findAll();
		int i = 0;
		for(VideoJuegoSucursal v : vids) {
			i += v.getCantidad();
		}
		
		return i;
	}



	

}

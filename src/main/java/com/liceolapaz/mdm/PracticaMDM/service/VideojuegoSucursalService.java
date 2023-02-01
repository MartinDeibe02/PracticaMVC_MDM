package com.liceolapaz.mdm.PracticaMDM.service;

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
		Videojuego vid = videojuegoSucursal.getVideojuego();
		Sucursal suc = videojuegoSucursal.getSucursal();
		
		System.out.println(vid + " " + suc);
		
		Optional<Videojuego> v = Optional.ofNullable(videojuegosRepo.findByNombre(vid.getNombre()));
		Optional<Sucursal> s = Optional.of(sucursalRepo.findByNumSucursal(suc.getNumSucursal()));
		
		if(v.isPresent() && s.isPresent()) {
			System.out.println("EXISTE");
			
			Videojuego juego = v.get();
			Sucursal sucursal = s.get();
			
			Optional<VideoJuegoSucursal> vs = Optional.ofNullable(vidSurRep.findBySucursalAndVideojuego(sucursal, juego));
			if(vs.isPresent()) {
				VideoJuegoSucursal vxt = vs.get();
				System.out.println("CANTIDAD ANTES " +vxt.getCantidad());
				vxt.setCantidad(vxt.getCantidad()+1);
				System.out.println("CANTIDAD DESPUES " + vxt.getCantidad());
				guardar(vxt);
				
			}else{
				System.out.println("AAAAAAAAA");
				videojuegoSucursal.setVideojuego(juego);
				videojuegoSucursal.setSucursal(sucursal);
				videojuegoSucursal.setCantidad(1);
				vidSurRep.save(videojuegoSucursal);
			}
			
		}else {
			videojuegoSucursal.setCantidad(1);
			vid.getSucursalAssoc().clear();
			vid.addsucursal(videojuegoSucursal);
			System.out.println(vid);
			videojuegosRepo.save(vid);
		}

	}

	@Override
	public void prueba(Sucursal idSucursal, Videojuego idVideojuego) {
		// TODO Auto-generated method stub
		
	}



	

}

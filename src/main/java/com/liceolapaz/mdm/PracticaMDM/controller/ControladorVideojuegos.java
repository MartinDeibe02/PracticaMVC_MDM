package com.liceolapaz.mdm.PracticaMDM.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.VideoJuegoSucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;
import com.liceolapaz.mdm.PracticaMDM.service.ISucursalService;
import com.liceolapaz.mdm.PracticaMDM.service.IVideojuegoSucursalService;
import com.liceolapaz.mdm.PracticaMDM.service.IVideojuegosService;

@Controller
public class ControladorVideojuegos {
	@Autowired
	IVideojuegosService videojuegosService;
	
	@Autowired
	ISucursalService sucursalService;
	
	@Autowired
	IVideojuegoSucursalService vids;
	
	
	@GetMapping("/insertGame")
	public String insertGame(Videojuego videojuego) {
		
		Videojuego juego = new Videojuego();
		juego.setNombre("Prueba5");
		juego.setGenero("Prueba");
		juego.setPrecio(144);
		juego.setPegi(13);
		
		Sucursal sucursal = new Sucursal();
		
		sucursal.setDireccion("Prueba");
		sucursal.setNumSucursal(121299837);
		sucursal.setCiudad("Se me va a ir la cabeza");
		System.out.println(sucursal);
		System.out.println("CIUDAD: " + sucursal.getCiudad());
		
		
		VideoJuegoSucursal a = new VideoJuegoSucursal();
		a.setVideojuego(juego);
		a.setSucursal(sucursal);
		a.setCantidad(1);
		
		juego.addsucursal(a);
		
		videojuegosService.guardar(juego);
		
		System.out.println(videojuegosService.buscarTodas());
		
		return "videojuegos/formVideojuegos";
	}
	
	@PostMapping("/saveVideojuego")
	public String guardar(Videojuego videojuego) {
		videojuegosService.guardar(videojuego);
				
		
		return "redirect:videojuegos/formVideojuegos";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		List<Sucursal> lista = sucursalService.buscarTodas();
		model.addAttribute("lista", lista);
	}
	
	
	

}

package com.liceolapaz.mdm.PracticaMDM.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	IVideojuegoSucursalService vidsuc;
	
	
	@GetMapping("/insertGame")
	public String insertGame(Videojuego videojuego) {
		
		return "videojuegos/formVideojuegos";
	}
	
	@PostMapping("/saveVideojuego")
	public String guardar(Videojuego videojuego, @RequestParam("sucursal") int id) {
		//videojuegosService.guardar(videojuego);
		System.out.println(videojuego);
		
		Sucursal sucursal = sucursalService.findById(id);
		
		System.out.println(sucursal);
		VideoJuegoSucursal vidSuc = new VideoJuegoSucursal();
		vidSuc.setVideojuego(videojuego);
		vidSuc.setSucursal(sucursal);
		vidSuc.setCantidad(1);
		
		videojuego.addsucursal(vidSuc);
		
		videojuegosService.guardar(videojuego);
		return "redirect:/insertGame";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		List<Sucursal> lista = sucursalService.buscarTodas();
		model.addAttribute("lista", lista);
	}
	
	
	

}

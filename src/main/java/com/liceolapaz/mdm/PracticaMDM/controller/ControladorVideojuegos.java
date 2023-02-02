package com.liceolapaz.mdm.PracticaMDM.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/")
	public String gamesList(Videojuego videojuego) {
		
		return "videojuegos/listVideojuegos";
	}
	
	@PostMapping("/saveVideojuego")
	public String guardar(Videojuego videojuego, @RequestParam("sucursal") int id) {
		Sucursal sucursal = sucursalService.findById(id);
		VideoJuegoSucursal vidSuc = new VideoJuegoSucursal();
		vidSuc.setVideojuego(videojuego);
		vidSuc.setSucursal(sucursal);		
		videojuego.addsucursal(vidSuc);
		
		//vidsuc.guardar(vidSuc);
		
		if(vidsuc.prueba(vidSuc)) {
			return "redirect:/insertGame";

		}else {
			return "videojuegos/error";
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Integer id){
		videojuegosService.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model){
		Videojuego v = videojuegosService.findById(id);
		List<VideoJuegoSucursal> vxs = v.getSucursalAssoc();
		
		
		model.addAttribute("vxt",vxs);
		model.addAttribute(v);
		return "videojuegos/edit";
	}
	
	@PostMapping("/editGame")
	public String saveEdit(Videojuego videojuego){
		videojuegosService.guardar(videojuego);
		return "redirect:/";
	}	
	
	
	@GetMapping("/mostrar/{nombre}")
	public String deleteById(@PathVariable("nombre") String nombre, Model model){
		Videojuego v = videojuegosService.findByName(nombre);
		model.addAttribute("videojuego", v);
		List<VideoJuegoSucursal> vxs = v.getSucursalAssoc();
		
		List<Sucursal> s = new  ArrayList<>();
		for(int i = 0; i<vxs.size();i++) {
			s.add(vxs.get(i).getSucursal());
		}
		System.out.println(v.getSucursalAssoc());
		model.addAttribute("lista2", s);
		
		return "videojuegos/detalle";
	}
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		List<Sucursal> lista = sucursalService.buscarTodas();
		List<Videojuego> games_list = videojuegosService.buscarTodas();
		model.addAttribute("lista", lista);
		model.addAttribute("games", games_list);
	}
	
	
	

}

package com.liceolapaz.mdm.PracticaMDM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.VideoJuegoSucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;
import com.liceolapaz.mdm.PracticaMDM.service.ISucursalService;
import com.liceolapaz.mdm.PracticaMDM.service.IVideojuegosService;
import com.liceolapaz.mdm.PracticaMDM.service.SucursalServiceImpl;
import com.liceolapaz.mdm.PracticaMDM.service.VideojuegoSucursalService;
import com.liceolapaz.mdm.PracticaMDM.service.VideojuegosServiceImpl;


@Controller
public class ControladorSucursal {
	@Autowired
	IVideojuegosService videojuegoService;
	
	@Autowired
	ISucursalService sucursalService;
	
	@Autowired
	VideojuegoSucursalService vidsuc;

	
	@GetMapping("/editSucursal/{idSuc}/{idVid}")
	public String editSucursal(VideoJuegoSucursal videojuegoSucursal, @PathVariable("idSuc") int idSuc, @PathVariable("idVid") int idVid, Model model){
		VideoJuegoSucursal vxt = vidsuc.find(idVid, idSuc);
		model.addAttribute("vxt", vxt);
		
		return "sucursal/formSucursal";
	}

	
	@PostMapping("/saveSucursal")
	public String guardar(VideoJuegoSucursal vidSuc) {
		System.out.println(vidSuc);
		
		VideoJuegoSucursal newVid = vidsuc.find(vidSuc.getVideojuego().getId(), vidSuc.getSucursal().getId());
		
		newVid.setCantidad(vidSuc.getCantidad());
		
		vidsuc.guardar(newVid);
		
		return "redirect:/";
	}

}

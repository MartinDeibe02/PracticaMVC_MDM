package com.liceolapaz.mdm.PracticaMDM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;
import com.liceolapaz.mdm.PracticaMDM.service.ISucursalService;
import com.liceolapaz.mdm.PracticaMDM.service.IVideojuegosService;
import com.liceolapaz.mdm.PracticaMDM.service.SucursalServiceImpl;
import com.liceolapaz.mdm.PracticaMDM.service.VideojuegosServiceImpl;


@Controller
public class ControladorSucursal {
	@Autowired
	IVideojuegosService videojuegoService;
	
	@Autowired
	ISucursalService sucursalService;

	
	@GetMapping("/insertSucursal")
	public String insertSucursal(Sucursal sucursal) {
		return "sucursal/formSucursal";
	}
	

	
	@PostMapping("/saveSucursal")
	public String guardar(Sucursal sucursal) {
		sucursalService.guardar(sucursal);
		return "redirect:/insertSucursal";
	}

}

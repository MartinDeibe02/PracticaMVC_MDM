package com.liceolapaz.mdm.PracticaMDM.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liceolapaz.mdm.PracticaMDM.model.Sucursal;
import com.liceolapaz.mdm.PracticaMDM.model.VideoJuegoSucursal;
import com.liceolapaz.mdm.PracticaMDM.model.Videojuego;
import com.liceolapaz.mdm.PracticaMDM.service.IVideojuegoSucursalService;
import com.liceolapaz.mdm.PracticaMDM.service.IVideojuegosService;
import com.liceolapaz.mdm.PracticaMDM.service.VideojuegoSucursalService;


@RestController
@RequestMapping("/api")
public class VideojuegosApi {

	@Autowired
	IVideojuegosService videojuegosService;
	
	@Autowired
	IVideojuegoSucursalService prueba;
	
	@GetMapping("/")
	public List<Videojuego> buscarTodos(){
		System.out.println(videojuegosService.buscarTodas());
		return videojuegosService.buscarTodas();
	}
	
	@GetMapping("/{id}")
	public Videojuego buscarTodoId(@PathVariable("id") int id){
		return videojuegosService.findById(id);
	}
	
	@GetMapping("/name/{nombre}")
	public Videojuego buscarNombre(@PathVariable("nombre") String nombre){
		return videojuegosService.findByName(nombre);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Videojuego> guardar(@RequestBody Videojuego videojuego){
		return new ResponseEntity<>(videojuegosService.guardar(videojuego), HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public Videojuego modify(@RequestBody Videojuego juego){
		return videojuegosService.guardar(juego);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Integer id){
		videojuegosService.deleteById(id);
		return "Eliminado";
	}

	@GetMapping("/deleteList/{array}")
	public String test(@PathVariable List<Integer> array)
	{
		System.out.println(array);
		videojuegosService.deleteAllById(array);
		return "Eliminadas " + array; 
	}

}

package com.liceolapaz.mdm.PracticaMDM.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "videojuego")
public class Videojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String genero;
	private double precio;
	private int pegi;	
	
	@OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL)
    private List<VideoJuegoSucursal> sucursalAssoc = new ArrayList<VideoJuegoSucursal>();

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPegi() {
		return pegi;
	}
	public void setPegi(int pegi) {
		this.pegi = pegi;
	}
	
	public void addsucursal(VideoJuegoSucursal vidSuc) {
		this.sucursalAssoc.add(vidSuc);
	}
	
	
	

	@JsonIgnore
	public List<VideoJuegoSucursal> getSucursalAssoc() {
		return sucursalAssoc;
	}
	
	public void setSucursalAssoc(List<VideoJuegoSucursal> sucursalAssoc) {
		this.sucursalAssoc = sucursalAssoc;
	}
	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", precio=" + precio + ", pegi="
				+ pegi + "]";
	}
	
	

	
	
	
	
	
	
	
}

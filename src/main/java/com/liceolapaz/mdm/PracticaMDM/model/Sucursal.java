package com.liceolapaz.mdm.PracticaMDM.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int numSucursal;
	private String ciudad;
	private String direccion;
	
	@OneToMany(mappedBy = "sucursal")
    private List<VideoJuegoSucursal> videojuegoAssoc = new ArrayList<VideoJuegoSucursal>();
	
	
	
	
	public List<VideoJuegoSucursal> getVideojuegoAssoc() {
		return videojuegoAssoc;
	}
	public void setVideojuegoAssoc(List<VideoJuegoSucursal> videojuegoAssoc) {
		this.videojuegoAssoc = videojuegoAssoc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNumSucursal() {
		return numSucursal;
	}
	public void setNumSucursal(int numSucursal) {
		this.numSucursal = numSucursal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Sucursal [id=" + id + ", numSucursal=" + numSucursal + ", ciudad=" + ciudad + ", direccion=" + direccion
				+ "]";
	}
	
	
	
	


	
	
	
	
}

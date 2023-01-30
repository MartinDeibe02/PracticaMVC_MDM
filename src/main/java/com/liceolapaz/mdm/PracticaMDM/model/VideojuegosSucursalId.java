package com.liceolapaz.mdm.PracticaMDM.model;

import java.io.Serializable;
import java.util.Objects;

public class VideojuegosSucursalId implements Serializable{
	private Integer videojuego;
	private Integer sucursal;
	public Integer getVideojuegos() {
		return videojuego;
	}
	public void setVideojuegos(Integer videojuego) {
		this.videojuego = videojuego;
	}
	public Integer getSucursal() {
		return sucursal;
	}
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(sucursal, videojuego);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideojuegosSucursalId other = (VideojuegosSucursalId) obj;
		return Objects.equals(sucursal, other.sucursal) && Objects.equals(videojuego, other.videojuego);
	}
	
	
	
	
	
	

}

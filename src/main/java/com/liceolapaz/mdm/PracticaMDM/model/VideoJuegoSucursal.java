package com.liceolapaz.mdm.PracticaMDM.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "videojuegosSucursal")
@IdClass(VideojuegosSucursalId.class)
public class VideoJuegoSucursal{
	@Id
	@ManyToOne
    @JoinColumn(name = "idVideojuego", referencedColumnName = "id")
	private Videojuego videojuego;
	@Id
	@ManyToOne
    @JoinColumn(name = "idSucursal", referencedColumnName = "id")
	private Sucursal sucursal;
    @Column(name = "cantidad")
	private int cantidad;
	public Videojuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "VideoJuegoSucursal [videojuego=" + videojuego + ", sucursal=" + sucursal + ", cantidad=" + cantidad
				+ "]";
	}
    
    
	
	
}

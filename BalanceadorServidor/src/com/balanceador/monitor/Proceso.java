package com.balanceador.monitor;

public class Proceso {

	private int id;
	private String descripcion;
	private int prioridad;
	private String usoCpu;
	private String usoMemoria;
	private int tiempoEstimado;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public int getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	public String getUsoCpu() {
		return usoCpu;
	}
	public void setUsoCpu(String usoCpu) {
		this.usoCpu = usoCpu;
	}
	public String getUsoMemoria() {
		return usoMemoria;
	}
	public void setUsoMemoria(String usoMemoria) {
		this.usoMemoria = usoMemoria;
	}
	
	
}

package ar.edu.usal.programacion.tp1;

import java.util.Calendar;

public class ViajesLarga extends Viajes {

	private double distancia;
	private Calendar fechaLlegada;
	private String[] localidades;
	
	public ViajesLarga() {};

	public ViajesLarga(double distancia, Calendar fechaLlegada, String[] localidades) {
		
		this.distancia = distancia;
		this.fechaLlegada = fechaLlegada;
		this.localidades = localidades;
		
	}

	public double getDistancia() {
		
		return distancia;
		
	};

	public Calendar getFechaLlegada() {
		
		return fechaLlegada;
		
	};

	public String[] getLocalidades() {
		
		return localidades;
		
	};

	public void setDistancia(double distancia) {
		
		this.distancia = distancia;
		
	};

	public void setFechaLlegada(Calendar fechaLlegada) {
		
		this.fechaLlegada = fechaLlegada;
		
	};

	public void setLocalidades(String[] localidades) {
		
		this.localidades = localidades;
		
	};
	
}

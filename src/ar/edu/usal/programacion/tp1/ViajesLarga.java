package ar.edu.usal.programacion.tp1;

import java.util.ArrayList;
import java.util.Calendar;

public class ViajesLarga extends Viajes {

	private double distancia;
	private Calendar fechaLlegada = null;
	private ArrayList<String> localidades;
	
	public ViajesLarga() {};

	public ViajesLarga(int nroViaje, Calendar fechaPartida, double peso,
			Peones[] peones, boolean requiereCustodiaSatelital, double costo,
			Camiones vehiculo, ArrayList<Peajes> peajes, double distancia, ArrayList localidades) {
		
		super(nroViaje, fechaPartida, peso, peones, requiereCustodiaSatelital, costo, vehiculo, peajes);
		this.distancia = distancia;
		this.localidades = localidades;
	}

	public double getDistancia() {
		
		return distancia;
		
	};

	public Calendar getFechaLlegada() {
		
		return fechaLlegada;
		
	};

	public void setDistancia(double distancia) {
		
		this.distancia = distancia;
		
	};

	public void setFechaLlegada(Calendar fechaLlegada) {
		
		this.fechaLlegada = fechaLlegada;
		
	}

	public ArrayList<String> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(ArrayList<String> localidades) {
		this.localidades = localidades;
	}

	@Override
	public double calcularCostoTotal() {
		
		if(distancia > distanciaMax){
			
			double kmExtras = distancia - distanciaMax;
			
			return (costo + (costo * (((int)((distancia - distanciaMax)/incrementoCadaKm))* incrementoSuperaKm)));
		}
		return costo;
	}
	
}

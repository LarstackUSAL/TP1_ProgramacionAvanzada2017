package ar.edu.usal.programacion.tp1;

import java.util.ArrayList;
import java.util.Calendar;

public class ViajesCorta extends Viajes {
			
	private boolean esEfectivo;

	public ViajesCorta() {};
	
	public ViajesCorta(int nroViaje, Calendar fechaPartida, double peso,
			Peones[] peones, boolean requiereCustodiaSatelital, double costo,
			Camiones vehiculo, ArrayList<Peajes> peajes, boolean esEfectivo) {
		
		super(nroViaje, fechaPartida, peso, peones, requiereCustodiaSatelital, costo, vehiculo, peajes);
		this.setEsEfectivo(esEfectivo);
	}

	public boolean isEsEfectivo() {
		return esEfectivo;
	}

	public void setEsEfectivo(boolean esEfectivo) {
		this.esEfectivo = esEfectivo;
	}

	@Override
	public double calcularCostoTotal() {
		
		if(esEfectivo){
			
			return costo - (costo * descuentoEfectivo);
		}
		return costo;
	}

	
}

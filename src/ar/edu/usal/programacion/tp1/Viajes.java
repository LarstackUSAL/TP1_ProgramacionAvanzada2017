package ar.edu.usal.programacion.tp1;

import java.util.Calendar;

public abstract class Viajes {
	
	public static final int MAX_PEONES = 5;
	public static final int MAX_PEAJES = 10;
	
	protected int nroViaje;
	protected Calendar fechaPartida;
	protected double peso;
	protected Peones[] peones = new Peones[MAX_PEONES];
	protected boolean custodiaSatelital;
	protected double costo;
	protected Camiones vehiculo;
	protected Peajes[] peajes = new Peajes[MAX_PEAJES];
	protected double costoTotal; //atributo calculado
	
	public Viajes() {
		
		for(int i = 0; i < peajes.length; i++) {
			
			peajes[i] = new Peajes();
			
		}
		
	};

	public Viajes(int nroViaje, Calendar fechaPartida, double peso, Peones[] peones, boolean custodiaSatelital, double costo,
			Camiones vehiculo, double costoTotal) {
		
		this.nroViaje = nroViaje;
		this.fechaPartida = fechaPartida;
		this.peso = peso;
		this.peones = peones;
		this.custodiaSatelital = custodiaSatelital;
		this.costo = costo;
		this.vehiculo = vehiculo;
		this.costoTotal = costoTotal;
		
		for(int i = 0; i < peajes.length; i++) {
			
			peajes[i] = new Peajes();
			
		}
		
	};

	public int getNroViaje() {
		
		return nroViaje;
		
	};

	public Calendar getFechaPartida() {
		
		return fechaPartida;
		
	};

	public double getPeso() {
		
		return peso;
		
	};

	public Peones[] getPeones() {
		
		return peones;
		
	};

	public boolean isCustodiaSatelital() {
		
		return custodiaSatelital;
		
	};

	public double getCosto() {
		
		return costo;
		
	};

	public Camiones getVehiculo() {
		
		return vehiculo;
		
	};

	public Peajes[] getPeajes() {
		
		return peajes;
		
	};

	public double getCostoTotal() {
		
		return costoTotal;
		
	};

	public void setNroViaje(int nroViaje) {
		
		this.nroViaje = nroViaje;
		
	};

	public void setFechaPartida(Calendar fechaPartida) {
		
		this.fechaPartida = fechaPartida;
		
	};

	public void setPeso(double peso) {
		
		this.peso = peso;
		
	};

	public void setPeones(Peones[] peones) {
		
		this.peones = peones;
		
	};

	public void setCustodiaSatelital(boolean custodiaSatelital) {
		
		this.custodiaSatelital = custodiaSatelital;
		
	};

	public void setCosto(double costo) {
		
		this.costo = costo;
		
	};

	public void setVehiculo(Camiones vehiculo) {
		
		this.vehiculo = vehiculo;
		
	};

	public void setPeajes(int posicion, String lugar, double importe) {
		
		peajes[posicion].setLugar(lugar);
		peajes[posicion].setImporte(importe);
		
	};

	public void setCostoTotal(double costoTotal) {
		
		this.costoTotal = costoTotal;
		
	};

}
